
public class Dragon extends Thread{

	int num;
	public static long time = System.currentTimeMillis();
	boolean game = false;
	//Adventurers Adv;

	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+":"+m);
	}
	
	boolean game(){
		int d_dice = (int) (Math.random()*6 +1);
		int a_dice = (int) (Math.random()*6 +1);
		msg("Adventurer have " + a_dice + " while Dragon have " + d_dice);
		if(d_dice >= a_dice){
			return false;
		}
		return true;
	}
	
	void giverandItem(){
		int random = (int)(Math.random()*3);
		if(random == 0){
			Main.adventures[Adventurers.anum].item[Adventurers.anum].stones++;
			msg("Gives stone.");
		}
		else if(random == 1){
			Main.adventures[Adventurers.anum].item[Adventurers.anum].earrings++;
			msg("Gives earring.");
		}
		else if(random == 2){
			Main.adventures[Adventurers.anum].item[Adventurers.anum].necklaces++;
			msg("Gives necklace.");
		}
		else{
			Main.adventures[Adventurers.anum].item[Adventurers.anum].rings++;
			msg("Gives ring.");
		}
	}
	public Dragon(int id){
		setName("Dragon-" + id);
		msg("Hi I am the Dragon");
		num = id;
	}
	
	public void run(){
		
			//for(int i = 1; i<= Main.num_adv; i++){
			if(Main.adventures[Adventurers.anum].isInterrupted()){
			msg("Let's play a game.");
			if(game()){
				msg("I lost, here is a gift for you.");
				giverandItem();
				game = true;
				if(Main.adventures[Adventurers.anum].checkitem()){
					Main.adventures[Adventurers.anum].need_item = false;
				}
			}
			else{
				msg("You lost, I'll let you play 1 more time");
				Main.adventures[Adventurers.anum].setPriority(1);
				if(game()){
					msg("I lost, here is a gift for you.");
					giverandItem();
					game = true;
					if(Main.adventures[Adventurers.anum].checkitem()){
						Main.adventures[Adventurers.anum].need_item = false;
					}
				}
			}
		//}
			}
			
		//}
	}
}

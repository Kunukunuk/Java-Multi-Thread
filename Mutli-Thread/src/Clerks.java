
public class Clerks extends Thread{

	//Adventurers Adv;
	int c_num;
	boolean isBusy = false;
	public static long time = System.currentTimeMillis();
	

	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+":"+m);
	}
	
	
	public Clerks(int id){
		setName("Clerks-" + id);
		msg( getName() + " Ready to work");
		c_num = id;
	}
	
	
	
	public void combine(){
		while(Main.adventures[Adventurers.anum].item[Adventurers.anum].stones >=1){
			if(Main.adventures[Adventurers.anum].item[Adventurers.anum].rings >=1){
				msg(getName()+ " Magical ring created for Adventurers " + Adventurers.anum);
				Main.adventures[Adventurers.anum].adv_fortune++;
				Main.adventures[Adventurers.anum].item[Adventurers.anum].rings--;
			}
			else if(Main.adventures[Adventurers.anum].item[Adventurers.anum].earrings >=2){
				msg(getName() + " Magical earring created for Adventurers " + Adventurers.anum);
				Main.adventures[Adventurers.anum].adv_fortune++;
				Main.adventures[Adventurers.anum].item[Adventurers.anum].earrings-=2;
			}
			else if(Main.adventures[Adventurers.anum].item[Adventurers.anum].necklaces >=1){
				msg(getName() + " Magical necklaces created for Adventurers " + Adventurers.anum);
				Main.adventures[Adventurers.anum].adv_fortune++;
				Main.adventures[Adventurers.anum].item[Adventurers.anum].necklaces--;
			}
			Main.adventures[Adventurers.anum].item[Adventurers.anum].stones--;
		}
	}
	
	public void run(){
		
		
		//for(int i = 0; i < Main.num_clerk; i++){
			while(!Main.clerk[c_num].isBusy){
				if(Main.adventures[Adventurers.anum].need_assistance && Main.adventures[Adventurers.anum].isInterrupted()){
					Main.clerk[c_num].isBusy = true;
					combine();
					Main.adventures[Adventurers.anum].need_assistance = false;
				
				}
			}
			Main.clerk[c_num].isBusy = false;
		//}
	}
	
}

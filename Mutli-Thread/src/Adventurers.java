
public class Adventurers extends Thread{
	
	int adv_fortune = 0;
	Items item[] = new Items[Main.num_adv +1];
	boolean need_assistance = false;
	boolean need_item = true;
	int num;
	static int anum;
	
	
	int random_time = (int) (Math.random());

	public void msg(String m) {
		System.out.println("["+(System.currentTimeMillis()-Main.time)+"] "+getName()+":"+m);
	}
	
	public boolean checkitem(){
		if(item[num].stones >= 1 && (item[num].rings >= 1 || item[num].necklaces >= 1 || item[num].earrings >=2)){
			return true;
		}
		return false;
	}
	public Adventurers(int id){
		setName("Adventurers-" + id);
		msg("Arrived");
		num = id;
		anum = id;
		item[id] = new Items();
		msg("I have " + item[id].stones + " stones," + item[id].rings + " rings," + item[id].earrings + " earrings," + item[id].necklaces + " necklaces.");

	}
	
	public void run(){
		while(Main.fortune_size > adv_fortune){
			if(checkitem()){
				try {
					msg("I go to shop");
					need_item = false;
					need_assistance = true;
					sleep(random_time);
					
				} catch (InterruptedException e) {
					
				}
				interrupt();
				if(isInterrupted()){
					
					while(item[num].stones >=1){
						if(item[num].rings >=1){
							msg("Magical ring created for Adventurers " + num);
							adv_fortune++;
							item[num].rings--;
						}
						else if(item[num].earrings >=2){
							msg("Magical earring created for Adventurers " + num);
							adv_fortune++;
							item[num].earrings-=2;
						}
						else if(item[num].necklaces >=1){
							msg("Magical necklaces created for Adventurers " + num);
							adv_fortune++;
							item[num].necklaces--;
						}
						item[num].stones--;
					}
				}
			}
			msg("Go to Mountain, My fortune size is " + adv_fortune);
			//need_item = true;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
			}
			interrupt();
			if(isInterrupted()){
				msg("Nice to meet you Dragon");
				
				if(Main.d.game()){
					item[num].increase();
					msg("I won");
				}
				else{
					setPriority(1);
					if(Main.d.game()){
						item[num].increase();
						msg("I won at 2nd try");
					}
					else
						yield();
				}
			}
			msg("I have " + item[num].stones + " stones," + item[num].rings + " rings," + item[num].earrings + " earrings," + item[num].necklaces + " necklaces.");
			
		}
		
			msg("Gets ready to leave town");
			if(Main.adventures[num].isAlive()){
				
					try {
						Main.adventures[num].join();
					} catch (InterruptedException e) {
						
					}
				}
			
			msg("Leaves town");
	}
	
}

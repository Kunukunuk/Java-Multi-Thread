
public class Main {
	
	public static long time = System.currentTimeMillis();
	static int num_adv = 6;
	static int fortune_size = 5;
	static int num_clerk =2;
	static Adventurers adventures[];
	static Clerks clerk[];
	static Dragon d;
	public static void main(String[] args){
		
		if(args.length == 3){
			try{
	
				num_adv = Integer.parseInt(args[0]);
				fortune_size = Integer.parseInt(args[1]);
				num_clerk = Integer.parseInt(args[2]);

			}catch(IllegalArgumentException e){
				System.err.println("Wrong input paramater info" + e.getMessage());
			}
		}
		
		clerk = new Clerks[num_clerk+1];
		adventures = new Adventurers[num_adv +1];

		for(int i = 1; i <= num_adv; i++){
			adventures[i] = new Adventurers(i);
			adventures[i].start();
		}
		for(int i = 1; i <= num_clerk; i++){
			clerk[i] = new Clerks(i);
			clerk[i].start();
		}
		
		d = new Dragon(1);
		d.start();
		
	}
	
}


public class Items {

	int stones, rings, earrings, necklaces;
	int randItem(){
		int items = (int)(Math.random()*3);
		return items;
	}
	
	void increase(){
		int num = randItem();
		if(num == 0){
			stones++;
		}
		else if(num == 1){
			rings++;
		}
		else if( num == 2){
			earrings++;
		}
		else{
			necklaces++;
		}
	}
	
	public Items(){
		this.stones = randItem();
		this.rings = randItem();
		this.earrings = randItem();
		this.necklaces = randItem();
	}
}

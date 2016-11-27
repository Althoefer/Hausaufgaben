import java.util.Arrays;

public class Blatt {
	private int[] blatt;
	
	/**
	 * one and only constuctor for this class. 
	 * @param newBlatt
	 * 			initializes the attribute blatt[]
	 */
	public Blatt(int[] newBlatt){
		//blatt has to have the length 3
		if(newBlatt.length != 3){
			throw new IllegalArgumentException("Blatt zu gross/klein");
		}
		//checks if all values in the field are valid, between 2 and 14
		//throws an IllegalArgumentException if this is not the case
		for(int i=0; i<3; i++){
			if(newBlatt[i] >= 2 && newBlatt[i] <= 14){
				
			} else{
				throw new IllegalArgumentException("zahlen im Blatt zu gross/klein");
			}
		}
		this.blatt = newBlatt.clone();
	}
	
	/**
	 * @return
	 * 		returns the values of the attribut blatt
	 */
	public String toString(){
		String ret = Arrays.toString(blatt);
		//trims the normal Arrays.toString() method and removes the []
		return ret.substring(1, ret.length() -1);
	}
	
	/**
	 * 
	 * @return
	 * 		returns a copy of the attribute blatt
	 */
	public int[] getBlatt(){
		return blatt.clone();
	}
}

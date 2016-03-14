/**
 * Author: Sammy Chen, FCU
 */
package findbugs;

public class FindBugsDemo1 {
		
	private static final String MY_GF_NAME = "Mary";

	public  boolean loveForever(String nameOfGirl) {		
		if(nameOfGirl  == MY_GF_NAME ) 
			return true;
		return false;
		
	}
	
	public static void main(String[] args ) {
		
		FindBugsDemo1 lb1 = new FindBugsDemo1();
		boolean  forever = lb1.loveForever(new String("Mary"));
		System.out.println("I Love Mary: " + forever);		
	}
}
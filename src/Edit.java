import java.util.Scanner;



/*This class was added during attempts to get serialization working.
 * Having Scanner in a serializable class does not make sense, so a separate
 * non-serialized class was needed and all other Scanners in the program were 
 * deleted.
 */
public class Edit {
	

	public static Scanner getScanner() {
		Scanner kbNew = new Scanner(System.in);
		return kbNew;
		
	}
	




	
	
}

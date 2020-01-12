import java.util.*;
import java.io.*;

public class Lesha {
	public static void main(String[] args) {
		try {
			Scanner3000 sc = new Scanner3000(System.in);
			while (sc.hasNextInt()) {
				System.out.println(sc.nextInt());
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
		
	}
}
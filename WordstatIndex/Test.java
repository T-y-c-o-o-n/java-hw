import java.util.*;
import java.io.*;

public class Test {
	public static void main(String[] args) {
		try {
			Scanner3000 sc = new Scanner3000(System.in);
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		}  catch(IOException e) {
			System.out.print("IOException : ");
			System.out.println(args[1]);
		}
	}
}
import java.util.*;
import java.io.*;

public class Test {
	public static void main(String[] args) {
		try {
			Scanner3000 sc = new Scanner3000(System.in);
			ArrayList<String> ss = new ArrayList<String>();
			while (sc.hasNextLine()) {
				Scanner3000 sc1 = new Scanner3000(sc.nextLine());
				while (sc1.hasNext()) {
					ss.add(sc1.next());
				}
			}
			for (String s : ss) {
				System.out.print(s + " ");
			}
		} catch(IOException e) {

		}
	}
}
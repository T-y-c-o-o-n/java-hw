import java.util.*;
import java.io.*;

public class Reverse {
	public static void main(String[] args) {
		try {
			Scanner3000 sc = new Scanner3000(System.in);
			ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
			while(sc.hasNextLine()) {
				Scanner3000 sc1 = new Scanner3000(sc.nextLine());
				ArrayList<Integer> b = new ArrayList<Integer>();
				while (sc1.hasNextInt()) {
					b.add(sc1.nextInt());
				}
				if (b.size() > 0) {
					Collections.reverse(b);
				}
				a.add(b);
			}
			Collections.reverse(a);
			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < a.get(i).size(); j++) {
					System.out.print(a.get(i).get(j));
					System.out.print(" ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
		
	}
}
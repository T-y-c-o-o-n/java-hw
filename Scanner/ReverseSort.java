import java.util.*;
import java.io.*;

public class ReverseSort {
	public static void main(String[] args) {
		try {
			Scanner3000 sc = new Scanner3000(System.in);
			ArrayList<Pair> a = new ArrayList<Pair>();
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				Scanner3000 sc1 = new Scanner3000(s);
				ArrayList<Integer> b = new ArrayList<Integer>();
				while (sc1.hasNextInt()) {
					b.add(sc1.nextInt());
				}
				if (b.size() > 0) {
					Collections.sort(b);
					Collections.reverse(b);
				}
				a.add(new Pair(b));
			}
			Comparator<Pair> comp = new Comparator<Pair>() {
				public int compare(Pair a, Pair b) {
					return a.compareTo(b);
				}
			};
			Collections.sort(a, comp);
			Collections.reverse(a);
			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < a.get(i).second.size(); j++) {
					System.out.print(a.get(i).second.get(j));
					System.out.print(" ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("IOException!!");
		}
	}
}
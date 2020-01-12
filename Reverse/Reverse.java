import java.util.*;
public class Reverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[0][];
		int n = -1;
		while (sc.hasNextLine()) {
			n++;
			if (a.length - 1 < n) {
				a = Arrays.copyOf(a, (n + 1) * 2);
			}
			Scanner sc1 = new Scanner(sc.nextLine());
			int m = -1;
			while (sc1.hasNextInt()) {
				m++;
				if (a[n] == null) {
					a[n] = new int[]{sc1.nextInt()};
				} else {
					if (a[n].length - 1 < m) {
						a[n] = Arrays.copyOf(a[n], (m + 1) * 2);
					}
					a[n][m] = sc1.nextInt();
				}
			}
			if (m > -1) {
				a[n] = Arrays.copyOf(a[n], m + 1);
			}
		}
		a = Arrays.copyOf(a, n + 1);
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != null) {
				for (int j = a[i].length - 1; j >= 0; j--) {
					System.out.print(a[i][j]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
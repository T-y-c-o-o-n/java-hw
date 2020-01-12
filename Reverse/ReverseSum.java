import java.util.*;
public class ReverseSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<ArrayList<Integer>> a = new ArrayList();
		while(sc.hasNextLine()) {
			
		}


































		/*Scanner sc = new Scanner(System.in);
		int[][] a = new int[0][];
		int[] sum1 = new int[0];
		int[] sum2 = new int[0];
		int n = 0;
		int mm = 0;
		int cnt = 0;
		try {
			while (sc.hasNextLine()) {
				n++;
				if (a.length < n) {
					a = Arrays.copyOf(a, n * 2);
				}
				if (sum1.length < n) {
					sum1 = Arrays.copyOf(sum1, n * 2);
				}
				String s = new String();
				try {
					s = sc.nextLine();
				} catch(Exception e) {
					System.err.println(e.getMessage());
				}
				int l = 0;
				int r = 0;
				int m = 0;
				s += " ";
				while (l < s.length()) {
					while (l < s.length() - 1 && Character.isWhitespace(s.charAt(l))) {
						l++;
					}
					r = l;
					while (r < s.length() - 1 && !Character.isWhitespace(s.charAt(r))) {
							r++;
					}
					if (!Character.isWhitespace(s.charAt(l)) && !Character.isWhitespace(s.charAt(r - 1))) {
						cnt++;
						int val = Integer.parseInt(s.substring(l, r));
						m++;
						if (sum2.length < m) {
							sum2 = Arrays.copyOf(sum2, m * 2);
						}
						if (a[n - 1] == null) {
							a[n - 1] = new int[]{val};
						} else {
							if (a[n - 1].length < m) {
								a[n - 1] = Arrays.copyOf(a[n - 1], m * 2);
							}
							a[n - 1][m - 1] = val;
						}
						sum1[n - 1] += val;
						sum2[m - 1] += val;
					}
					l = r + 1;
				}
				if (mm < m) {
					mm = m;
				}
				if (m > 0) {
					a[n - 1] = Arrays.copyOf(a[n - 1], m);
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		a = Arrays.copyOf(a, n);
		sum1 = Arrays.copyOf(sum1, n);
		sum2 = Arrays.copyOf(sum2, mm);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < mm; j++) {
				if (a[i] != null && a[i].length > j) {
					System.out.print(sum1[i] + sum2[j] - a[i][j]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}*/
	}
}
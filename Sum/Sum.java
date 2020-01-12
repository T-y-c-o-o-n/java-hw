public class Sum {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			int l = 0;
			int r = 0;
			args[i] += " ";
			while (l < args[i].length()) {
				while (l < args[i].length() - 1 && Character.isWhitespace(args[i].charAt(l))) {
					l++;
				}
				r = l; // FIXME!
				while (r < args[i].length() - 1 && !Character.isWhitespace(args[i].charAt(r))) {
						r++;
				}
				if (!Character.isWhitespace(args[i].charAt(l)) && !Character.isWhitespace(args[i].charAt(r - 1))) {
					sum += Integer.parseInt(args[i].substring(l, r));
				}
				//System.out.println(args[i] + l + " " + r);
				l = r + 1;
			}
			//sum += Integer.parseInt(args[i]);
			//System.out.println(args[i] + " " + sum);
		}

		System.out.println(sum);
	}
}
public class SumLongHex {
	public static void main(String[] args) {
		long sum = 0;
		System.out.println(args[0]);
		
		for (int i = 0; i < args.length; i++) {
			int l = 0;
			int r = 0;
			while (l < args[i].length()) {
				while (l < args[i].length() - 1 && Character.isWhitespace(args[i].charAt(l))) {
					l++;
				}
				r = l;
				while (r < args[i].length() - 1 && !Character.isWhitespace(args[i].charAt(r))) {
						r++;
				}
				if (!Character.isWhitespace(args[i].charAt(l)) && !Character.isWhitespace(args[i].charAt(r - 1))) {
					if (r - l > 2) {
						if (args[i].charAt(l) == '0' && (args[i].charAt(l + 1) == 'x' || args[i].charAt(l + 1) == 'X')) {
							l += 2;
							sum += Long.parseUnsignedLong(args[i].substring(l, r), 16);
						} else if (args[i].charAt(l) == '-' && args[i].charAt(l + 1) == '0' && (args[i].charAt(l + 2) == 'x' || args[i].charAt(l + 2) == 'X')) {
							l += 3;
							sum -= Long.parseLong(args[i].substring(l, r), 16); 
						} else {
							sum += Long.parseLong(args[i].substring(l, r));
						}
					} else {
						sum += Long.parseLong(args[i].substring(l, r));
					}
				}
				l = r + 1;
			}
		}
		System.out.println(sum);
	}
}
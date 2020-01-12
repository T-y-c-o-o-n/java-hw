import java.util.*;
import java.io.*;

public class WordStatInput {  // БЭКАП

	public static boolean is_letter(char c) {
		if (Character.isLetter(c) || c == '\'' || Character.getType(c) == Character.DASH_PUNCTUATION) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0])), "utf8"), 1024);
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1])), "utf8"), 1024));) {
			Map<String, Integer> hashMap = new LinkedHashMap<String, Integer>();
			StringBuilder cc = new StringBuilder();
			int c0 = in.read();
			while(c0 != -1) {  // считываем
				char c = (char)c0;
				c = Character.toLowerCase(c);
				cc.append(c);
				
				c0 = in.read();
			}
			String s = cc.toString();
			int l = 0;
			int r = 0;
			while (l < s.length()) {  // парсим
				while (l < s.length() - 1 && !is_letter(s.charAt(l))) {
					l++;
				}
				r = l;
				while (r < s.length() - 1 && is_letter(s.charAt(r))) {
						r++;
				}
				if (is_letter(s.charAt(l)) && is_letter(s.charAt(r - 1))) {
					if (hashMap.get(s.substring(l, r)) == null) {
						hashMap.put(s.substring(l, r), 1);
					} else {
						hashMap.put(s.substring(l, r), hashMap.get(s.substring(l, r)) + 1);
					}
				}
				l = r + 1;
			}
			List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
		    list = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
		    for (Map.Entry<String, Integer> me : list) {
		    	out.print(me.getKey());
		    	out.print(" ");
		    	out.print(me.getValue());
		    	out.print("\n");
		    }
		} catch(FileNotFoundException e) {
			System.out.print("File not found : ");
			System.out.println(args[1]);
		} catch(IOException e) {
			System.out.print("IOException : ");
			System.out.println(args[1]);
		}
	}
}
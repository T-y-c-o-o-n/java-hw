import java.util.*;
import java.io.*;

public class WordStatCount {

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
				char c = Character.toLowerCase((char)c0);
				if (is_letter(c)) {
					cc.append(c);
				} else if (cc.length() > 0) {
					String s = cc.toString();
					if (hashMap.get(s) == null) {
						hashMap.put(s, 1);
					} else {
						hashMap.put(s, hashMap.get(s) + 1);
					}
					cc = new StringBuilder();
				}
				c0 = in.read();
			}
			List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
			Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
					return a.getValue().compareTo(b.getValue());
				}
			};
			Collections.sort(list, comp);
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
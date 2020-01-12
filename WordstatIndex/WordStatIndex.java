import java.util.*;
import java.io.*;

public class WordStatIndex {
	public static void main(String[] args) {
		Map<String, IntList> hashMap = new LinkedHashMap<String, IntList>();
		try (Scanner3000 sc = new Scanner3000(new File(args[0]))) {
			int pos = 0;
			while(sc.hasNext()) {
				String s = sc.next().toLowerCase();
				pos++;
				if (hashMap.get(s) == null) {
					hashMap.put(s, new IntList(pos));
				} else {
					hashMap.get(s).add(pos);
				}
			}
		} catch(FileNotFoundException e) {
			System.out.print("File not found : " + args[0]);
		} catch(IOException e) {
			System.out.print("IOException : " + args[0]);
		}
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1])), "utf8"), 1024))) {
			List<Map.Entry<String, IntList>> list = new ArrayList<Map.Entry<String, IntList>>(hashMap.entrySet());
		    for (Map.Entry<String, IntList> me : list) {
		    	String ss = me.getKey();
		    	IntList a = me.getValue();
		    	out.print(ss);
		    	out.print(" ");
		    	out.print(a.getCount());
		    	while (a.hasNextInt()) {
		    		out.print(" ");
		    		out.print(a.nextInt());
		    	}
		    	out.println();
		    }
		} catch(FileNotFoundException e) {
			System.out.print("File not found : " + args[1]);
		} catch(IOException e) {
			System.out.print("IOException : " + args[1]);
		}
		
	}
}
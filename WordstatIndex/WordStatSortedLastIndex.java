import java.util.*;
import java.io.*;

public class WordStatSortedLastIndex {
	public static void main(String[] args) {
		try (Scanner3000 sc = new Scanner3000(new FileInputStream(args[0]));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1])), "utf8"), 1024))) {
			Map<String, List<MyList>> treeMap = new TreeMap<String, List<MyList>>();
			HashSet<String> str_temp;
			while (sc.hasNextLine()) {
				int pos = 0;
				str_temp = new HashSet<String>();
				Scanner3000 sc1 = new Scanner3000(sc.nextLine());
				while(sc1.hasNext()) {
					String s = sc1.next().toLowerCase();
					pos++;
					if (str_temp.contains(s)) {
						treeMap.get(s).get(1).changeLast(pos);
					} else if (treeMap.get(s) != null) {
						str_temp.add(s);
						treeMap.get(s).get(1).add(pos);
					} else {
						str_temp.add(s);
					}
					if (treeMap.get(s) == null) {
						treeMap.put(s, List.of(new IntList(pos), new IntList(pos)));
					} else {
						treeMap.get(s).get(0).add(pos);
					}
				}
			}
			List<Map.Entry<String, List<MyList>>> list = new ArrayList<Map.Entry<String, List<MyList>>>(treeMap.entrySet());
		    for (Map.Entry<String, List<MyList>> me : list) {
		    	String ss = me.getKey();
		    	List<MyList> a = me.getValue();
		    	out.print(ss + " " + a.get(0).getCount());
		    	while (a.get(1).hasNextInt()) {
		    		out.print(" " + a.get(1).nextInt());
		    	}
	    		out.println();
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
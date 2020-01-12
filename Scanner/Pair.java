import java.util.*;
import java.io.*;

public class Pair implements Comparable<Pair> {
	private long first;  // сумма элементов строки
	public ArrayList<Integer> second;  // элементы строки
	public Pair(ArrayList<Integer> b) {
		first = 0;
		second = b;
		for (int val : second) {
			first += (long)val;
		}
	}
	public void add(int new_val) {
		second.add(new_val);
		first += (long)new_val;
	}
	@Override
	public int compareTo(Pair another) {
		if (first > another.first) {
			return 1;
		} else if (first == another.first) {
			return 0;
		} else {
			return -1;
		}
	}
}
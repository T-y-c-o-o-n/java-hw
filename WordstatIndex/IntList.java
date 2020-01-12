import java.util.*;

public class IntList implements MyList {
	private int s = 0;
	private int c = 2;
	private int[] ints = new int[2];
	private int pnt = 0;
	public IntList(int pos) {
		add(pos);
	}
	public void add(int pos) {
		ints[s] = pos;
		s++;
		if (s == c) {
			incCapacity();
		}
	}
	public int getCount() {
		return s;
	}
	public int nextInt() {
		return ints[pnt++];
	}
	public boolean hasNextInt() {
		return pnt < s;
	}
	private void incCapacity() {
		ints = Arrays.copyOf(ints, c * 2);
		c *= 2;
	}
	public void changeLast(int pos) {
		ints[s-1] = pos;
	}
}
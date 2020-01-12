import java.util.*;

public class LastsList implements MyList {
	private int s_L = 0;
	private int c_L = 2;
	private int[] lasts = new int[2];
	private int pnt_L = 0;
	public LastsList(int pos) {
		add(pos);
	}
	public void add(int pos) {
		lasts[s_L] = pos;
		s_L++;
		if (s_L == c_L) {
			incCapacityLasts();
		}
	}
	public void changeLast(int pos) {
		lasts[s_L-1] = pos;
	}
	public int nextInt() {
		return lasts[pnt_L++];
	}
	public boolean hasNextInt() {
		return pnt_L < s_L;
	}
	private void incCapacityLasts() {
		lasts = Arrays.copyOf(lasts, c_L * 2);
		c_L *= 2;
	}
	public int getCount() {
		return s_L;
	}
}
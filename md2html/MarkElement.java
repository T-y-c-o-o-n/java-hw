package md2html;

public class MarkElement {
	private Mark type;
	private int pos;

	public MarkElement(Mark type, int pnt) {
		this.type = type;
		pos = pnt;
	}

	public Mark getType() {
		return type;
	}

	public int getPos() {
		return pos;
	}
}
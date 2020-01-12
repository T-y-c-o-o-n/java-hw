package markup;

import java.util.*;

public class Text implements InParagraph {
	private String text;
	public Text(String s) {
		text = s;
	}
	public void toMarkdown(StringBuilder sb) {
		sb.append(text);
	}
	public void toHtml(StringBuilder sb) {
		sb.append(text);
	}
}
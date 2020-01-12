package markup;

import java.util.*;

public class Emphasis extends Common implements InParagraph {
	public Emphasis(List<InParagraph> elements) {
		super(elements);
	}
	public void toMarkdown(StringBuilder sb) {
		super.toMarkdown(sb, "*", "*");
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<em>", "</em>");
	}
}
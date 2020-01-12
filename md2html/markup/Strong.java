package markup;

import java.util.*;

public class Strong extends Common implements InParagraph {
	public Strong(List<InParagraph> elements) {
		super(elements);
	}
	public void toMarkdown(StringBuilder sb) {
		super.toMarkdown(sb, "__", "__");
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<strong>", "</strong>");
	}
}
package markup;

import java.util.*;

public class Strikeout extends Common implements InParagraph {
	public Strikeout(List<InParagraph> elements) {
		super(elements);
	}
	public void toMarkdown(StringBuilder sb) {
		super.toMarkdown(sb, "~", "~");
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<s>", "</s>");
	}
}
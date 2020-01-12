package markup;

import java.util.*;

public class Paragraph extends Common implements InListItem {
	public Paragraph(List<InParagraph> parts) {
		super(parts);
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "", "");
	}
	public void toMarkdown(StringBuilder sb) {
		super.toMarkdown(sb, "", "");
	}
}
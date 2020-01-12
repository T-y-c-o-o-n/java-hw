package markup;

import java.util.*; 

public class OrderedList extends Common implements InListItem {
	public OrderedList(List<ListItem> items) {
		super(items);
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<ol>", "</ol>");
	}
	public void toMarkdown(StringBuilder sb) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("HA HA HA! this method is not not supported, Markdown for Loooooooooooseeeeeeeeers!!!!!!!!!!");
	}
}
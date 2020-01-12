package markup;

import java.util.*; 

public class OrderedList extends Common implements InListItem {
	public OrderedList(List<ListItem> items) {
		super(items);
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<ol>", "</ol>");
	}
	public void toMarkdown(StringBuilder sb) {
	}
}
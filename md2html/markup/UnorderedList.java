package markup;

import java.util.*;

public class UnorderedList extends Common implements InListItem {
	public UnorderedList(List<ListItem> items) {
		super(items);
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<ul>", "</ul>");

	}
}
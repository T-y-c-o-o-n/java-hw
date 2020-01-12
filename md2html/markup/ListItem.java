package markup;

import java.util.*;

public class ListItem extends Common implements ListObject {  // <li></li>
	public ListItem(List<InListItem> objects) {
		super(objects);
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<li>", "</li>");
	}
	public void toMarkdown(StringBuilder sb) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("HA HA HA! this method is not not supported, Markdown for Loooooooooooseeeeeeeeers!!!!!!!!!!");
	}
}
package markup;

import java.util.*;

public class ListItem extends Common {  // <li></li>
	public ListItem(List<InListItem> objects) {
		super(objects);
	}
	public void toHtml(StringBuilder sb) {
		super.toHtml(sb, "<li>", "</li>");
	}
	@Deprecated
	public void toMarkdown(StringBuilder sb) {
	}
}
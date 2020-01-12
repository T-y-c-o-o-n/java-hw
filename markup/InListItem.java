package markup;

import java.util.*;

public interface InListItem extends Commoninterface {
	public void toHtml(StringBuilder sb);
	public void toMarkdown(StringBuilder sb);
}
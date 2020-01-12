package markup;

import java.util.*;

public abstract class Common implements Commoninterface {
	protected List<? extends Commoninterface> texts;
	public Common(List<? extends Commoninterface> list) {
		texts = list;
	}
	public void toMarkdown(StringBuilder sb, String left, String right) {
		sb.append(left);
		for (var s : texts) {
			s.toMarkdown(sb);
		}
		sb.append(right);
	}
	public void toHtml(StringBuilder sb, String left, String right) {
		sb.append(left);
		for (var s : texts) {
			s.toHtml(sb);
		}
		sb.append(right);
	}
}

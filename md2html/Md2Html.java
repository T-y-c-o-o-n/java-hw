package md2html;

import java.util.*;
import java.io.*;

public class Md2Html {
	public static Map<String, String> tag = new HashMap<>(Map.of(
			"*", "em",
			"_", "em",
			"**", "strong",
			"__", "strong",
			"--", "s",
			"`", "code",
			"<", "&lt;",
			">", "&gt;",
			"&", "&amp;"
	));

	public static Map<Mark, Boolean> was = new HashMap(Map.of(
		Mark.EMPHASIS1, false,
		Mark.EMPHASIS2, false,
		Mark.STRONG1, false,
		Mark.STRONG2, false,
		Mark.STRIKEOUT, false,
		Mark.CODE, false,
		Mark.IMAGE, false
	));

	public static Stack<MarkElement> st = new Stack<MarkElement>();
	public static StringBuilder result = new StringBuilder();
	
	public static int checkHeader(StringBuilder temp) {
		int pnt = 0;
		while (pnt < temp.length() && temp.charAt(pnt) == '#') {
			pnt++;
		}
		if (pnt == 0 || temp.length() <= pnt || !Character.isWhitespace(temp.charAt(pnt))) {
			pnt = 0;
		}
		return pnt;
	}

	public static int checkImage(int pos) {
		int pntNameLeft = pos + 1, pntNameRight = pntNameLeft;
		while (pntNameRight < result.length() && result.charAt(pntNameRight) != ']') {
			pntNameRight++;
		}
		int pntSrcLeft = pntNameRight + 1, pntSrcRight = pntSrcLeft;
		while (pntSrcRight < result.length() && result.charAt(pntSrcRight) != ')') {
			pntSrcRight++;
		}
		if (pntNameLeft < result.length() && pntNameRight < result.length() && pntSrcLeft < result.length() && pntSrcRight < result.length() &&
			result.charAt(pntNameLeft) == '[' && result.charAt(pntNameRight) == ']' && result.charAt(pntSrcLeft) == '(' && result.charAt(pntSrcRight) == ')') {
			String newStr = "<img alt=\'" + result.substring(pntNameLeft + 1, pntNameRight) + "\' src=\'" + result.substring(pntSrcLeft + 1, pntSrcRight) + "\'>";
			result.replace(pos, pntSrcRight + 1, newStr);
			int delta = newStr.length();
			return pos + delta;
		}
		return pos + 1;
	}
	
	public static int singleMark(String key, Mark mark, int pos) {
		if (was.get(mark)) {
			while (st.peek().getType() != mark) {
				st.pop();
			}
			String newStr = "<" + tag.get(key) + ">" + result.substring(st.peek().getPos() + 1, pos) + "</" + tag.get(key) + ">";
			result.replace(st.peek().getPos(), pos + 1, newStr);
			int delta = (newStr.length()) - (pos + 1 - st.peek().getPos());
			st.pop();
			was.put(mark, false);
			return pos + delta + 1;
		} else {
			was.put(mark, true);
			st.push(new MarkElement(mark, pos));
			return pos + 1;
		}
	}

	public static int doubleMark(String key, Mark mark, int pos) {
		if (was.get(mark)) {
			while (st.peek().getType() != mark) {
				st.pop();
			}
			String newStr = "<" + tag.get(key) + ">" + result.substring(st.peek().getPos() + 2, pos) + "</" + tag.get(key) + ">";
			result.replace(st.peek().getPos(), pos + 2, newStr);
			int delta = (newStr.length()) - (pos + 2 - st.peek().getPos());
			st.pop();
			was.put(mark, false);
			return pos + delta + 2;
		} else {
			was.put(mark, true);
			st.push(new MarkElement(mark, pos));
			return pos + 2;
		}
	}

	public static int htmlSymbol(String key, int pos) {
		result.replace(pos, pos + 1, tag.get(key));
		return pos + tag.get(key).length();
	}
	
	public static int checkMark(int pos) {
		if (pos > 0 && result.charAt(pos - 1) == '\\') {
			result.replace(pos - 1, pos + 1, result.substring(pos, pos + 1));
			return pos;

		}
		if (result.charAt(pos) == '*') {
			if (pos < result.length() - 1 && result.charAt(pos + 1) == '*') {
				return pos = doubleMark("**", Mark.STRONG1, pos);
			} else {
				return pos = singleMark("*", Mark.EMPHASIS1, pos);
			}
		} else if (result.charAt(pos) == '_') {
			if (pos < result.length() - 1 && result.charAt(pos + 1) == '_') {
				return pos = doubleMark("__", Mark.STRONG2, pos);
			} else {
				return pos = singleMark("_", Mark.EMPHASIS2, pos);
			}
		} else if (result.charAt(pos) == '-' && pos < result.length() - 1 && result.charAt(pos + 1) == '-') {
			return pos = doubleMark("--", Mark.STRIKEOUT, pos);
		} else if (result.charAt(pos) == '`') {
			return pos = singleMark("`", Mark.CODE, pos);
		} else if (result.charAt(pos) == '<' || result.charAt(pos) == '>' || result.charAt(pos) == '&') {
			return pos = htmlSymbol(result.substring(pos, pos + 1), pos);
		} else if (result.charAt(pos) == '!') {
			return pos = checkImage(pos);
		}
		return pos + 1;
	}

	public static String parseParagraph(StringBuilder tempPar) {
		int headerLevel  = 0;
		int pnt = checkHeader(tempPar);
		if (pnt > 0) {
			headerLevel = pnt;
			pnt++;
		}
		result = new StringBuilder(tempPar.toString().substring(pnt));

		pnt = 0;
		while (pnt < result.length()) {
			pnt = checkMark(pnt);
		}
		st = new Stack<MarkElement>();
		was = new HashMap(Map.of(
			Mark.EMPHASIS1, false,
			Mark.EMPHASIS2, false,
			Mark.STRONG1, false,
			Mark.STRONG2, false,
			Mark.STRIKEOUT, false,
			Mark.CODE, false,
			Mark.IMAGE, false
		));
		if (headerLevel > 0) {
			tempPar = new StringBuilder("<h" + headerLevel + ">" +
										result.toString() +
										"</h" + headerLevel + ">");
		} else {
			tempPar = new StringBuilder("<p>" + 
										result.toString() +
										"</p>");
		}
		return tempPar.toString();
	}

	public static void main (String[] args) {
		try (Scanner3000 sc = new Scanner3000(new File(args[0]));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1])), "utf8")))) {
			List<String> paragraphs = new ArrayList<String>();
			StringBuilder tempPar = new StringBuilder();
			while (sc.hasNextLine()) {
				String tempStr = sc.nextLine();
				if (tempStr.isEmpty()) {
					if (tempPar.length() > 0) {
						tempPar.deleteCharAt(tempPar.length() - 1);
						String newPar = parseParagraph(tempPar);
						tempPar = new StringBuilder();
						paragraphs.add(newPar);
					} else {
						continue;
					}
				} else {
					tempPar.append(tempStr);
					tempPar.append("\n");
				}
			}
			if (tempPar.length() > 0) {
				tempPar.deleteCharAt(tempPar.length() - 1);
				String newPar = parseParagraph(tempPar);
				paragraphs.add(newPar);
			}
			for (String par : paragraphs) {
				out.println(par);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
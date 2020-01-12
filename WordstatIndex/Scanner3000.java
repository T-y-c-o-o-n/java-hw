import java.util.*;
import java.io.*;

public class Scanner3000 implements AutoCloseable {
	private int c = (int)'\n';
	private final Reader reader;

	public Scanner3000(InputStream source) throws IOException {
		reader = new BufferedReader(new InputStreamReader(source, "utf8"), 1024);
	}

	public Scanner3000(String s) throws IOException {
		reader = new StringReader(s);
	}

	public Scanner3000(File file) throws IOException {
        reader = new InputStreamReader(new FileInputStream(file), "utf8");
    }

	public Scanner3000(FileInputStream s) throws IOException {
        reader = new InputStreamReader(s, "utf8");
    }

	public boolean hasNextLine() throws IOException {
		if ((char)c == '\r' || (char)c == '\n') {
			nextChar();
		}
		if ((char)c == '\r' || (char)c == '\n') {
			nextChar();
		}
		if (c == -1) {
			return false;
		} else {
			return true;
		}
	}

	public String nextLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		while (c != -1 && (char)c != 10 && (char)c != 13) {
			sb.append((char)c);
			nextChar();
		}
		return sb.toString();
	}

	public boolean hasNextInt() throws IOException {
		skipIntSeparators();
		if (is_Digit(c)) {
			return true;
		} else {
			return false;
		}
	}

	public int nextInt() throws IOException {
		skipIntSeparators();
		StringBuilder sb = new StringBuilder();
		while (c != -1 && !isIntSeparator((char)c)) {
			sb.append((char)c);
			nextChar();
		}
		int val = 0;
		try {
			val = Integer.parseInt(sb.toString());
		} catch(NumberFormatException e) {
			throw new NumberFormatException ("NumberFormatException!!");
		} finally {
			return val;
		}
	}

	public boolean hasNext() throws IOException {
		skipWordSeparators();
		if (c != -1) {
			return true;
		} else {
			return false;
		}
	}

	public String next() throws IOException {
		skipWordSeparators();
		StringBuilder sb = new StringBuilder();
		while (c != -1 && !isWordSeparator((char)c)) {
			sb.append((char)c);
			nextChar();
		}
		return sb.toString();
	}

	public void close() throws IOException {
		reader.close();
	}

	private void nextChar() throws IOException {
		c = reader.read();
	}

	private void skipIntSeparators() throws IOException {
		while (isIntSeparator(c) && c != -1) {
			nextChar();
		}
	}

	private void skipWordSeparators() throws IOException {
		while (isWordSeparator(c) && c != -1) {
			nextChar();
		}
	}

	private boolean isIntSeparator (int a) {
		return !is_Digit(a);
	}

	private boolean isWordSeparator (int a) {
		return !is_Letter(a);
	}

	private boolean is_Letter(int a) {
		return (Character.isLetter((char)a) || (char)a == '\'' || Character.getType((char)a) == Character.DASH_PUNCTUATION);
	}

	private boolean is_Digit(int a) {
		return (Character.isDigit((char)a) || (char)a == '-');
	}
}
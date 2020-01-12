import java.util.*;
import java.io.*;

public class Scanner3000 implements Closeable {
	private int c = 10;
	private final Reader reader;

	public Scanner3000(InputStream source) throws IOException {
		reader = new BufferedReader(new InputStreamReader(source, "utf8"), 1024);
		// nextChar();
	}

	public Scanner3000(String s) throws IOException {
		reader = new StringReader(s);
		// nextChar();

	}

	public boolean hasNextLine() throws IOException {
		if (c == 13 || c == 10) {
			nextChar();
		}
		if (c == 13 || c == 10) {
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
		while (c != -1 && c != 10 && c != 13) {
			sb.append((char)c);
			nextChar();
		}
		return sb.toString();
	}

	public boolean hasNextInt() throws IOException {
		return hasNext();	
	}

	public int nextInt() throws IOException {
		if (hasNextInt()) {
			int val = 0;
			try {
				val = Integer.parseInt(next());
			} catch(NumberFormatException e) {
				throw new NumberFormatException ("NumberFormatException!!");
				// System.err.println("NumberFormatException!!");
			} finally {
				return val;
			}
		} else {
			return 0;
		}
	}

	public boolean hasNextLong() throws IOException {
		return hasNext();	
	}

	public long nextLong() throws IOException {
		if (hasNextLong()) {
			return Long.parseLong(next());
		} else {
			return 0l;
		}
	}

	public boolean hasNext() throws IOException {
		skipWhitespace();
		if (c != -1) {
			return true;
		} else {
			return false;
		}
	}

	public String next() throws IOException {
		skipWhitespace();
		StringBuilder sb = new StringBuilder();
		while (c != -1 && !isTokenSeparator((char)c)) {
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

	private void skipWhitespace() throws IOException {
		while (isTokenSeparator((char)c)) {
			nextChar();
		}
	}
	
	private boolean isTokenSeparator (int a) {
		return (Character.isWhitespace((char)a));
	}
}
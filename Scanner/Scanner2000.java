import java.util.*;
import java.io.*;

public class Scanner2000 {
	private Reader br;
	private int len;
	private int pnt;
	private char[] buffer = new char[65536];
	private boolean EOF = false;
	private int temp_int = 0;
	private boolean if_temp_int = false;

	public Scanner2000(InputStream source) throws IOException {  // конструктор
		br = new BufferedReader(new InputStreamReader(source));
	}

	public Scanner2000(String s) throws IOException {  // конструктор
		br = new StringReader(s);
	}

	public boolean hasNextInt() throws IOException {
		temp_int = nextInt();
		if_temp_int = true;
		return !EOF;
	}

	public int nextInt() throws IOException {
		if (if_temp_int) {
			if_temp_int = false;
			return temp_int;
		}
		skipWhitespace();
		StringBuilder sb = new StringBuilder();
		char c;
		while (hasNextChar()) {
			c = nextChar();
			if (Character.isDigit(c)) {
				sb.append(c);
			} else {
				if ((!Character.isWhitespace(c))) {
					throw new InputMismatchException("wrong char!");
				}
				break;
			}
		}
		return Integer.parseInt(sb.toString());
	}

	public boolean hasNextLine() throws IOException {
		return !EOF;
	}

	public String nextLine() throws IOException {
		StringBuilder s = new StringBuilder();
		//if (pnt >= len) {
		//	rebuffer();
		//}
		while (buffer[pnt] != '\n' || buffer[pnt] != '\r') {
			if (buffer[pnt] == '\r') {
				pnt++;
			}
			if (pnt >= len) {
				rebuffer();
			}
			s.append(buffer[pnt]);
			if (pnt >= len) {
				rebuffer();
			}
		}
		if (EOF) {
			return "";
		} else {
			return s.toString();
		}
	}

	public boolean hasNextChar() throws IOException {
		char c = nextChar();
		pnt--;
		return !EOF;
	}

	public char nextChar() throws IOException {
		if (pnt >= len) {
			rebuffer();
		}
		pnt++;
		return buffer[pnt];
	} 

	private void rebuffer() throws IOException {
		len = br.read(buffer);
		while (len == 0) {
			len = br.read(buffer);
		}
		if (len == -1) {
			EOF = true;
		}
		pnt = 0;
	}

	private void skipWhitespace() throws IOException {
		while (Character.isWhitespace(buffer[pnt])) {
			pnt++;
			if (pnt >= len) {
				rebuffer();
			}
		}
	}
}
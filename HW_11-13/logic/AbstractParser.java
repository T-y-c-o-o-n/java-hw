package logic;

import java.util.InputMismatchException;

public class AbstractParser {
    private final String source;
    private int pnt;
    protected char tempCh, prevCh;
    protected AbstractParser(String source) {
        this.source = source;
        pnt = 0;
    }
    protected void nextChar() {
        prevCh = tempCh;
        if (pnt < source.length()) {
            tempCh = source.charAt(pnt++);
        } else {
            tempCh = '\0';
        }
    }

    protected boolean test(char expected) {
        if (tempCh == expected) {
            nextChar();
            return true;
        }
        return false;
    }
    protected void expect(char ch) {
        if (ch != tempCh) {
            throw new InputMismatchException("expected: '" + ch + "' , but found: " + tempCh);
        }
    }
    protected void expect(String expected) {
        for (char ch : expected.toCharArray()) {
            expect(ch);
        }
    }
}
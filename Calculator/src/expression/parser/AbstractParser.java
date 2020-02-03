package expression.parser;

import java.util.InputMismatchException;

public class AbstractParser {
    private final Source source;
    protected char tempCh, prevCh;
    protected AbstractParser(Source source) {
        this.source = source;
    }
    protected void nextChar() {
        prevCh = tempCh;
        tempCh = source.nextChar();
    }
    protected boolean test(char expected) {
        if (tempCh == expected) {
            nextChar();
            return true;
        }
        return false;
    }
    protected void expect(char ch)  {
        if (ch != tempCh) {
            throw new InputMismatchException("expected: '" + ch + "' , but found: " + tempCh);
        }
        nextChar();
    }
    protected void expect(String expected) {
        for (char ch : expected.toCharArray()) {
            expect(ch);
        }
    }
}
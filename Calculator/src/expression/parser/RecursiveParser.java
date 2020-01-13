package expression.parser;

import expression.*;

public class RecursiveParser implements Parser {
    public CommonExpression parse(Source source) {
        return new ExpressionParser1(source).parseExp();
    }

    public CommonExpression parse(String string) {
        return parse(new StringSource(string));
    }

    private static class ExpressionParser1 extends AbstractParser {
        private int balance;
        private State state;

        public ExpressionParser1(Source source) {
            super(source);
            state = State.VAL;
            balance = 0;
            nextChar();
        }

        private CommonExpression parseExp() {
            return parse();
        }

        /* test('(');
            //TODO
        expext(')');*/

        private CommonExpression parse() {
            if (test('(')) {
                CommonExpression temp = parse();
                test(')');
                return temp;
            }
            return null;
        }
    }
    private enum State {
        VAL, OPER;
    }
}
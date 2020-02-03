package expression.parser;

import expression.*;

import java.util.Map;

public class ExpressionParser implements Parser {
    public CommonExpression parse(Source source) {
        return new ExpressionParser1(source).parse(0);
    }

    public CommonExpression parse(String string) {
        return parse(new StringSource(string));
    }

    private static class ExpressionParser1 extends AbstractParser {
        public ExpressionParser1(Source source) {
            super(source);
            nextChar();
        }

        private CommonExpression parse(int priority) {
            skipWhitespace();
            if (priority == 3) {
                return parseUnarOper();
            }
            CommonExpression argLeft = parse(priority + 1);
            while (true) {
                skipWhitespace();
                Oper oper;
                if (test('\0')) {
                    return argLeft;
                } else if (tempCh == '+') {
                    oper = Oper.ADD;
                } else if (tempCh == '-') {
                    oper = Oper.SUB;
                } else if (tempCh == '*') {
                    oper = Oper.MUL;
                } else if (tempCh == '/') {
                    oper = Oper.DIV;
                } else if (tempCh == '>') {
                    oper = Oper.RSH;
                } else if (tempCh == '<') {
                    oper = Oper.LSH;
                } else {
                    return argLeft;
                }
                if (oper.getPriority() != priority) {
                    return argLeft;
                }
                nextChar();
                if (oper == Oper.LSH) {
                    expect('<');
                } if (oper == Oper.RSH) {
                    expect('>');
                }
                argLeft = parseBinarOper(argLeft, oper, parse(priority + 1));
            }
        }

        private CommonExpression parseBinarOper(CommonExpression argLeft, Oper oper, CommonExpression argRight) {
            switch (oper) {
                case ADD:
                    return new Add(argLeft, argRight);
                case SUB:
                    return new Subtract(argLeft, argRight);
                case MUL:
                    return new Multiply(argLeft, argRight);
                case DIV:
                    return new Divide(argLeft, argRight);
                case RSH:
                    return new RightShift(argLeft, argRight);
                case LSH:
                    return new LeftShift(argLeft, argRight);
            }
            throw new IllegalArgumentException("unknown operation " + oper);
        }

        private CommonExpression parseUnarOper() {
            if (isDigit(tempCh)) {
                return parseConst(true);
            }
            if (isVariable(tempCh)) {
                return parseVar();
            }
            if (test('-')) {
                skipWhitespace();
                if (isDigit(tempCh)) {
                    return parseConst(false);
                } else {
                    return new Negate(parse(3));
                }
            }
            if (test('a')) {
                expect("bs");
                return new Abs(parse(3));
            } else if (test('s')) {
                    expect("quare");
                    return new Square(parse(3));
            } else if (test('r')) {
                    expect("everse");
                    return new Reverse(parse(3));
            } else if (test('d')) {
                    expect("igits");
                    return new Digits(parse(3));
            } else if (test('(')) {
                    CommonExpression parsed = parse(0);
                    skipWhitespace();
                    expect(')');

                    return parsed;
            } else if (test(')')) {
                throw new IllegalArgumentException("нихуя ты фокусник, я тоже так могу ) ) ) ) )");
            } else {
                    throw new IllegalArgumentException(tempCh + " это кто (who?)");
            }
        }

        private CommonExpression parseConst(boolean positive) {
            StringBuilder sb = new StringBuilder();
            if (!positive) {
                sb.append('-');
            }
            do {
                sb.append(tempCh);
                nextChar();
            } while (isDigit(tempCh));
            int val = Integer.parseInt(sb.toString());
            return new Const(val);
        }

        private CommonExpression parseVar() {
            String var = String.valueOf(tempCh);
            nextChar();
            return new Variable(var);
        }

        private void skipWhitespace() {
            while (Character.isWhitespace(tempCh)) {
                nextChar();
            }
        }

        private boolean isDigit(char ch) {
            return '0' <= ch && ch <= '9';
        }

        private boolean isVariable(char ch) {
            return 'x' <= ch && ch <= 'z';
        }
    }
}
package expression.parser;

import expression.*;

public class TreeParser implements Parser {
    public CommonExpression parse(String string) {
        return parse(new StringSource(string));
    }

    public CommonExpression parse(Source source) {
        return new ExpressionParser2(source).parseExp();
    }

    private static class ExpressionParser2 extends AbstractParser {
        private int balance;
        private CommonExpression root;
        private CommonExpression tempNode;
        private State state;

        public ExpressionParser2(Source source) {
            super(source);
            state = State.VAL;
            balance = 0;
            root = null;
            tempNode = null;
            nextChar();
        }

        private CommonExpression parseExp() {
            parse();
            return root;
        }

        /* test('(');
            //TODO
        expext(')');*/

        private void parse() {
            while (tempCh != '\0') {
                skipWhitespace();
                if (state == State.VAL && isDigit()) {
                    parseConst(false);
                    state = State.OPER;
                } else if (state == State.VAL && isVariable()) {
                    parseVar();
                    state = State.OPER;
                } else if (state == State.VAL && (tempCh == 'a' || tempCh == 's' || tempCh == 'r' || tempCh == 'd')) {
                    parseUnarOper();
                } else if (state == State.OPER && (tempCh == '+' || tempCh == '-'
                        || tempCh == '*' || tempCh == '/' || tempCh == '<' || tempCh == '>')) {
                    parseBinOper();
                    state = State.VAL;
                } else if (state == State.VAL && tempCh == '-') {  // Unary Negate or a part of a Const
                    nextChar();
                    skipWhitespace();
                    if (isDigit()) {
                        parseConst(true);
                        state = State.OPER;
                    } else {
                        pushNode(new Negate(null));
                    }
                } else if (state == State.VAL && tempCh == '(') {
                    balance++;
                    parseBrackets(true);
                } else if (state == State.OPER && tempCh == ')') {
                    balance--;
                    parseBrackets(false);
                }
                if (tempNode instanceof Const || tempNode instanceof Negate) {  // next char has already been eaten
                    continue;
                }
                nextChar();
            }
        }

        private void parseConst(boolean wasNegative) {
            StringBuilder sb = new StringBuilder();
            if (wasNegative) {
                sb.append('-');
            }
            do {
                sb.append(tempCh);
                nextChar();
            } while (isDigit());
            int val = Integer.parseInt(sb.toString());
            pushNode(new Const(val));
        }

        private void parseVar() {
            CommonExpression newNode = null;
            switch (tempCh) {
                case 'x':
                    newNode = new Variable("x");
                    break;
                case 'y':
                    newNode = new Variable("y");
                    break;
                case 'z':
                    newNode = new Variable("z");
                    break;
            }
            pushNode(newNode);
        }

        private void parseBinOper() {
            CommonExpression newNode = null;
            switch (tempCh) {
                case '+':
                    newNode = new Add(null, null);
                    break;
                case '-':
                    newNode = new Subtract(null, null);
                    break;
                case '*':
                    newNode = new Multiply(null, null);
                    break;
                case '/':
                    newNode = new Divide(null, null);
                    break;
                case '>':
                    expect('>');
                    newNode = new RightShift(null, null);
                    break;
                case '<':
                    expect('<');
                    newNode = new LeftShift(null, null);
                    break;
            }
            pushNode(newNode);
        }

        private void parseUnarOper() {
            CommonExpression newNode = null;
            if (test('a')) {
                expect("bs");
                newNode = new Abs(null);
            } else if (test('s')) {
                expect("quare");
                newNode = new Square(null);
            } else if (test('d')) {
                expect("igits");
                newNode = new Digits(null);
            } else if (test('r')) {
                expect("everse");
                newNode = new Reverse(null);
            }
            pushNode(newNode);
        }

        private void parseBrackets(boolean isLeft) {
            if (isLeft) {
                pushNode(new Brackets(null));
                Brackets br = (Brackets) tempNode;
                br.open();
            } else {
                CommonExpression temp = tempNode.getParent();  // Because we exactly have something inside of brackets
                while (!(temp instanceof Brackets)) {          // And we can close closed brackets if there is "...))..."
                    temp = temp.getParent();
                }
                Brackets br = (Brackets) temp;
                br.close();
                tempNode = temp;
            }
        }

        private void pushNode(CommonExpression newNode) {
            while (tempNode != null && checkPriority(tempNode, newNode)) {  // Replace with comparing with root (not with null) !!!
                tempNode = tempNode.getParent();
            }
            if (tempNode == null) {  // new Expression has the lowest priority and should be new root
                newNode.setArg1(root);
                root = newNode;
                tempNode = root;
            } else {
                newNode.setArg1(tempNode.getArg2());
                tempNode.setArg2(newNode);
                newNode.setParent(tempNode);
                tempNode = newNode;
            }
        }

        private boolean checkPriority(CommonExpression tempNode, CommonExpression newNode) {
            if (tempNode.getPriority() > newNode.getPriority()) {
                return true;
            }
            if (tempNode.getPriority() < newNode.getPriority()) {
                return false;
            }
            if (newNode instanceof AbstractUnarOper) {
                return false;  // Unary Operation doesn't need to be sifted up through another Unar Oper
            }
            return true;  // newNode is Binary Operation and needs to be sifted up (it cannot be Value)
        }

        private boolean isDigit() {
            return '0' <= tempCh && tempCh <= '9';
        }

        private boolean isVariable() {
            return tempCh == 'x' || tempCh == 'y' || tempCh == 'z';
        }

        private void skipWhitespace() {
            while (Character.isWhitespace(tempCh)) {
                nextChar();
            }
        }
    }
    private enum State {
        VAL, OPER;
    }
}
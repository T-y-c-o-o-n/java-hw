package logic;

public class Main {

    public static void main(String[] args) {
        // String content = args[0];
        // Parser parser = new Parser(content);
        // System.out.println("ХУЙ");
        Parser parser = new Parser("a & b | c");
        StringBuilder sb = new StringBuilder();
        LogicExpression logic = parser.parseExp();
        // System.out.println(parser.getRoot());
        logic.fill(sb, false);
        System.out.println(sb);
    }

    private static class Parser extends AbstractParser {
        private int balance;
        private LogicExpression root;
        private LogicExpression tempNode;
        private State state;

        public Parser(String source) {
            super(source);
            state = State.VAL;
            balance = 0;
            root = null;
            tempNode = null;
            nextChar();
        }

        public LogicExpression getRoot() {
            return root;
        }

        private LogicExpression parseExp() {
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
                    parseConst();
                    state = State.OPER;
                } else if (state == State.VAL && isVariable()) {
                    parseVar();
                    state = State.OPER;
                } else if (state == State.OPER && (tempCh == '&' || tempCh == '|')) {
                    parseBinOper();
                    state = State.VAL;
                } else if (state == State.VAL && tempCh == '~') {
                    pushNode(new Negate(null));
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

        private void parseConst() {
            if (tempCh == '0') {
                pushNode(new Const(0));
            } else {
                pushNode(new Const(1));
            }
        }

        private void parseVar() {
            LogicExpression newNode = null;
            newNode = new Variable(tempCh);
            pushNode(newNode);
        }

        private void parseBinOper() {
            LogicExpression newNode = null;
            switch (tempCh) {
                case '|':
                    newNode = new AbstractLogicOper(null, null, Oper.DIS) {
                    };
                    break;
                case '&':
                    newNode = new AbstractLogicOper(null, null, Oper.CON);
                    break;
            }
            pushNode(newNode);
        }

        private void parseBrackets(boolean isLeft) {
            if (isLeft) {
                pushNode(new Brackets(null));
                Brackets br = (Brackets) tempNode;
                br.open();
            } else {
                LogicExpression temp = tempNode.getParent();  // Because we exactly have something inside of brackets
                while (!(temp instanceof Brackets)) {          // And we can close closed brackets if there is "...))..."
                    temp = temp.getParent();
                }
                Brackets br = (Brackets) temp;
                br.close();
                tempNode = temp;
            }
        }

        private void pushNode(LogicExpression newNode) {
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

        private boolean checkPriority(LogicExpression tempNode, LogicExpression newNode) {
            if (tempNode.getPriority() > newNode.getPriority()) {
                return true;
            }
            if (tempNode.getPriority() < newNode.getPriority()) {
                return false;
            }
            if (newNode instanceof Negate) {
                return false;  // Negate doesn't need to be sifted up through another Negate
            }
            return true;  // newNode is Binary Operation and needs to be sifted up (it cannot be Value)
        }

        private boolean isDigit() {
            return '0' <= tempCh && tempCh <= '1';
        }

        private boolean isVariable() {
            return 'a' <= tempCh && tempCh <= 'z';
        }

        private void skipWhitespace() {
            while (Character.isWhitespace(tempCh)) {
                nextChar();
            }
        }
        private enum State {
            VAL, OPER;
        }
    }
}

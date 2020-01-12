package logic;

public class Brackets implements LogicExpression {
    private LogicExpression arg;
    protected LogicExpression parent;
    private Oper me;
    private int priority;
    private boolean closed;

    public Brackets(LogicExpression arg) {
        closed = false;
        priority = 11;
    }

    public void setArg1(LogicExpression newArg) {
        arg = newArg;
    }

    public void setArg2(LogicExpression newArg) {
        arg = newArg;
    }

    public void setParent(LogicExpression parent) {
        this.parent = parent;
    }

    public LogicExpression getArg1() {
        return arg;
    }

    public LogicExpression getArg2() {
        return arg;
    }

    public LogicExpression getParent() {
        return parent;
    }

    public int getPriority() {
        return me.getPriority();
    }

    public Oper getOper() {
        return me;
    }


    public void open() {
        closed = true;
        priority = -1;
    }

    public void close() {
        closed = true;
        priority = 11;
    }

    public void fill(StringBuilder sb, boolean isNeg) {
        sb.append('(').append(arg).append(')');
    }
}

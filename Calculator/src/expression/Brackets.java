package expression;

public class Brackets extends AbstractUnarOper {
    private boolean closed;
    private int priority;

    public Brackets(CommonExpression arg) {
        super(arg, Oper.BRKTS);
        closed = false;
        priority = 3;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void open() {
        closed = true;
        priority = -1;
    }

    public void close() {
        closed = true;
        priority = 3;
    }

    public int evaluate(int x) {
        return arg.evaluate(x);
    }

    public double evaluate(double x) {
        return arg.evaluate(x);
    }

    public int evaluate(int x, int y, int z) {
        return arg.evaluate(x, y, z);
    }

    @Override
    public String toString() {
        return "(" +
                arg.toMiniString() +
                ")";
    }

    @Override
    public String toMiniString() {
        return toString();
    }
}

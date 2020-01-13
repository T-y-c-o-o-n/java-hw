package expression;

public class Abs extends AbstractUnarOper {
    public Abs(CommonExpression arg) {
        super(arg, Oper.ABS);
    }

    public int evaluate(int x) {
        return Math.abs(arg.evaluate(x));
    }

    public double evaluate(double x) {
        return Math.abs(arg.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return Math.abs(arg.evaluate(x, y, z));
    }
}

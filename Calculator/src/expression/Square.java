package expression;

public class Square extends AbstractUnarOper {
    public Square(CommonExpression arg) {
        super(arg, Oper.SQR);
    }

    public int evaluate(int x) {
        int res = arg.evaluate(x);
        return res * res;
    }

    public double evaluate(double x) {
        double res = arg.evaluate(x);
        return res * res;
    }

    public int evaluate(int x, int y, int z) {
        int res = arg.evaluate(x, y, z);
        return res * res;
    }
}

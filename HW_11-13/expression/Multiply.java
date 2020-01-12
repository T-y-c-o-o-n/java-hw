package expression;

import java.util.EnumSet;

public class Multiply extends AbstractCalc {
    private static final EnumSet<Oper> firstArgsToAllow = EnumSet.of(Oper.MUL, Oper.DIV);
    private static final EnumSet<Oper> secondArgsToAllow = EnumSet.of(Oper.MUL);

    public Multiply(ExtendedExpression first, ExtendedExpression second) {
    	super(first, second, Oper.MUL);
    }

    public int evaluate(int x) {
    	return arg1.evaluate(x) * arg2.evaluate(x);
    }

    public double evaluate(double x) {
    	return arg1.evaluate(x) * arg2.evaluate(x);
    }

    public int evaluate(int x, int y, int z) {
    	return arg1.evaluate(x, y, z) * arg2.evaluate(x, y, z);
    }

    public String toMiniString() {
        return super.toMiniString(firstArgsToAllow, secondArgsToAllow);
    }
}
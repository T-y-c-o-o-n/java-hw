package expression;

import java.util.EnumSet;
import java.util.List;

public class Divide extends AbstractBinarOper {
	private static final EnumSet<Oper> firstArgsToAllow = EnumSet.of(Oper.MUL, Oper.DIV);
	private static final EnumSet<Oper> secondArgsToAllow = EnumSet.noneOf(Oper.class);

    public Divide(CommonExpression first, CommonExpression second) {
    	super(first, second, Oper.DIV);
    }

    public int evaluate(int x) {
    	return arg1.evaluate(x) / arg2.evaluate(x);
    }

    public double evaluate(double x) {
    	return arg1.evaluate(x) / arg2.evaluate(x);
    }

    public int evaluate(int x, int y, int z) {
    	return arg1.evaluate(x, y, z) / arg2.evaluate(x, y, z);
    }

    public String toMiniString() {
    	return super.toMiniString(firstArgsToAllow, secondArgsToAllow);
    }
}
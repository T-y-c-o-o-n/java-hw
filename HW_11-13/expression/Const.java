package expression;

import java.util.EnumSet;

public class Const implements ExtendedExpression {
    private final Number val;

    public Const(int val) {
        this.val = val;
    }

    public Const(double val) {
        this.val = val;
    }

    public Number getVal() {
        return val;
    }

    public int evaluate(int x) {
        return val.intValue();
    }

    public double evaluate(double x) {
        return val.doubleValue();
    }

    public int evaluate(int x, int y, int z) {
        return val.intValue();
    }

	public String toString() {
		return val.toString();
	}

    public String toMiniString() {
        return toString();
    }

    public String checkString(EnumSet<Oper> allowed) {
        return toString();
    }

    public boolean equals(Object object) {
        if (object != null && object.getClass() == getClass()) {
            Const c = (Const)object;
            return val.equals(c.getVal());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return val.hashCode();
    }
}
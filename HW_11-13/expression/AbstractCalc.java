package expression;

import java.util.EnumSet;

public abstract class AbstractCalc implements ExtendedExpression {
	protected final ExtendedExpression arg1;
	protected final ExtendedExpression arg2;
	private final Oper me;

	public AbstractCalc(ExtendedExpression arg1, ExtendedExpression arg2, Oper me) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.me = me;
	}

	public ExtendedExpression getArg1() {
		return arg1;
	}

	public ExtendedExpression getArg2() {
		return arg2;
	}

	public Oper getOper() {
		return me;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		sb.append(arg1.toString());
		sb.append(me);
		sb.append(arg2.toString());
		sb.append(')');
		return sb.toString();
	}

	protected String toMiniString(EnumSet<Oper> firstArgsToAllow, EnumSet<Oper> secondArgsToAllow) {
		StringBuilder sb = new StringBuilder(arg1.checkString(firstArgsToAllow));
		sb.append(me);
		sb.append(arg2.checkString(secondArgsToAllow));
		return sb.toString();
	}

	public String checkString(EnumSet<Oper> allowed) {
		if (allowed.contains(me)) {
			return toMiniString();
		}
		return '(' + toMiniString() + ')';
	}

	public boolean equals(Object object) {
		if (object != null && object.getClass() == getClass()) {
			AbstractCalc exp = (AbstractCalc)object;
			return me.equals(exp.getOper()) && arg1.equals(exp.getArg1()) && arg2.equals(exp.getArg2());
		} else {
			return false;
		}
	}

	public int hashCode() {
		return -1007 * arg1.hashCode() + 43 * me.hashCode() + 237 * arg2.hashCode();
	}
}
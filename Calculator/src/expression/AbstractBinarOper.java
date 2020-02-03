package expression;

import java.util.EnumSet;

public abstract class AbstractBinarOper implements CommonExpression {
	protected CommonExpression arg1;
	protected CommonExpression arg2;
	private final Oper me;

	public AbstractBinarOper(CommonExpression arg1, CommonExpression arg2, Oper me) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.me = me;
	}

	public void setArg1(CommonExpression newArg1) {
		arg1 = newArg1;
	}

	public void setArg2(CommonExpression newArg2) {
		arg2 = newArg2;
	}

	public CommonExpression getArg1() {
		return arg1;
	}

	public CommonExpression getArg2() {
		return arg2;
	}

	public int getPriority() {
		return me.getPriority();
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
		return arg1.checkString(firstArgsToAllow) + me +
				arg2.checkString(secondArgsToAllow);
	}

	public String checkString(EnumSet<Oper> allowed) {
		if (allowed.contains(me)) {
			return toMiniString();
		}
		return '(' + toMiniString() + ')';
	}

	public boolean equals(Object object) {
		if (object != null && object.getClass() == getClass()) {
			AbstractBinarOper exp = (AbstractBinarOper)object;
			return me.equals(exp.getOper()) && arg1.equals(exp.getArg1()) && arg2.equals(exp.getArg2());
		} else {
			return false;
		}
	}

	public int hashCode() {
		return toString().hashCode();
	}
}
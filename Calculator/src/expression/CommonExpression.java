package expression;

import java.util.EnumSet;
import java.util.List;

public interface CommonExpression extends Expression, TripleExpression, DoubleExpression {
	public String toString();
	public String toMiniString();
	String checkString(EnumSet<Oper> allowed);
	public int evaluate(int x, int y, int z);
	public double evaluate(double x);
	public void setArg1(CommonExpression arg1);
	public void setArg2(CommonExpression arg2);
	public void setParent(CommonExpression parent);
	public CommonExpression getArg1();
	public CommonExpression getArg2();
	public CommonExpression getParent();
	public int getPriority();
	public Oper getOper();
}
package logic;

public interface LogicExpression {
    public void fill(StringBuilder sb, boolean isNeg);
    // public void setNeg();
    public int getPriority();


    public void setArg1(LogicExpression arg1);
    public void setArg2(LogicExpression arg2);
    public void setParent(LogicExpression parent);
    public LogicExpression getArg1();
    public LogicExpression getArg2();
    public LogicExpression getParent();
    public Oper getOper();
}

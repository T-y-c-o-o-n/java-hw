package logic;

public class AbstractLogicOper implements LogicExpression {
    private LogicExpression parent;
    private LogicExpression arg1;
    private LogicExpression arg2;
    private Oper me;

    public AbstractLogicOper(LogicExpression arg1, LogicExpression arg2, Oper me) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.me = me;
    }

    public void setArg1(LogicExpression newArg1) {
        arg1 = newArg1;
    }

    public void setArg2(LogicExpression newArg2) {
        arg2 = newArg2;
    }

    public void setParent(LogicExpression parent) {
        this.parent = parent;
    }

    public LogicExpression getArg1() {
        return arg1;
    }

    public LogicExpression getArg2() {
        return arg2;
    }

    public LogicExpression getParent() {
        return parent;
    }

    public int getPriority() {
        return me.getPriority();
    }

    public Oper getOper() {
        return me;
    }

    public void fill(StringBuilder sb, boolean needToChange) {
        /*if (needToChange) {
            arg1.setNeg();
            me = me == Oper.CON ? Oper.DIS : Oper.CON;
            arg2.setNeg();
        }*/
        sb.append("(");
        arg1.fill(sb, false);
        sb.append(me);
        arg2.fill(sb, false);
        sb.append(")");
    }
}

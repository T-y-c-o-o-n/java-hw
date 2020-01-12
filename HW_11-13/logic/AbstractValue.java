package logic;

public abstract class AbstractValue implements LogicExpression {
    private LogicExpression parent;
    private final Oper me;

    public AbstractValue(Oper me) {
        this.me = me;
    }

    public void setArg1(LogicExpression newArg) { }

    public void setArg2(LogicExpression newArg) { }

    public void setParent(LogicExpression parent) {
        this.parent = parent;
    }

    public LogicExpression getArg1() {
        return null;
    }

    public LogicExpression getArg2() {
        return null;
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

}

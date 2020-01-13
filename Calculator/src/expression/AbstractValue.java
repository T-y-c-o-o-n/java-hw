package expression;

import java.util.EnumSet;
import java.util.List;

public abstract class AbstractValue implements CommonExpression {
    protected CommonExpression parent;
    private Oper me;

    public AbstractValue(Oper me) {
        this.me = me;
    }

    public void setArg1(CommonExpression newArg) { }

    public void setArg2(CommonExpression newArg) { }

    public void setParent(CommonExpression parent) {
        this.parent = parent;
    }

    public CommonExpression getArg1() {
        return null;
    }

    public CommonExpression getArg2() {
        return null;
    }

    public CommonExpression getParent() {
        return parent;
    }

    public int getPriority() {
        return me.getPriority();
    }

    public Oper getOper() {
        return Oper.VAR;
    }
}
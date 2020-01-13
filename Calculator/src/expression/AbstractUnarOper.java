package expression;

import java.util.EnumSet;
import java.util.List;

public abstract class AbstractUnarOper implements CommonExpression {
    protected CommonExpression arg;
    protected CommonExpression parent;
    private Oper me;

    public AbstractUnarOper(CommonExpression arg, Oper me) {
        this.arg = arg;
        this.me = me;
    }

    public void setArg1(CommonExpression newArg) {
        arg = newArg;
    }

    public void setArg2(CommonExpression newArg) {
        arg = newArg;
    }

    public void setParent(CommonExpression parent) {
        this.parent = parent;
    }

    public CommonExpression getArg1() {
        return arg;
    }

    public CommonExpression getArg2() {
        return arg;
    }

    public CommonExpression getParent() {
        return parent;
    }

    public int getPriority() {
        return me.getPriority();
    }

    public Oper getOper() {
        return me;
    }

    public String toString() {
        return "(" + me +
                arg.toString() +
                ")";
    }

    public String toMiniString() {
        return me +
                arg.toMiniString();
    }

    public String checkString(EnumSet<Oper> allowed) {
        return toString();
    }

    public boolean equals(Object object) {
        if (object != null && object.getClass() == getClass()) {
            AbstractUnarOper exp = (AbstractUnarOper)object;
            return me.equals(exp.getOper()) && arg.equals(exp.getArg1());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
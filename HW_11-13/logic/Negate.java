package logic;

import java.util.EnumSet;
import java.util.List;

public class Negate implements LogicExpression {
    private LogicExpression arg;
    private LogicExpression parent;

    public Negate(LogicExpression arg) {
        this.arg = arg;
    }

    public void setArg1(LogicExpression newArg) {
        arg = newArg;
    }

    public void setArg2(LogicExpression newArg) {
        arg = newArg;
    }

    public void setParent(LogicExpression parent) {
        this.parent = parent;
    }

    public LogicExpression getArg1() {
        return arg;
    }

    public LogicExpression getArg2() {
        return arg;
    }

    public LogicExpression getParent() {
        return parent;
    }

    public int getPriority() {
        return Oper.NEG.getPriority();
    }

    public Oper getOper() {
        return Oper.NEG;
    }

    public void fill(StringBuilder sb, boolean isNeg) {
        sb.append(" ~").append(arg);
    }
}
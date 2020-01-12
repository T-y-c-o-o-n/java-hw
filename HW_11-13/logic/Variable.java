package logic;

public class Variable extends AbstractValue {
    private final char var;

    public Variable(char var) {
        super(Oper.VAR);
        this.var = var;
    }

    public void fill(StringBuilder sb, boolean negative) {
        //if (negative) {
        //    sb.append("~");
        //}
        sb.append(var);
    }
}

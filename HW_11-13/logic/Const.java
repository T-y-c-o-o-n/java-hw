package logic;

public class Const extends AbstractValue {
    private final int value;

    public Const(int value) {
        super(Oper.CONST);
        this.value = value;
    }

    public void fill(StringBuilder sb, boolean negative) {
        //int res = negative ? 1 - value : value;
        int res = value;
        sb.append(res);
    }
}

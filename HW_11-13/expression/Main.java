package expression;

public class Main {
	public static void main(String[] args) {
		Subtract sub = new Subtract(
		    new Multiply(
		        new Const(2),
		        new Variable("x")
		    ),
		    new Const(3)
		);
		System.out.println(sub.toString());
		Add add = new Add(
		    new Multiply(
		        new Const(2),
		        new Divide(
		        	new Variable("a"),
		        	new Variable("b")
		        )
		    ),
		    new Const(3)
		);
		
		System.out.println(add.toString());
		System.out.println((new Const(1313)).toString());
		System.out.println((new Variable("adasdasdasd")).toString());
		int val = new Subtract(
    		new Multiply(
        		new Const(2),
        		new Variable("x")
    		),
    		new Const(3)
		).evaluate(5);
		System.out.println(val);
		System.out.println(new Multiply(new Const(2), new Variable("x"))
    		.equals(new Multiply(new Const(2), new Variable("x"))) + " true");
		System.out.println(new Multiply(new Const(2), new Variable("x"))
    	.equals(new Multiply(new Variable("x"), new Const(2))) + " false");
		// (x - ((1 * 2) + x))
		Add test = new Add(
			new Divide(new Const(1), new Const(2)),
			new Variable("x")
		);
		System.out.println(test.toString());
		System.out.println(test.toMiniString());
		System.out.println(test.evaluate(10));
		Add purum = new Add(new Variable("x"), new Const(2));
		System.out.println(purum.toString());
		System.out.println(purum.toMiniString());
		System.out.println(purum.evaluate(10));
	}
}
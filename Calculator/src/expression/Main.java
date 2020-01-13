package expression;

import expression.parser.*;

public class Main {
	public static void main(String[] args) {
		TreeParser parser = new TreeParser();
		System.out.println("PARSER:\n");
		System.out.println(parser.parse("sqrx").toMiniString());
		System.out.println(parser.parse("-x").toMiniString());
		System.out.println(parser.parse("(x + (2 - z))").toMiniString());
		System.out.println(parser.parse("(x + (2 - (0)))").toMiniString());
		System.out.println(parser.parse("(((x) + 2) - 0)").toMiniString());
		System.out.println(parser.parse("(2)").toMiniString());
		System.out.println(parser.parse("(x+2)").toMiniString());
		System.out.println(parser.parse("(2-y) + - y<<2").toMiniString());
		System.out.println(parser.parse("2-y + - (y<<2)").toMiniString());
		System.out.println(parser.parse("2-y + - (y<<2)").evaluate(0, 2, 0));
		System.out.println(parser.parse("  (3)*  z<<10  ").toMiniString());
		System.out.println(parser.parse("x/  -  2>>2 ").toMiniString());
		System.out.println(parser.parse("x>>y + z-1/10").toMiniString());
		System.out.println(parser.parse("---\t\t-5 + 16   *x*y + 1 * z - -11 ").toMiniString());
		// System.out.println(parser.parse("").toMiniString());
		// System.out.println(parser.parse("").toMiniString());
		System.out.println(parser.parse("x--y--z").toMiniString());
		System.out.println(parser.parse("2<<2-0/--2*555" ).toMiniString());
		System.out.println(parser.parse("(((x-1)-(x))+((y)-(y))+((z)-(z)))").toMiniString());
		System.out.println(parser.parse("   (   ((x)-(x))+((y)-(y))+((z)-(z))  )   ").evaluate(1, 2, 3));
		System.out.println(parser.parse("(".repeat(500) + "x + y + -10*-z" + ")".repeat(500)).toMiniString());
		System.out.println(parser.parse("x / y / z").toMiniString());
		System.out.println(parser.parse("x * y - z / x + abs sqr -z").toMiniString());
		System.out.println(parser.parse(" 23 + abs sqr --1234 * x ").toMiniString());
		System.out.println(parser.parse(" (   ((y+3)-(90<<4) +(1+2-3))  -  ((y+3)-(90<<4) +(1+2-3))  +   ((y+3)-(90<<4) +(1+2-3)) )").toMiniString());
		System.out.println(parser.parse("-2147483648").toMiniString());
		System.out.println(parser.parse("-(-(-\t\t-5 + 16   *x*y) + 1 * z) -(((-11)))").toMiniString());

	}
}
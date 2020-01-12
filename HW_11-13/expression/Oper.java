package expression;

public enum Oper {
	ADD {
		public String toString() {
			return " + ";
		}
	},
	SUB {
		public String toString() {
			return " - ";
		}
	},
	MUL {
		public String toString() {
			return " * ";
		}
	},
	DIV {
		public String toString() {
			return " / ";
		}
	};
}
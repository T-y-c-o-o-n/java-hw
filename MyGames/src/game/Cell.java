package game;

public enum Cell {
    X {
        public String toString() {
            return "X";
        }
    }, O {
        public String toString() {
            return "O";
        }
    }, L {
        public String toString() {
            return "-";
        }
    }, I {
        public String toString() {
            return "|";
        }
    }, E {
        public String toString() {
            return ".";
        }
    }, F {
        public String toString() {
            return " ";
        }
    }
}

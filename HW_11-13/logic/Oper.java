package logic;

public enum Oper {
    CON {
        public String toString() {
            return " & ";
        }
        public int getPriority() {
            return 2;
        }
    },
    DIS {
        public String toString() {
            return " | ";
        }
        public int getPriority() {
            return 1;
        }
    },
    BRKTS {
        public String toString() {
            return " *brackets* ";
        }
        public int getPriority() {
            return -1;
        }
    },
    NEG {
        public String toString() {
            return " ~";
        }
        public int getPriority() {
            return 9;
        }
    },
    VAR {
        public String toString() {
            return " var ";
        }
        public int getPriority() {
            return 10;
        }
    },
    CONST {
        public String toString() {
            return " const ";
        }
        public int getPriority() {
            return 10;
        }
    };

    public abstract int getPriority();
}

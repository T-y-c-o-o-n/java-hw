package expression;

public enum Oper {
    ADD {
        public String toString() {
            return " + ";
        }

        public int getPriority() {
            return 1;
        }
    },
    SUB {
        public String toString() {
            return " - ";
        }

        public int getPriority() {
            return 1;
        }
    },
    MUL {
        public String toString() {
            return " * ";
        }

        public int getPriority() {
            return 2;
        }
    },
    DIV {
        public String toString() {
            return " / ";
        }

        public int getPriority() {
            return 2;
        }
    },
    LSH {
        public String toString() {
            return " << ";
        }

        public int getPriority() {
            return 0;
        }
    },
    RSH {
        public String toString() {
            return " >> ";
        }

        public int getPriority() {
            return 0;
        }
    },
    NEG {
        public String toString() {
            return " -";
        }

        public int getPriority() {
            return 9;
        }
    },
    ABS {
        public String toString() {
            return "abs ";
        }

        public int getPriority() {
            return 9;
        }
    },
    SQR {
        public String toString() {
            return "square ";
        }

        public int getPriority() {
            return 9;
        }
    },
    DIG {
        public String toString() {
            return "digits ";
        }

        public int getPriority() {
            return 9;
        }
    },
    REV {
        public String toString() {
            return "reverse ";
        }

        public int getPriority() {
            return 9;
        }
    },
    BRKTS {
        public String toString() {
            return " *brackets* ";
        }

        public int getPriority() {
            return 11;
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
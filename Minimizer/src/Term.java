public class Term {

    private String completeTerm = "";
    private String variable_A = "";
    private String variable_B = "";
    private String variable_C = "";
    private String variable_D = "";
    private String variable_E = "";
    private String variable_F = "";
    private String variable_G = "";
    private boolean isPrime;
    private boolean isMarked;

    public Term(String variable_A, String variable_B, String variable_C, String variable_D, String variable_E, String variable_F, String variable_G) {
        this.variable_A = variable_A;
        this.variable_B = variable_B;
        this.variable_C = variable_C;
        this.variable_D = variable_D;
        this.variable_E = variable_E;
        this.variable_F = variable_F;
        this.variable_G = variable_G;
        this.isPrime = false;
        this.isMarked = false;

        String[] variables = new String[]{variable_G, variable_F, variable_E, variable_D, variable_C, variable_B, variable_A};
        StringBuilder stringBuilder = new StringBuilder();
        for (String v : variables) {
            if (!v.isEmpty()) {
                stringBuilder.append(v);
                stringBuilder.append("*");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        completeTerm = stringBuilder.toString().trim();
    }

    public Term(String completeTerm) {
        this.completeTerm = completeTerm.trim();

        String[] variables = completeTerm.split("\\u002A");
        for (String s : variables) {
            if (s.equals("~A") || s.equals("A")) {
                setVariable_A(s);
            }
            if (s.equals("~B") || s.equals("B")) {
                setVariable_B(s);
            }
            if (s.equals("~C") || s.equals("C")) {
                setVariable_C(s);
            }
            if (s.equals("~D") || s.equals("D")) {
                setVariable_D(s);
            }
            if (s.equals("~E") || s.equals("E")) {
                setVariable_E(s);
            }
            if (s.equals("~F") || s.equals("F")) {
                setVariable_F(s);
            }
            if (s.equals("~G") || s.equals("G")) {
                setVariable_G(s);
            }
        }

        this.isPrime = false;
        this.isMarked = false;
    }

    // activate
    public void activate_A(Term givenTerm) {
        if (givenTerm.getVariable_A() != null) {
            givenTerm.setVariable_A("A");
        }
        updateTerm();
    }

    public void activate_B(Term givenTerm) {
        if (givenTerm.getVariable_B() != null) {
            givenTerm.setVariable_B("B");
        }
        updateTerm();
    }

    public void activate_C(Term givenTerm) {
        if (givenTerm.getVariable_C() != null) {
            givenTerm.setVariable_C("C");
        }
        updateTerm();
    }

    public void activate_D(Term givenTerm) {
        if (givenTerm.getVariable_D() != null) {
            givenTerm.setVariable_D("D");
        }
        updateTerm();
    }

    public void activate_E(Term givenTerm) {
        if (givenTerm.getVariable_E() != null) {
            givenTerm.setVariable_E("E");
        }
        updateTerm();
    }

    public void activate_F(Term givenTerm) {
        if (givenTerm.getVariable_F() != null) {
            givenTerm.setVariable_F("F");
        }
        updateTerm();
    }

    public void activate_G(Term givenTerm) {
        if (givenTerm.getVariable_G() != null) {
            givenTerm.setVariable_G("G");
        }
        updateTerm();
    }

    //negate
    public void negate_A(Term givenTerm) {
        if (givenTerm.getVariable_A() != null) {
            givenTerm.setVariable_A("~A");
        }
        updateTerm();
    }

    public void negate_B(Term givenTerm) {
        if (givenTerm.getVariable_B() != null) {
            givenTerm.setVariable_B("~B");
        }
        updateTerm();
    }

    public void negate_C(Term givenTerm) {
        if (givenTerm.getVariable_C() != null) {
            givenTerm.setVariable_C("~C");
        }
        updateTerm();
    }

    public void negate_D(Term givenTerm) {
        if (givenTerm.getVariable_D() != null) {
            givenTerm.setVariable_D("~D");
        }
        updateTerm();
    }

    public void negate_E(Term givenTerm) {
        if (givenTerm.getVariable_E() != null) {
            givenTerm.setVariable_E("~E");
        }
        updateTerm();
    }

    public void negate_F(Term givenTerm) {
        if (givenTerm.getVariable_F() != null) {
            givenTerm.setVariable_F("~F");
        }
        updateTerm();
    }

    public void negate_G(Term givenTerm) {
        if (givenTerm.getVariable_G() != null) {
            givenTerm.setVariable_G("~G");
        }
        updateTerm();
    }

    private void updateTerm() {
        completeTerm = variable_A + "*" + variable_B + "*" + variable_C + "*" + variable_D + "*" + variable_E + "*" + variable_F + "*" + variable_G;
    }

    public String getVariable_A() {
        return variable_A;
    }

    public void setVariable_A(String variable_A) {
        this.variable_A = variable_A;
    }

    public String getVariable_B() {
        return variable_B;
    }

    public void setVariable_B(String variable_B) {
        this.variable_B = variable_B;
    }

    public String getVariable_C() {
        return variable_C;
    }

    public void setVariable_C(String variable_C) {
        this.variable_C = variable_C;
    }

    public String getVariable_D() {
        return variable_D;
    }

    public void setVariable_D(String variable_D) {
        this.variable_D = variable_D;
    }

    public String getVariable_E() {
        return variable_E;
    }

    public void setVariable_E(String variable_E) {
        this.variable_E = variable_E;
    }

    public String getVariable_F() {
        return variable_F;
    }

    public void setVariable_F(String variable_F) {
        this.variable_F = variable_F;
    }

    public String getVariable_G() {
        return variable_G;
    }

    public void setVariable_G(String variable_G) {
        this.variable_G = variable_G;
    }

    public String getCompleteTerm() {
        return completeTerm;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    @Override
    public boolean equals(Object obj) {
        Term term = (Term) obj;
        return this.variable_A.equals(term.getVariable_A()) &&
                this.variable_B.equals(term.getVariable_B()) &&
                this.variable_C.equals(term.getVariable_C()) &&
                this.variable_D.equals(term.getVariable_D()) &&
                this.variable_E.equals(term.getVariable_E()) &&
                this.variable_F.equals(term.getVariable_F()) &&
                this.variable_G.equals(term.getVariable_G());
    }
}

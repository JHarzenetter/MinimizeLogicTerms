public class Term {

    private String completeTerm;
    private String variable_A;
    private String variable_B;
    private String variable_C;
    private String variable_D;
    private String variable_E;
    private String variable_F;
    private String variable_G;

    public Term(String variable_A, String variable_B, String variable_C, String variable_D, String variable_E, String variable_F, String variable_G) {
        this.variable_A = variable_A;
        this.variable_B = variable_B;
        this.variable_C = variable_C;
        this.variable_D = variable_D;
        this.variable_E = variable_E;
        this.variable_F = variable_F;
        this.variable_G = variable_G;

        completeTerm = variable_A + "*" + variable_B + "*" + variable_C + "*" + variable_D + "*" + variable_E + "*" + variable_F + "*" + variable_G;
    }

    public Term(String completeTerm){
        this.completeTerm = completeTerm;
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
}

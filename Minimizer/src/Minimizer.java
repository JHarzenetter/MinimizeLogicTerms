import java.io.*;
import java.util.*;

public class Minimizer {

    private String all_terms_combined;
    private List<Term> termTable = new ArrayList<>();
    private List<Term> primeTable = new ArrayList<>();

    public void initialize() {
        try {
            File terms = new File("Minimizer/resources/terms_full_c.txt");

            BufferedReader reader = new BufferedReader(new FileReader(terms));

            StringBuilder sb = new StringBuilder();
            String read_Line;
            while ((read_Line = reader.readLine()) != null) {
                sb.append(read_Line);
                sb.append(" + ");
            }
            sb.deleteCharAt(sb.length() - 2);
            all_terms_combined = sb.toString();
            createTermTable();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public String create_Prime_Terms() {

        File folder = new File("Minimizer/term_objects/");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }

        compare_combine_Terms_rek(this.termTable);

        primeTable.forEach(Term::shortenTerm);

        StringBuilder sb = new StringBuilder();
        primeTable.forEach(x -> {
            sb.append(x.getCompleteTerm());
            sb.append(" + ");
        });
        sb.deleteCharAt(sb.length() - 2);

        //result should be only the minimal form
        return sb.toString();
    }

    //helper methods below
    public List<Term> compare_combine_Terms_rek(List<Term> termTable) {

        List<Term> result = new ArrayList<>();
        Map<String, Long> negationMapping;
        List<Term> sorted = sortTerms(countNegationsPerTerm(termTable));

        createTermFiles(termTable);
        System.gc();

        for (int i = 0; i < sorted.size(); i++) {
            //Term t1 = sorted.get(i);
            Term t1 = loadTerm(sorted.get(i).getID());
            boolean t1_got_combined = false;

            for (int k = i; k < sorted.size(); k++) {
                boolean t2_got_combined = false;
                //only check two different Terms
                if (k != i) {
                    //Term t2 = sorted.get(k);
                    Term t2 = loadTerm(sorted.get(k).getID());
                    negationMapping = countNegationsPerTermInString(termTable);
                    //only compare if the negation-classes are neighbors
                    if (negationMapping.get(t1.getID()) - negationMapping.get(t2.getID()) == 1) {
                        //only compare if the difference between the terms is one variable
                        if (t1.getCompleteTerm().contains("DoCa")) {
                            //compare with DontCare
                            if (t1.diffEq1(t2)) {
                                String v_A = null, v_B = null, v_C = null, v_D = null, v_E = null, v_F = null, v_G = null;
                                t1_got_combined = true;
                                t2_got_combined = true;
                                //var_A
                                if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                    if (t1.getVariable_A().equals("DoCa") && t1.getVariable_A().equals(t2.getVariable_A())) {
                                        //var_A
                                        v_A = "DoCa";

                                        //var_B
                                        if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                            if (!t1.getVariable_B().equals(t2.getVariable_B())) {
                                                if (t1.getVariable_B().contains("~")) {
                                                    v_B = "DoCa";
                                                }
                                            } else {
                                                v_B = t1.getVariable_B();
                                            }
                                        }

                                        //var_C
                                        if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                            if (!t1.getVariable_C().equals(t2.getVariable_C())) {
                                                if (t1.getVariable_C().contains("~")) {
                                                    v_C = "DoCa";
                                                }
                                            } else {
                                                v_C = t1.getVariable_C();
                                            }
                                        }
                                        //var_D
                                        if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                            if (!t1.getVariable_D().equals(t2.getVariable_D())) {
                                                if (t1.getVariable_D().contains("~")) {
                                                    v_D = "DoCa";
                                                }
                                            } else {
                                                v_D = t1.getVariable_D();
                                            }
                                        }
                                        //var_E
                                        if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                            if (!t1.getVariable_E().equals(t2.getVariable_E())) {
                                                if (t1.getVariable_E().contains("~")) {
                                                    v_E = "DoCa";
                                                }
                                            } else {
                                                v_E = t1.getVariable_E();
                                            }
                                        }
                                        //var_F
                                        if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                            if (!t1.getVariable_F().equals(t2.getVariable_F())) {
                                                if (t1.getVariable_F().contains("~")) {
                                                    v_F = "DoCa";
                                                }
                                            } else {
                                                v_F = t1.getVariable_F();
                                            }
                                        }
                                        //var_G
                                        if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                            if (!t1.getVariable_G().equals(t2.getVariable_G())) {
                                                if (t1.getVariable_G().contains("~")) {
                                                    v_G = "DoCa";
                                                }
                                            } else {
                                                v_G = t1.getVariable_G();
                                            }
                                        }
                                        result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                                    }
                                }
                                //var_B
                                if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                    if (t1.getVariable_B().equals("DoCa") && t1.getVariable_B().equals(t2.getVariable_B())) {
                                        //var_B
                                        v_B = "DoCa";

                                        //var_A
                                        if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                            if (!t1.getVariable_A().equals(t2.getVariable_A())) {
                                                if (t1.getVariable_A().contains("~")) {
                                                    v_A = "DoCa";
                                                }
                                            } else {
                                                v_A = t1.getVariable_A();
                                            }
                                        }

                                        //var_C
                                        if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                            if (!t1.getVariable_C().equals(t2.getVariable_C())) {
                                                if (t1.getVariable_C().contains("~")) {
                                                    v_C = "DoCa";
                                                }
                                            } else {
                                                v_C = t1.getVariable_C();
                                            }
                                        }
                                        //var_D
                                        if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                            if (!t1.getVariable_D().equals(t2.getVariable_D())) {
                                                if (t1.getVariable_D().contains("~")) {
                                                    v_D = "DoCa";
                                                }
                                            } else {
                                                v_D = t1.getVariable_D();
                                            }
                                        }
                                        //var_E
                                        if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                            if (!t1.getVariable_E().equals(t2.getVariable_E())) {
                                                if (t1.getVariable_E().contains("~")) {
                                                    v_E = "DoCa";
                                                }
                                            } else {
                                                v_E = t1.getVariable_E();
                                            }
                                        }
                                        //var_F
                                        if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                            if (!t1.getVariable_F().equals(t2.getVariable_F())) {
                                                if (t1.getVariable_F().contains("~")) {
                                                    v_F = "DoCa";
                                                }
                                            } else {
                                                v_F = t1.getVariable_F();
                                            }
                                        }
                                        //var_G
                                        if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                            if (!t1.getVariable_G().equals(t2.getVariable_G())) {
                                                if (t1.getVariable_G().contains("~")) {
                                                    v_G = "DoCa";
                                                }
                                            } else {
                                                v_G = t1.getVariable_G();
                                            }
                                        }
                                        result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                                    }
                                }
                                //var_C
                                if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                    if (t1.getVariable_C().equals("DoCa") && t1.getVariable_C().equals(t2.getVariable_C())) {
                                        //var_C
                                        v_C = "DoCa";

                                        //var_B
                                        if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                            if (!t1.getVariable_B().equals(t2.getVariable_B())) {
                                                if (t1.getVariable_B().contains("~")) {
                                                    v_B = "DoCa";
                                                }
                                            } else {
                                                v_B = t1.getVariable_B();
                                            }
                                        }

                                        //var_A
                                        if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                            if (!t1.getVariable_A().equals(t2.getVariable_A())) {
                                                if (t1.getVariable_A().contains("~")) {
                                                    v_A = "DoCa";
                                                }
                                            } else {
                                                v_A = t1.getVariable_A();
                                            }
                                        }
                                        //var_D
                                        if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                            if (!t1.getVariable_D().equals(t2.getVariable_D())) {
                                                if (t1.getVariable_D().contains("~")) {
                                                    v_D = "DoCa";
                                                }
                                            } else {
                                                v_D = t1.getVariable_D();
                                            }
                                        }
                                        //var_E
                                        if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                            if (!t1.getVariable_E().equals(t2.getVariable_E())) {
                                                if (t1.getVariable_E().contains("~")) {
                                                    v_E = "DoCa";
                                                }
                                            } else {
                                                v_E = t1.getVariable_E();
                                            }
                                        }
                                        //var_F
                                        if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                            if (!t1.getVariable_F().equals(t2.getVariable_F())) {
                                                if (t1.getVariable_F().contains("~")) {
                                                    v_F = "DoCa";
                                                }
                                            } else {
                                                v_F = t1.getVariable_F();
                                            }
                                        }
                                        //var_G
                                        if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                            if (!t1.getVariable_G().equals(t2.getVariable_G())) {
                                                if (t1.getVariable_G().contains("~")) {
                                                    v_G = "DoCa";
                                                }
                                            } else {
                                                v_G = t1.getVariable_G();
                                            }
                                        }
                                        result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                                    }
                                }
                                //var_D
                                if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                    if (t1.getVariable_A().equals("DoCa") && t1.getVariable_A().equals(t2.getVariable_D())) {
                                        //var_D
                                        v_D = "DoCa";

                                        //var_B
                                        if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                            if (!t1.getVariable_B().equals(t2.getVariable_B())) {
                                                if (t1.getVariable_B().contains("~")) {
                                                    v_B = "DoCa";
                                                }
                                            } else {
                                                v_B = t1.getVariable_B();
                                            }
                                        }

                                        //var_C
                                        if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                            if (!t1.getVariable_C().equals(t2.getVariable_C())) {
                                                if (t1.getVariable_C().contains("~")) {
                                                    v_C = "DoCa";
                                                }
                                            } else {
                                                v_C = t1.getVariable_C();
                                            }
                                        }
                                        //var_A
                                        if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                            if (!t1.getVariable_A().equals(t2.getVariable_A())) {
                                                if (t1.getVariable_A().contains("~")) {
                                                    v_A = "DoCa";
                                                }
                                            } else {
                                                v_A = t1.getVariable_A();
                                            }
                                        }
                                        //var_E
                                        if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                            if (!t1.getVariable_E().equals(t2.getVariable_E())) {
                                                if (t1.getVariable_E().contains("~")) {
                                                    v_E = "DoCa";
                                                }
                                            } else {
                                                v_E = t1.getVariable_E();
                                            }
                                        }
                                        //var_F
                                        if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                            if (!t1.getVariable_F().equals(t2.getVariable_F())) {
                                                if (t1.getVariable_F().contains("~")) {
                                                    v_F = "DoCa";
                                                }
                                            } else {
                                                v_F = t1.getVariable_F();
                                            }
                                        }
                                        //var_G
                                        if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                            if (!t1.getVariable_G().equals(t2.getVariable_G())) {
                                                if (t1.getVariable_G().contains("~")) {
                                                    v_G = "DoCa";
                                                }
                                            } else {
                                                v_G = t1.getVariable_G();
                                            }
                                        }
                                        result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                                    }
                                }
                                //var_E
                                if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                    if (t1.getVariable_E().equals("DoCa") && t1.getVariable_E().equals(t2.getVariable_E())) {
                                        //var_E
                                        v_E = "DoCa";

                                        //var_B
                                        if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                            if (!t1.getVariable_B().equals(t2.getVariable_B())) {
                                                if (t1.getVariable_B().contains("~")) {
                                                    v_B = "DoCa";
                                                }
                                            } else {
                                                v_B = t1.getVariable_B();
                                            }
                                        }

                                        //var_C
                                        if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                            if (!t1.getVariable_C().equals(t2.getVariable_C())) {
                                                if (t1.getVariable_C().contains("~")) {
                                                    v_C = "DoCa";
                                                }
                                            } else {
                                                v_C = t1.getVariable_C();
                                            }
                                        }
                                        //var_D
                                        if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                            if (!t1.getVariable_D().equals(t2.getVariable_D())) {
                                                if (t1.getVariable_D().contains("~")) {
                                                    v_D = "DoCa";
                                                }
                                            } else {
                                                v_D = t1.getVariable_D();
                                            }
                                        }
                                        //var_A
                                        if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                            if (!t1.getVariable_A().equals(t2.getVariable_A())) {
                                                if (t1.getVariable_A().contains("~")) {
                                                    v_A = "DoCa";
                                                }
                                            } else {
                                                v_A = t1.getVariable_A();
                                            }
                                        }
                                        //var_F
                                        if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                            if (!t1.getVariable_F().equals(t2.getVariable_F())) {
                                                if (t1.getVariable_F().contains("~")) {
                                                    v_F = "DoCa";
                                                }
                                            } else {
                                                v_F = t1.getVariable_F();
                                            }
                                        }
                                        //var_G
                                        if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                            if (!t1.getVariable_G().equals(t2.getVariable_G())) {
                                                if (t1.getVariable_G().contains("~")) {
                                                    v_G = "DoCa";
                                                }
                                            } else {
                                                v_G = t1.getVariable_G();
                                            }
                                        }
                                        result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                                    }
                                }
                                //var_F
                                if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                    if (t1.getVariable_F().equals("DoCa") && t1.getVariable_F().equals(t2.getVariable_F())) {
                                        //var_F
                                        v_F = "DoCa";

                                        //var_B
                                        if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                            if (!t1.getVariable_B().equals(t2.getVariable_B())) {
                                                if (t1.getVariable_B().contains("~")) {
                                                    v_B = "DoCa";
                                                }
                                            } else {
                                                v_B = t1.getVariable_B();
                                            }
                                        }

                                        //var_C
                                        if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                            if (!t1.getVariable_C().equals(t2.getVariable_C())) {
                                                if (t1.getVariable_C().contains("~")) {
                                                    v_C = "DoCa";
                                                }
                                            } else {
                                                v_C = t1.getVariable_C();
                                            }
                                        }
                                        //var_D
                                        if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                            if (!t1.getVariable_D().equals(t2.getVariable_D())) {
                                                if (t1.getVariable_D().contains("~")) {
                                                    v_D = "DoCa";
                                                }
                                            } else {
                                                v_D = t1.getVariable_D();
                                            }
                                        }
                                        //var_E
                                        if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                            if (!t1.getVariable_E().equals(t2.getVariable_E())) {
                                                if (t1.getVariable_E().contains("~")) {
                                                    v_E = "DoCa";
                                                }
                                            } else {
                                                v_E = t1.getVariable_E();
                                            }
                                        }
                                        //var_A
                                        if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                            if (!t1.getVariable_A().equals(t2.getVariable_A())) {
                                                if (t1.getVariable_A().contains("~")) {
                                                    v_A = "DoCa";
                                                }
                                            } else {
                                                v_A = t1.getVariable_A();
                                            }
                                        }
                                        //var_G
                                        if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                            if (!t1.getVariable_G().equals(t2.getVariable_G())) {
                                                if (t1.getVariable_G().contains("~")) {
                                                    v_G = "DoCa";
                                                }
                                            } else {
                                                v_G = t1.getVariable_G();
                                            }
                                        }
                                        result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                                    }
                                }
                                //var_G
                                if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                    if (t1.getVariable_G().equals("DoCa") && t1.getVariable_G().equals(t2.getVariable_G())) {
                                        //var_G
                                        v_G = "DoCa";

                                        //var_B
                                        if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                            if (!t1.getVariable_B().equals(t2.getVariable_B())) {
                                                if (t1.getVariable_B().contains("~")) {
                                                    v_B = "DoCa";
                                                }
                                            } else {
                                                v_B = t1.getVariable_B();
                                            }
                                        }

                                        //var_C
                                        if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                            if (!t1.getVariable_C().equals(t2.getVariable_C())) {
                                                if (t1.getVariable_C().contains("~")) {
                                                    v_C = "DoCa";
                                                }
                                            } else {
                                                v_C = t1.getVariable_C();
                                            }
                                        }
                                        //var_D
                                        if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                            if (!t1.getVariable_D().equals(t2.getVariable_D())) {
                                                if (t1.getVariable_D().contains("~")) {
                                                    v_D = "DoCa";
                                                }
                                            } else {
                                                v_D = t1.getVariable_D();
                                            }
                                        }
                                        //var_E
                                        if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                            if (!t1.getVariable_E().equals(t2.getVariable_E())) {
                                                if (t1.getVariable_E().contains("~")) {
                                                    v_E = "DoCa";
                                                }
                                            } else {
                                                v_E = t1.getVariable_E();
                                            }
                                        }
                                        //var_F
                                        if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                            if (!t1.getVariable_F().equals(t2.getVariable_F())) {
                                                if (t1.getVariable_F().contains("~")) {
                                                    v_F = "DoCa";
                                                }
                                            } else {
                                                v_F = t1.getVariable_F();
                                            }
                                        }
                                        //var_A
                                        if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                            if (!t1.getVariable_A().equals(t2.getVariable_A())) {
                                                if (t1.getVariable_A().contains("~")) {
                                                    v_A = "DoCa";
                                                }
                                            } else {
                                                v_A = t1.getVariable_A();
                                            }
                                        }
                                        result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                                    }
                                }
                            }
                        } else {
                            //without a DontCare
                            if (t1.diffEq1(t2)) {
                                String v_A = null, v_B = null, v_C = null, v_D = null, v_E = null, v_F = null, v_G = null;
                                t1_got_combined = true;
                                t2_got_combined = true;
                                //var_A
                                if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                                    if (!t1.getVariable_A().equals(t2.getVariable_A())) {
                                        if (t1.getVariable_A().contains("~")) {
                                            v_A = "DoCa";
                                        }
                                    } else {
                                        v_A = t1.getVariable_A();
                                    }
                                }
                                //var_B
                                if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                                    if (!t1.getVariable_B().equals(t2.getVariable_B())) {
                                        if (t1.getVariable_B().contains("~")) {
                                            v_B = "DoCa";
                                        }
                                    } else {
                                        v_B = t1.getVariable_B();
                                    }
                                }
                                //var_C
                                if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                                    if (!t1.getVariable_C().equals(t2.getVariable_C())) {
                                        if (t1.getVariable_C().contains("~")) {
                                            v_C = "DoCa";
                                        }
                                    } else {
                                        v_C = t1.getVariable_C();
                                    }
                                }
                                //var_D
                                if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                                    if (!t1.getVariable_D().equals(t2.getVariable_D())) {
                                        if (t1.getVariable_D().contains("~")) {
                                            v_D = "DoCa";
                                        }
                                    } else {
                                        v_D = t1.getVariable_D();
                                    }
                                }
                                //var_E
                                if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                                    if (!t1.getVariable_E().equals(t2.getVariable_E())) {
                                        if (t1.getVariable_E().contains("~")) {
                                            v_E = "DoCa";
                                        }
                                    } else {
                                        v_E = t1.getVariable_E();
                                    }
                                }
                                //var_F
                                if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                                    if (!t1.getVariable_F().equals(t2.getVariable_F())) {
                                        if (t1.getVariable_F().contains("~")) {
                                            v_F = "DoCa";
                                        }
                                    } else {
                                        v_F = t1.getVariable_F();
                                    }
                                }
                                //var_G
                                if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                                    if (!t1.getVariable_G().equals(t2.getVariable_G())) {
                                        if (t1.getVariable_G().contains("~")) {
                                            v_G = "DoCa";
                                        }
                                    } else {
                                        v_G = t1.getVariable_G();
                                    }
                                }

                                result.add(new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G));
                            }
                        }
                    }

                    t2 = null;
                    System.gc();
                }

                if (t2_got_combined) {
                    sorted.get(k).setMarked(true);
                }
            }

            if (t1_got_combined) {
                sorted.get(i).setMarked(true);
            }

            t1 = null;
            System.gc();
        }

        for (Term t : sorted) {
            if (!t.isMarked() && !t.existsInList(primeTable)) {
                primeTable.add(t);
            }
        }

        // end-statement of recursion:  if no combinings are done in one run, then return the given List
        //                              and add them to primeTable
        if (result.isEmpty()) {
            return termTable;
        } else {
            return compare_combine_Terms_rek(result);
        }
    }

    public List<Term> sortTerms(Map<Term, Long> mappingNumber_of_Negations) {
        List<Term> sortedList = new ArrayList<>();

        List<Map.Entry<Term, Long>> sortingList = new ArrayList<>(mappingNumber_of_Negations.entrySet());
        sortingList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Term, Long> entry : sortingList) {
            sortedList.add(entry.getKey());
        }

        return sortedList;
    }

    private Map<Term, Long> countNegationsPerTerm(List<Term> termTable) {
        Map<Term, Long> mappingNumber_of_Negations = new HashMap<>();

        for (Term t : termTable) {
            String s = t.getCompleteTerm();
            long number_of_Negation = s.chars().filter(ch -> ch == '~').count();
            mappingNumber_of_Negations.put(t, number_of_Negation);
        }
        return mappingNumber_of_Negations;
    }

    private Map<String, Long> countNegationsPerTermInString(List<Term> termTable){
        Map<String, Long> mappingNumber_of_Negations = new HashMap<>();

        for (Term t : termTable) {
            String s = t.getCompleteTerm();
            long number_of_Negation = s.chars().filter(ch -> ch == '~').count();
            mappingNumber_of_Negations.put(t.getID(), number_of_Negation);
        }
        return mappingNumber_of_Negations;
    }

    private void createTermTable() {
        String[] termtable = all_terms_combined.split("\\u002B");
        for (String s : termtable) {
            termTable.add(new Term(s.trim()));
        }
    }

    private void createTermFiles(List<Term> terms) {
        for (Term t : terms) {
            try {
                FileOutputStream fileOut = new FileOutputStream("Minimizer/term_objects/" + t.getID() + ".ser");
                ObjectOutputStream stream = new ObjectOutputStream(fileOut);

                stream.writeObject(t);

                stream.close();
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Term loadTerm(String s) {
        Term t = null;
        try {
            FileInputStream fileIn = new FileInputStream("Minimizer/term_objects/" + s + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            t = (Term) in.readObject();

            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }

    //getter
    public String getAll_terms_combined() {
        return all_terms_combined;
    }

    public List<Term> getPrimeTable() {
        return primeTable;
    }
}

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Minimizer {

    private String all_terms_combined;
    private List<Term> termTable = new ArrayList<>();

    public void initialize() {
        try {
            File terms = new File("Minimizer/resources/terms.txt");

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

    public List<Term> create_Prime_Terms() {

        //result should be only the minimal form
        return null;
    }

    //helper methods below
    public List<Term> compare_combine_Terms() {
        //TODO: compare terms, on matching 0 and 1
        Map<Term, Long> negationMapping = countNegationsPerTerm();
        List<Term> sortedTermList = sortTerms();
        List<Term> combinedTerms = new ArrayList<>();

        for (int i = 0; i < sortedTermList.size(); i++) {
            for (int k = 0; k < sortedTermList.size(); k++) {
                if (k == i) {
                    continue;
                } else {
                    Term t1 = sortedTermList.get(i);
                    Term t2 = sortedTermList.get(k);

                    if (negationMapping.get(t1) - negationMapping.get(t2) == 1) {
                        String v_A = null;
                        String v_B = null;
                        String v_C = null;
                        String v_D = null;
                        String v_E = null;
                        String v_F = null;
                        String v_G = null;

                        if (t1.getVariable_A() != null && t2.getVariable_A() != null) {
                            if (!(t1.getVariable_A().equals(t2.getVariable_A()))) {
                                v_A = t2.getVariable_A();
                            } else {
                                v_A = t1.getVariable_A();
                            }
                        }
                        if (t1.getVariable_B() != null && t2.getVariable_B() != null) {
                            if (!(t1.getVariable_B().equals(t2.getVariable_B()))) {
                                v_B = t2.getVariable_B();
                            } else {
                                v_B = t1.getVariable_B();
                            }
                        }
                        if (t1.getVariable_C() != null && t2.getVariable_C() != null) {
                            if (!(t1.getVariable_C().equals(t2.getVariable_C()))) {
                                v_C = t2.getVariable_C();
                            } else {
                                v_C = t1.getVariable_C();
                            }
                        }
                        if (t1.getVariable_D() != null && t2.getVariable_D() != null) {
                            if (!(t1.getVariable_D().equals(t2.getVariable_D()))) {
                                v_D = t2.getVariable_D();
                            } else {
                                v_D = t1.getVariable_D();
                            }
                        }
                        if (t1.getVariable_E() != null && t2.getVariable_E() != null) {
                            if (!(t1.getVariable_E().equals(t2.getVariable_E()))) {
                                v_E = t2.getVariable_E();
                            } else {
                                v_E = t1.getVariable_E();
                            }
                        }
                        if (t1.getVariable_F() != null && t2.getVariable_F() != null) {
                            if (!(t1.getVariable_F().equals(t2.getVariable_F()))) {
                                v_F = t2.getVariable_F();
                            } else {
                                v_F = t1.getVariable_F();
                            }
                        }
                        if (t1.getVariable_G() != null && t2.getVariable_G() != null) {
                            if (!(t1.getVariable_G().equals(t2.getVariable_G()))) {
                                v_G = t2.getVariable_G();
                            } else {
                                v_G = t1.getVariable_G();
                            }
                        }
                        Term adding = new Term(v_A, v_B, v_C, v_D, v_E, v_F, v_G);
                        //TODO: works not as predicted!
                        if (combinedTerms.isEmpty()) {
                            combinedTerms.add(adding);
                        } else if (combinedTerms.stream().noneMatch(x -> x.equals(adding))) {
                            combinedTerms.add(adding);
                        }
                    }
                }
            }
        }
        return combinedTerms;
    }

    public List<Term> sortTerms() {
        List<Term> sortedList = new ArrayList<>();
        Map<Term, Long> mappingNumber_of_Negations = countNegationsPerTerm();

        List<Map.Entry<Term, Long>> sortingList = new ArrayList<>(mappingNumber_of_Negations.entrySet());
        sortingList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Term, Long> entry : sortingList) {
            sortedList.add(entry.getKey());
            //System.out.println(entry.getKey().getCompleteTerm());
        }

        return sortedList;
    }

    private Map<Term, Long> countNegationsPerTerm() {
        Map<Term, Long> mappingNumber_of_Negations = new HashMap<>();

        for (Term t : termTable) {
            String s = t.getCompleteTerm();
            long number_of_Negation = s.chars().filter(ch -> ch == '~').count();
            mappingNumber_of_Negations.put(t, number_of_Negation);
        }
        return mappingNumber_of_Negations;
    }

    private void createTermTable() {
        String[] termtable = all_terms_combined.split("\\u002B");
        for (String s : termtable) {
            termTable.add(new Term(s.trim()));
        }
    }

    public String getAll_terms_combined() {
        return all_terms_combined;
    }

    public List<Term> getTermTable() {
        return termTable;
    }
}

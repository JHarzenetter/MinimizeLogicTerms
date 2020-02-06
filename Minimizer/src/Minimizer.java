import java.io.*;
import java.util.*;

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
                sb.append(" AND ");
            }
            sb.deleteCharAt(sb.length() - 1);
            all_terms_combined = sb.toString();
            createTermTable();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public void createTermTable() {
        String[] termtable = all_terms_combined.split("AND");
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

    private void compareTerms(){
        //TODO: compare terms, on matching 0 and 1
    }

    public List<Term> sortTerms(){
        Map<Term, Long> mappingNumber_of_Negations = new HashMap<>();
        List<Term> sortedTerms = new ArrayList<>();
        for (Term t : termTable){
            String s = t.getCompleteTerm();
            long number_of_Negation = s.chars().filter(ch-> ch == '~').count();
            mappingNumber_of_Negations.put(t, number_of_Negation);
            //System.out.println(number_of_Negation);
        }
        //mappingNumber_of_Negations.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
        mappingNumber_of_Negations.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(x->sortedTerms.add(x.getKey()));

        /*for(Term t : sortedTerms){
            System.out.println(t.getCompleteTerm());
        }*/

        return sortedTerms;
    }

    private List<Term> create_Primterms(){
        termTable = sortTerms();

        //result should be only the minimal form
        return null;
    }
}

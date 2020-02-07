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
                sb.append(" OR ");
            }
            sb.deleteCharAt(sb.length() - 1);
            all_terms_combined = sb.toString();
            createTermTable();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public List<Term> create_Prime_Terms(){

        //result should be only the minimal form
        return null;
    }

    //helper methods below
    private void compareTerms(){
        //TODO: compare terms, on matching 0 and 1
        Map<Term, Long> negationMapping = countNegationsPerTerm();
        List<Term> sortedTermList = sortTerms();

        for(int i=0; i<sortedTermList.size(); i++){
            //TODO: vergleichen nur wenn NegationsDiff = 1
            if(sortedTermList.get(i+1) != null){
                Term t1 = sortedTermList.get(i);
                Term t2 = sortedTermList.get(i++);
                if(negationMapping.get(t1) > negationMapping.get(t2) ||
                        negationMapping.get(t1) == negationMapping.get(t2)){
                    //TODO: compare single variables of terms
                }
            }
        }

    }

    public List<Term> sortTerms(){
        List<Term> sortedList = new ArrayList<>();
        Map<Term, Long> mappingNumber_of_Negations = countNegationsPerTerm();

        List<Map.Entry<Term, Long>> sortingList = new ArrayList<>(mappingNumber_of_Negations.entrySet());
        sortingList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<Term, Long>  entry : sortingList){
            sortedList.add(entry.getKey());
            //System.out.println(entry.getKey().getCompleteTerm());
        }

        return sortedList;
    }

    private Map<Term, Long> countNegationsPerTerm(){
        Map<Term, Long> mappingNumber_of_Negations = new HashMap<>();

        for (Term t : termTable){
            String s = t.getCompleteTerm();
            long number_of_Negation = s.chars().filter(ch-> ch == '~').count();
            mappingNumber_of_Negations.put(t, number_of_Negation);
        }
        return mappingNumber_of_Negations;
    }

    private void createTermTable() {
        String[] termtable = all_terms_combined.split("OR");
        for (String s : termtable) {
            termTable.add(new Term(s.trim()));
        }
    }

    public String getAll_terms_combined() {
        return all_terms_combined;
    }

    private Term combineTerms(Term t1, Term t2){

        return null;
    }

    public List<Term> getTermTable() {
        return termTable;
    }
}

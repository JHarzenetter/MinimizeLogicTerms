import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    }

    private List<Term> create_Primterms(){



        return null;
    }
}

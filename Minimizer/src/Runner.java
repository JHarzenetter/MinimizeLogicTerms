import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Minimizer minimizer = new Minimizer();
        minimizer.initialize();
        System.out.println("complete: " + minimizer.getAll_terms_combined());
        //System.out.println(minimizer.compare_combine_Terms(minimizer.getTerms()).size());
        /*for(Term t : a){
            System.out.println(t.getCompleteTerm());
        }
        for (Term t : minimizer.compare_combine_Terms_rek(minimizer.getTerms())){
            System.out.println(t.getCompleteTerm());
        }*/
        //List<Term> ayy = minimizer.compare_combine_Terms_rek(minimizer.getTerms());

        System.out.println(minimizer.create_Prime_Terms().size());
        //System.out.println(minimizer.getPrimeTable().size());
        for(Term t : minimizer.getPrimeTable()){
            System.out.println(t.getCompleteTerm());
        }
    }
}

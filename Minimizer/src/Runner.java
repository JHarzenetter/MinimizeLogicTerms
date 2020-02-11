import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Minimizer minimizer = new Minimizer();
        minimizer.initialize();
        System.out.println("complete: " + minimizer.getAll_terms_combined());
        System.out.println(minimizer.compare_combine_Terms().size());
        /*for(Term t : a){
            System.out.println(t.getCompleteTerm());
        }*/
        for (Term t : minimizer.compare_combine_Terms()){
            System.out.println(t.getCompleteTerm());
        }

        System.out.println(minimizer.getPrimeTable().size());
    }
}

public class Runner {
    public static void main(String[] args) {
        Minimizer minimizer = new Minimizer();
        minimizer.initialize();
        minimizer.sortTerms();
        System.out.println("complete: " + minimizer.getAll_terms_combined());

        /*for(Term t : minimizer.getTermTable()){
            System.out.println(t.getCompleteTerm());
        }*/
    }
}

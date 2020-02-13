import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Minimizer minimizer = new Minimizer();
        minimizer.initialize();
        System.out.println("complete: " + minimizer.getAll_terms_combined());
        System.out.println();
        System.out.println("Shortend: ");
        System.out.println(minimizer.create_Prime_Terms());

    }
}

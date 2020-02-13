import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Minimizer minimizer = new Minimizer();
        minimizer.initialize();
        System.out.println("complete: " + minimizer.getAll_terms_combined());
        System.out.println();
        System.out.println("Shortend: ");
        long time = System.nanoTime();
        System.out.println(minimizer.create_Prime_Terms());
        System.out.println("Time in ms: " + ((System.nanoTime()-time)/1000000));
    }
}

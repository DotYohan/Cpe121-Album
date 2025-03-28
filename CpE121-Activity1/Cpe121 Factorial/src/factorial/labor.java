package factorial;

/**
 *
 * @author yuanb
 */
public class labor {

    private int n;
    private int nn;

    public labor() {
        this.n = 0;
        this.nn = 0;
    }

    public void calculateFac(int input) {
        nn = input;
        for (int i = 1; i <= nn; i++) {
            System.out.println("i value; " + i);
            input *= i;
            n = input;
        }
        System.out.println("The factorial of " + nn + "is " + n);
    }

    public void displayResult() {
        System.out.println("The factorial of " + nn + "is " + n);
        System.out.println("n value: " + n);
        System.out.println("nn value: " + nn);
    }
}

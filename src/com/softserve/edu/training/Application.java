/**
 * @author Yurii Spirniak
 */
package com.softserve.edu.training;

/**
 * Main body.
 */
public final class Application {
    /**
     * Private constructor.
     */
    private Application() {
    }

    /**
     * @param args supplies command-line arguments as an array of String objects
     */
    public static void main(final String[] args) {
        Input br = new Input();
        Output output = new Output();
        GetFirst first = new GetFirst();
        Pascal pscl = new Pascal();

/*        output.out(first.firstAmount(first.fillArray(br.input())));*/
        output.out(first.secondAmount(first.fillArray(br.input())));
/*        output.out(pscl.generatePascal(br.input()));*/

        br.closeBR();
    }

}

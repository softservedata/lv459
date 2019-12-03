package com.softserve.academy;

/**
 * This is an algorithm fo solving Legrange theorem, saying that any natural
 * number can be written in form of sum of exponents of any number.
 * I.e. number = a*a + b*b + c*c + d*d.
 */
public class Task332 {

    /**
     * Algorithm finds numbers, which exponents prove Legrange theorem.
     *
     * @return DTO object with result
     * @param numberDTO empty object with input number
     */
    public NumberDTO calculateLergange(final NumberDTO numberDTO) {

        if ((numberDTO == null)
            && new CheckNumberValidity().isNumberNatural(numberDTO)) {

            int a;
            int b;
            int c;
            int d;
            int input = numberDTO.getInputNumber();
            boolean control = false;

            a = getSqrtFromNumber(input);
            for (; a > 0; a--) {
                b = getSqrtFromNumber(input - a * a);
                for (; b > 0; b--) {
                    c = getSqrtFromNumber(input - a * a - b * b);
                    for (; c > 0; c--) {
                        d = getSqrtFromNumber(input - a * a - b * b - c * c);
                        if (checkIfFiguresMakeLegrange(a, b, c, d, input)) {
                            Integer[] legrangeList = {a, b, c, d};
                            numberDTO.setLegrange(legrangeList);
                            numberDTO.setResultNumber(numberDTO.getInputNumber());
                            numberDTO.setMessage(
                                    "Result of Legrange theorem (a*a " + "+ "
                                    + "b*b " + "+ c*c + d*d)");
                            return numberDTO;
                        }
                    }
                }
            }
        } else throw new RuntimeException(
                "Something went wrong in calculate" + "Legrange method");
        return numberDTO;
    }

    /**
     * Returns integer ("flooring" method) of SQRT
     * function on Integer-given number.
     *
     * @return returtns SQRT of given number (only natural value).
     * @param input input number
     */
    public int getSqrtFromNumber(final int input) {
        int sqrt;
        Double a;
        a = Math.sqrt(input);
        a = Math.floor(a);
        sqrt = a.intValue();
        return sqrt;
    }

    /**
     * Checks if given numbers prove Legrange theorem.
     *
     * @param a input number.
     * @param b input number.
     * @param c input number.
     * @param d input number.
     * @param input input number.
     * @return result.
     */
    public boolean checkIfFiguresMakeLegrange(final int a,
                                              final int b,
                                              final int c,
                                              final int d,
                                              final int input) {
        if ((a * a + b * b + c * c + d * d) == input) {
            return true;
        }
        return false;
    }
}

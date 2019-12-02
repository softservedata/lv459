package com.softserve;

public final class Main {

    private Main() {

    }

    /**
     * @param args Input parameters.
     */
    public static void main(final String[] args) {
        NumberOperations nop = new NumberOperations();
        ConsoleOperations consOp = new ConsoleOperations();

         consOp.consolePrint(nop.getDigitsCount(consOp.readInt()));
        // consOp.consolePrint(nop.getSumOfDigits(consOp.readInt()));
        //consOp.consolePrint(nop.getAllPerfectNumbers(consOp.readInt()));
        ConsoleOperations.close();
    }
}

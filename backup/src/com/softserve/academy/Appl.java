package com.softserve.academy;

/** Main class that starts program. */
public final class Appl {

    private Appl() {
    }

    /**
     * Method that starts program.
     *
     * @param args arguments to start program.
     */
    public static void main(String[] args) {

        InOut inOut = new InOut();
        NumberDTO numberDTO = new NumberDTO(inOut.inputNumber());

        Task88C task88C = new Task88C();
        task88C.doTask88c(numberDTO);
        inOut.outputResult(numberDTO);

        Task88D task88D = new Task88D();
        task88D.doTask88D(numberDTO);
        inOut.outputResult(numberDTO);

        Task332 legrange = new Task332();
        legrange.calculateLergange(numberDTO);
        inOut.outputResult(numberDTO);

    }


}

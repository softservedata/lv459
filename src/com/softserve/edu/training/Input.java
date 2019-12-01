package com.softserve.edu.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class implements input methods.
 */
public class Input {
    /**
     * @return user's input value.
     */
    public int input() {
        Output output = new Output();
        output.out("Your number: ");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        try {
            String number = br.readLine();
            result = Integer.parseInt(number);
            return result;
        } catch (IOException e) {
            output.out(e.getMessage());
        }
        return result;
    }

    /**
     * Closes buffered reader.
     */
    public void closeBR() {
        Output output = new Output();
        try {
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            br.close();
        } catch (IOException e) {
            output.out(e.getMessage());
        }
    }
}

package com.softserve.academy;

import java.util.Arrays;

public class NumberDTO {

    public NumberDTO() {
    }

    public NumberDTO(final int inputNumber) {
        this.inputNumber = inputNumber;
    }

    private int inputNumber;
    private int resultNumber;
    private String message;
    private Integer[] legrange;

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(final int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(final int resultNumber) {
        this.resultNumber = resultNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer[] getLegrange() {
        return legrange;
    }

    public void setLegrange(Integer[] legrange) {
        this.legrange = legrange;
    }

    @Override
    public String toString() {
        return "NumberDTO{" +
                "inputNumber=" + inputNumber +
                ", resultNumber=" + resultNumber +
                ", message='" + message + '\'' +
                ", legrange=" + Arrays.toString(legrange) +
                '}';
    }
}


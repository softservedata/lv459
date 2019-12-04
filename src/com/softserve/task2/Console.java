package com.softserve.task2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    public int input()  {
        Scanner n = new Scanner(System.in);
        System.out.print("Enter any number > 1: ");
        int number = n.nextInt();
        return number;
    }

    public void outValues(List<DataDTO> listDTO) {

        for( int i = 0; i < listDTO.size(); i++) {
            System.out.println(listDTO.get(i));
        }
    }

    public void outValues(int y) {
        System.out.println(y);
    }

}

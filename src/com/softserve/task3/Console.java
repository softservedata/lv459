package com.softserve.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    public int input() {
        Scanner n = new Scanner(System.in);
        System.out.print("Enter any number > 1: ");
        int number = n.nextInt();
        return number;
    }

    public void outValues(List<DataDTO> list) {

        for( int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
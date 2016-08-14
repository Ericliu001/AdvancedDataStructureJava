package com.ericliu.developer;

import java.util.Scanner;

/**
 * Created by ericliu on 5/08/2016.
 */

public class StandardInputOutput {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

//        printIntegerInput();

        int[] array = createArrayFromInputString();

        for (int i : array) {
            System.out.print(" " + i + " ");
        }
    }

    private static int[] createArrayFromInputString() {
        Scanner scanner = new Scanner(System.in);
        String line = "";

        System.out.println("input String: ");


        line = scanner.nextLine();

        String[] split = line.split(" ");
        int[] intArray = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            intArray[i] = Integer.valueOf(split[i]);
        }

        return intArray;
    }


    private static void printIntegerInput() {

        Scanner scanner = new Scanner(System.in);

        int count = 0;
        while (scanner.hasNextInt() && count < 2) {
            int myInt = scanner.nextInt();
            System.out.println("myInt is: " + myInt);
            count++;
        }

        scanner.close();


    }
}

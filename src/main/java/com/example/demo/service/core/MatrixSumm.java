package com.example.demo.service.core;

import java.util.Random;

public class MatrixSumm {
    private int[][] a = new int[5][5];

    public MatrixSumm() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = new Random().nextInt(9);
            }
        }
    }

    public static void main(String[] args) {
        MatrixSumm matrixSumm = new MatrixSumm();
        matrixSumm.test();
    }

    private int calculateMatrix(int[][] array) {
        int summ = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; i < 5; i++) {
                if (i == j)
                    summ += array[i][j];
            }
        }
        return summ;
    }

    public String test() {
        int summ = 0;
        String s = "fail";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; i < 5; i++) {
                if ((i == j))
                    summ += a[i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }

        System.out.println(summ);
        System.out.println(calculateMatrix(a));
        if (summ == calculateMatrix(a)) {
            s = "success";
        }
        System.out.println(s);
        return s;
    }
}





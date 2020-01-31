package io.github.rytb2009.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HomeworkOne {

    public static void main(String[] args) {
        int gcdX = 36;
        int gcdY = 48;
        System.out.printf("gcd of %d and %d is : %d\n", gcdX, gcdY, gcd(gcdX, gcdY));

        int[] evenArr = {2, 10, 8, 9, 7, 5};
        System.out.printf("sum evenArr of %s = %s\n", Arrays.toString(evenArr), sumEven(evenArr));

        int[] sortArr = {1, 2, 3, 4, 5, 2};
        System.out.printf("array %s is sorted - %s\n", Arrays.toString(sortArr), sorted(sortArr));

        int[] copyArr = {1, 2, 3, 4, 5, 2, 4, 6};
        System.out.printf("array %s is copied - %s\n", Arrays.toString(copyArr), Arrays.toString(copyArr));

        int[] dupArr = {1, 2, 3, 4, 5, 6, 6, 1, 1};
        System.out.printf("array %s after eliminate duplicate %s\n", Arrays.toString(dupArr), Arrays.toString(eliminateDuplicates(dupArr)));

        char[][] ticTacToe = {{X, O, O},
                              {X, X, O},
                              {O, X, X}};
        System.out.println("Tic tac toe result is " + tic_tac_toe(ticTacToe));

        String longStr = "010110";
        System.out.printf("Binary string %s to int %d ", longStr, bin_str_to_int(longStr));
    }

    private static int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        return gcd(max % min, min);
    }

    private static int sumEven(int[] a) {
        return Arrays.stream(a).filter(i -> i % 2 == 0).sum();
    }

    private static boolean sorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] copy(int[] a) {
        int[] copyA = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copyA[i] = a[i];
        }
        return copyA;
    }

    private static int[] eliminateDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int v: a) {
            set.add(v);
        }
        return set.stream().mapToInt(i -> i).toArray();
    }

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char DRAW = 'D';
    private static char tic_tac_toe(char[][] grid) {
        boolean match = false;
        ROW_CHECK:
        for (int row = 0; row < grid[0].length; row++) {
            char c = grid[row][0];
            for (int column = 1; column < grid[0].length; column++) {
                match = c == grid[row][column];
                if (!match) {
                    continue ROW_CHECK;
                }
            }
            if (match) {
                return c;
            }
        }

        COLUMN_CHECK:
        for (int column = 0; column < grid[0].length; column++) {
            char c = grid[0][column];
            for (int row = 1; row < grid[0].length; row++) {
                match = c == grid[row][column];
                if (!match) {
                    continue COLUMN_CHECK;
                }
            }
            if (match) {
                return c;
            }
        }

        //DIAGONAL_CHECK
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[1][1];
        }

        //REVERSE_DIAGONAL_CHECK
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[1][1];
        }

        return DRAW;
    }

    private static long bin_str_to_int(String binStr) {
        return Long.parseLong(binStr, 2);
    }
}

package io.github.rytb2009.homework.seven;

import java.util.Arrays;

public class HomeworkSeven {
    // merge sort by recursion
    // interview questions - geeks https://www.geeksforgeeks.org/practice-for-cracking-any-coding-interview/#recursion

    public static void main(String[] args) {
        int[] array = {10, 5, 1, 1, 6, 7, 20};
        System.out.println(Arrays.toString(mergeSort(array)));
        printPattern(16);
        System.out.println(towerOfHanoi(4, 1, 2, 3));
        System.out.println(josephus(4, 2));
        System.out.println(removeAdjDuplicate("ABAABBCCDDE"));
        permutation("AB");
    }

    private static int[] mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return array;
        }
        int[] firstHalf = mergeSort(Arrays.copyOfRange(array, 0, length / 2));
        int[] secondHalf = mergeSort(Arrays.copyOfRange(array,length / 2, length));
        return merge(firstHalf, secondHalf);
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] mergeArray = new int[firstHalf.length + secondHalf.length];
        int firstHalfIndex = 0, secondHalfIndex = 0, arrayIndex = 0;
        while (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
            int firstHalfValue = firstHalf[firstHalfIndex];
            int secondHalfValue = secondHalf[secondHalfIndex];
            if (firstHalfValue <= secondHalfValue) {
                mergeArray[arrayIndex] = firstHalfValue;
                firstHalfIndex++;
            } else {
                mergeArray[arrayIndex] = secondHalfValue;
                secondHalfIndex++;
            }
            arrayIndex++;
        }
        while (firstHalfIndex < firstHalf.length) {
            mergeArray[arrayIndex] = firstHalf[firstHalfIndex];
            firstHalfIndex++;
            arrayIndex++;
        }
        while (secondHalfIndex < secondHalf.length) {
            mergeArray[arrayIndex] = secondHalf[secondHalfIndex];
            secondHalfIndex++;
            arrayIndex++;
        }
        return mergeArray;
    }

    private static void printPattern(int n) {
        if (n <= 0) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printPattern(n - 5);
        System.out.println(n);
    }

    private static int towerOfHanoi(int n, int from, int aux, int to) {
        if (n == 0)
            return 0;
        int x = towerOfHanoi(n - 1, from, to, aux);
        System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
        int y = towerOfHanoi(n - 1, aux, from, to);
        return x + y + 1 ;
    }

    private static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + josephus(n - 1, k) - 1) % n + 1;
    }

    private static String removeAdjDuplicate(String s) {
        return String.copyValueOf(removeAdjDuplicateHelper(s.toCharArray()));
    }

    private static char[] removeAdjDuplicateHelper(char[] chars)  {
        if(chars.length < 1) {
            return new char[0];
        }
        if(chars.length == 1) {
            return chars;
        }
        for(int i=0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1]) {
                char[] before = Arrays.copyOfRange(chars, 0, i);
                char[] after = Arrays.copyOfRange(chars, i + 2, chars.length);
                char[] joined = new char[before.length + after.length];
                System.arraycopy(before, 0, joined, 0, before.length);
                System.arraycopy(after, 0, joined, before.length, after.length);
                chars = removeAdjDuplicateHelper(joined);
                break;
            }
        }
        return chars;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) floodFill(image, sr, sc, color, newColor);
        return image;
    }

    public void floodFill(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) floodFill(image, r - 1, c, color, newColor);
            if (c >= 1) floodFill(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) floodFill(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) floodFill(image, r, c + 1, color, newColor);
        }
    }


    /*
    ABC - ABC ACB BAC BCA CAB CBA
    ABSG - ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
    */
    private static void permutation(String s) {
        permutation("", s);
    }

    private static void permutation(String permutation, String word) {
        if (word.isEmpty()) {
            System.out.println(permutation);
        } else {
            for (int i = 0; i < word.length(); i++) {
                String nextPermutation = permutation + word.charAt(i);
                permutation(nextPermutation, word.substring(0, i) + word.substring(i + 1));
            }
        }
    }
}

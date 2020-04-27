package io.github.rytb2009.homework;

import java.util.*;

public class HomeworkThree {

    public static void main(String[] args) {
        System.out.println("----Q1----");
        List<Integer> countZeroNumbers = new LinkedList<>();
        countZeroNumbers.add(0);
        countZeroNumbers.add(0);
        countZeroNumbers.add(2);
        countZeroNumbers.add(3);
        System.out.println(2 == countZero(countZeroNumbers));

        System.out.println("----Q2----");
        List<Integer> largeSmallNumbers = new LinkedList<>();
        largeSmallNumbers.add(4);
        largeSmallNumbers.add(10);
        largeSmallNumbers.add(-2);
        largeSmallNumbers.add(3);
        List<Integer> largeSmallResult = findLargeSmall(largeSmallNumbers);
        System.out.println(-2 == largeSmallResult.get(0));
        System.out.println(10 == largeSmallResult.get(1));

        System.out.println("----Q3----");
        printPascalTriangle(10);

        System.out.println("----Q4----");
        int[][] twoDArray = {{1, 3, 2},
                             {3, 3, 4},
                             {2, 4, 2}};
        System.out.println(isDiagonal(twoDArray));
        int[][] twoDArray2 = {{1, 2, 1},
                              {6, 3, 6},
                              {1, 2, 1}};
        System.out.println(isDiagonal(twoDArray2));

        System.out.println("----Q5----");
        String evalStr = "1 3 + 5 7 + *";
        System.out.println(48 == evalRPN(evalStr));

        System.out.println("----Q6----");
        PairOfString[] paArray = {new PairOfString("aaa", "bbb"),
                                  new PairOfString("ccc", "ddd"),
                                  new PairOfString("ccc", "ddd"),
                                  new PairOfString("ccc", "ddd"),
                                  new PairOfString("eee", "fff"),
                                  new PairOfString("aaa", "aaa")};
        System.out.println(new PairOfString("ccc", "ddd").equals(findMostCommentElement(paArray)));

        System.out.println("----Q7----");
        findUniquePostiveNum();
    }

    private static int countZero(List<Integer> numbers) {
        int counter = 0;
        for (int number: numbers) {
            counter = number == 0 ? counter + 1 : counter;
        }
        return counter;
    }
    
    private static List<Integer> findLargeSmall(List<Integer> numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number: numbers) {
            largest = Math.max(number, largest);
            smallest = Math.min(number, smallest);
        }
        Integer[] largeSmallArray = {smallest, largest};
        return Arrays.asList(largeSmallArray);
    }

    private static void printPascalTriangle(int rows) {
        if (rows <= 0) {
            System.out.println("Invalid row number.");
            return;
        }
        int[] lastRowNumbers = null;
        for (int i = 1; i <= rows; i++) {
            int[] thisRowNumbers = new int[i];
            thisRowNumbers[0] = 1;
            if (lastRowNumbers != null) {
                for (int j = 1; j < lastRowNumbers.length; j++) {
                    thisRowNumbers[j] = lastRowNumbers[j - 1] + lastRowNumbers[j];
                }
            }
            thisRowNumbers[i - 1] = 1;
            lastRowNumbers = thisRowNumbers;
            System.out.println(Arrays.toString(thisRowNumbers));
        }
    }

    private static boolean isDiagonal(int[][] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[i][j] != array[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int evalRPN(String expression) {
        Stack<Integer> deque = new Stack<>();
        for (char c: expression.toCharArray()) {
            if (Character.isDigit(c)) {
                deque.push(Character.getNumericValue(Integer.valueOf(c)));
            } else if (deque.size() > 1) {
                switch (c) {
                    case '+':
                        deque.push(deque.pop() + deque.pop());
                        break;
                    case '*':
                        deque.push(deque.pop() * deque.pop());
                        break;
                    default:
                        continue;
                }
            }
        }
        return deque.pop();
    }

    private static PairOfString findMostCommentElement(PairOfString[] array) {
        int max = 0;
        PairOfString mostCommentElement = null;
        Map<PairOfString, Integer> map = new HashMap<>();
        for (PairOfString pa: array) {
            int count = map.getOrDefault(pa, 0) + 1;
            map.put(pa, count);
            if (count > max) {
                max = count;
                mostCommentElement = pa;
            }
        }
        return mostCommentElement;
    }

    private static class PairOfString {
        private String strOne;
        private String strTwo;

        public PairOfString(String strOne, String strTwo) {
            this.strOne = strOne;
            this.strTwo = strTwo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PairOfString that = (PairOfString) o;
            return Objects.equals(strOne, that.strOne) &&
                    Objects.equals(strTwo, that.strTwo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(strOne, strTwo);
        }
    }

    private static final long MIN_NUM = 1010101010; //sqrt root of 1020304050607080900
    private static final long MAX_NUM = 1389026623; //sqrt root of 1929394959697989990
    private static void findUniquePostiveNum() {
        for (long i = MIN_NUM; i <= MAX_NUM; i++) {
            long num = i * i;
            if (matchPattern(num)) {
                System.out.printf("Square of %d is %d.", i , num);
            }
        }
    }

    //1_2_3_4_5_6_7_8_9_0
    private static boolean matchPattern(long num) {
        for (int i = 10; i > 0; i--) {
            if (num % 10 != i % 10) {
                return false;
            }
            num /= 100;
        }
        return true;
    }
}

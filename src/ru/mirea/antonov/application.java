package ru.mirea.antonov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        int[] numberArray1;
        int[] numberArray2;
        int[] Array;
        int arrayLenght;

        System.out.println("Введите размер массива:");
        Scanner scan = new Scanner(System.in);
        arrayLenght = scan.nextInt();

        numberArray1 = new int[arrayLenght];
        numberArray2 = new int[arrayLenght];
        Random random = new Random();

        for (int i = 0; i < arrayLenght; i++) {
            numberArray1[i] = random.nextInt(-100, 100);
        }
        for (int i = 0; i < arrayLenght; i++) {
            numberArray2[i] = random.nextInt(-100, 100);
        }

        Arrays.sort(numberArray1);
        Arrays.sort(numberArray2);
        System.out.println(Arrays.toString((numberArray1)));
        System.out.println(Arrays.toString((numberArray2)));

        Array = new int[arrayLenght];
        int i = 0;
        for (int num : numberArray1) {
            if (search(numberArray2, num)) {
                Array[i] = num;
                i++;
            }
        }

        int[] answerArray = new int[i];
        for (int j = 0; j < i; j++) {
            answerArray[j] = Array[j];
        }
        System.out.println(Arrays.toString(answerArray));

    }

    public static boolean search(int[] numberArray, int numToFind) {
        if (numToFind > numberArray[numberArray.length - 1] || numToFind < numberArray[0]) {
            return false;
        }
        int low = 0;

        int high = numberArray.length;

        int middle;
        // Код счётчика итераций закоменчен, т.к. в итоговой задаче будет слишком много спама
        // int cnt = 0;
        while (low <= high) {
            // cnt++;
            // System.out.println("Кол-во итераций: ", cnt);
            middle = (low + high) / 2;

            int num = numberArray[middle];

            if (num == numToFind) {
                // System.out.println("Значение найдено под индексом " + middle);
                return true;
            } else if (num > numToFind) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        // System.out.println("Искомого значения в массиве нет");
        return false;
    }
}
package ru.rusalitc.java.basic.homework8;


import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.toString(i + j);
            }
        }
        System.out.println(Arrays.deepToString(arr));

        arr[2][3] = "Q"; // Проверка на ошибку
        System.out.println(Arrays.deepToString(arr));
        sumArr(arr);

    }

    public static void sumArr(String[][] arr) {
        for (int i = 0; i < 4; i++) {
            if (arr.length != 4 || arr[i].length != 4) {
                throw new AppArraySizeExeption("Массив должен быть размером только 4х4");
            }
        }
        int sumA = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    sumA += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new AppArrayDataExeption("Элемент массива в ячейке: [" + i + "]" + "[" + j + "]" + " не может быть переведен в число, сумма массива не может быть подсчитана корректно");

                }

            }

        }
        System.out.println(sumA);
    }

    public static class AppArraySizeExeption extends RuntimeException {
        public AppArraySizeExeption(String message) {
            super(message);
        }
    }

    public static class AppArrayDataExeption extends RuntimeException {
        public AppArrayDataExeption(String message) {
            super(message);
        }

    }
}
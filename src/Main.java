import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int flag = 0;
        int input[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                input[i][j] = scanner.nextInt();
            }
        }

        float e = 0.0001f;// = scanner.nextInt();
        int[][] a = new int[rows][columns - 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 1; j++) {
                a[i][j] = input[i][j];
            }
        }


        int[] b = new int[rows];
        for (int i = 0; i < rows; i++) {
            b[i] = input[i][columns - 1];
        }

        float[] x = new float[rows];

        System.out.println("Проверка условия на сходимость");

        for (int sumj = 0, i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 1; j++) {
                if (i != j) {
                    sumj += a[i][j];
                }
                if (abs(sumj) > abs(a[i][i])) {
                    System.out.println("Нарушено условие сходимости");
                    flag = 1;
                }
            }
            if (flag == 1) {
                break;
            }
            sumj = 0;
        }
        float[] prevX;
        int k = 0;
        float[] measurements = new float[x.length];
        while (flag == 0) {
            int counter = 0;
            prevX = x;
            for (int sumj = 0, i = 0; i < x.length; i++) {
                for (int j = 0; j < x.length; j++) {
                    if (i != j) {
                        sumj += a[i][j] * prevX[i];
                    }
                }
                x[i] = (b[i] - sumj) / a[i][i];
                k++;
                sumj = 0;
            }

            for (int i = 0; i < x.length; i++) {
                if (abs(x[i] - prevX[i]) < e) {
                    measurements[i] = abs(x[i] - prevX[i]);
                    counter++;
                }
            }

            if (counter == x.length) {

                break;
            }
            System.out.println(counter + " " + columns);
        }


        for (float v : x) {
            System.out.println(v);
        }

        for (int i = 0; i < measurements.length; i++) {
            System.out.printf("Погрешность %d  = %f ", i, measurements[i]);
        }

        System.out.println("K = " + k);
    }

}

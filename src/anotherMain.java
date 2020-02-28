import java.util.Scanner;

import static java.lang.Math.abs;

public class anotherMain {

    public static void main(String[] args) {

        int rows;
        int columns;
        double a[][];
        double b[];
        double e;
        Scanner scanner = new Scanner(System.in);
        InputOutput inputOutput = new InputOutput();
        boolean meansuresFlag = true, priorityFlag = true;
        while (true) {
            System.out.println("Ввод с файла? (Y/another)");
            if (scanner.nextLine().equals("Y")) {

                a = inputOutput.readOddsFromFile();
                b = inputOutput.readB();
                e = inputOutput.readEpsilon();
                rows = a.length;
                columns = a.length;

            } else {
                inputOutput.getInputs();
                a = inputOutput.getA();
                b = inputOutput.getB();
                e = inputOutput.getEpsilone();
                rows = a.length;
                columns = a.length;
            }
            for (int sumj = 0, i = 0; i < rows; i++) {
                sumj = 0;
                for (int j = 0; j < columns; j++) {
                    if (i != j) {
                        sumj += a[i][j];
                    }
                }
                if (abs(sumj) > abs(a[i][i])) {
                    priorityFlag = false;
                } else {
                    priorityFlag = true;
                }
            }

            if (priorityFlag) {
                break;
            } else {
                System.out.println("Отсутствует условие сходимости, введите коэффициенты повторно");
            }
        }

        double[] prevX = new double[rows];
        double[] x = new double[rows];
        int k = 0;
        double[] meansures = new double[rows];
        while (true) {
            System.arraycopy(x, 0, prevX, 0, rows);
            for (int i = 0; i < x.length; i++) {
                double sumj = 0;
                for (int j = 0; j < x.length; j++) {
                    if (i != j) {
                        sumj += a[i][j] * prevX[i];
                    }
                }
                x[i] = (b[i] - sumj) / (a[i][i]);
            }
            for (int i = 0; i < x.length; i++) {
                if (abs(x[i] - prevX[i]) > e) {
                    meansuresFlag = false;
                } else {
                    meansures[i] = abs(x[i] - prevX[i]);
                    meansuresFlag = true;
                }
            }

            if (meansuresFlag) {
                break;
            }
            k++;

        }
        inputOutput.setOutputs(x, meansures, k);
        inputOutput.getOutput();
    }
}

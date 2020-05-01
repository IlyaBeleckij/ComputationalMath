import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class InputOutput {

    private Integrator integrator;
    private Data data;

    public void inputData() throws Exception {
        integrator = new Integrator();
        System.out.println("Choose the function");
        for(int i = 0; i < integrator.getFunctions().length; i++) {
            System.out.println((i + 1) + " " + integrator.getFunctions()[i]);
        }

        Scanner scanner = new Scanner(System.in);
        int method = scanner.nextInt();
        System.out.println("Choose RectangleMethod");
        for(int i = 0; i < integrator.getRectangleMethods().length; i++) {
            System.out.println((i + 1) + " " + integrator.getRectangleMethods()[i]);
        }
        int rectangleMethod = scanner.nextInt();
        System.out.println("Нижняя граница интегрирования");
        double leftBound = scanner.nextDouble();
        System.out.println("Верхняя граница интегрирования");
        double rightBound = scanner.nextDouble();
        System.out.println("Введите точность");
        double precision = scanner.nextDouble();
        data = new Data(leftBound, rectangleMethod, rightBound, precision, method);
        // integrator.integrate(leftBound, rightBound, precision, method, rectangleMethod);
    }

    public Data getData() {
        return data;
    }

    public void outResults(@NotNull double[] results) {
        System.out.println("Ответ = " + ' ' + results[0] + "\nКоличество разбиений = " + results[1] + "\nТочность = " + results[2]);
    }
}

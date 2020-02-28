import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Scanner;

public class InputOutput {

    private double epsilone;
    private double[][] a;
    private double[] b;
    private double[] x;
    private double[] meansures;
    private int k;

    private Scanner scanner = new Scanner(System.in);
    private JSONParser jsonParser = new JSONParser();

    public double[][] readOddsFromFile() {
        double[][] matrix = new double[0][];
        try (FileReader reader = new FileReader("input.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject oddsJSON = (JSONObject) obj;
            JSONArray oddsArray = (JSONArray) oddsJSON.get("odds");
            int n = oddsArray.size();
            matrix = new double[n][n];
            String rowString;
            for (int i = 0; i < n; i++) {
                rowString = (String) oddsArray.get(i);
                String[] splitted = rowString.split(" ");
                for (int j = 0; j < splitted.length; j++) {
                    matrix[i][j] = Double.parseDouble(splitted[j]);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка файла JSON");
        }
        return matrix;
    }

    public double readEpsilon() {
        double epsilon;
        try (FileReader reader = new FileReader("input.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject epsilonJSON = (JSONObject) obj;
            epsilon = Double.parseDouble((String) epsilonJSON.get("epsilon"));
            return epsilon;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Ошибка файла JSON");
            return 0;
        }
    }

    public double[] readB() {
        double[] b = new double[0];
        try (FileReader reader = new FileReader("input.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject bObject = (JSONObject) obj;
            String bString = (String) bObject.get("b");
            String[] splitted = bString.split(" ");
            int n = splitted.length;
            b = new double[n];
            for (int i = 0; i < n; i++) {
                b[i] = Double.parseDouble(splitted[i]);
            }

        } catch (Exception e) {
            System.err.println("Ошибка файла JSON");
        }
        return b;
    }

    public void getInputs() {
        System.out.println("Введите n");
        int n = scanner.nextInt();
        a = new double[n][n];
        b = new double[n];
        System.err.println("Введите коэффициенты");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Введите В");
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println("Введите эпсилон");
        epsilone = scanner.nextDouble();
    }

    public double getEpsilone() {
        return epsilone;
    }

    public double[][] getA() {
        return a;
    }

    public double[] getB() {
        return b;
    }

    public void setOutputs(double[] x, double[] meansures, int k) {
        this.x = x;
        this.meansures = meansures;
        this.k = k;
    }

    public void getOutput() {
        for (int i = 0; i < meansures.length; i++) {
            System.out.printf("Погрешность № %d  == %f\n", i + 1, meansures[i]);
        }

        for (double v : x) {
            System.out.println(v);
        }

        System.out.printf("Количество итераций -- %d", k);
    }
}



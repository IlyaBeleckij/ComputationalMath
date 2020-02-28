import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.ls.LSOutput;

import javax.imageio.ImageTranscoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

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
            System.out.println("Ошибка файла JSON");
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
            System.out.println("Ошибка файла JSON");
        }
        return b;
    }
}



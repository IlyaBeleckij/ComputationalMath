public class Integrator {

    private InputOutput io;
    private final double epsilon = 1e-9;
    private String[] functions;
    private String[] rectangleMethods;
    private int method;
    private Function function;
    private int rectangleMethod;
    private Data data;

    {
        rectangleMethods = new String[]{"Left", "Middle", "Right"};
        functions = new String[]{"y = x ^ 2", "y = ln(x)", "y = x / |x|"};
        function = new Function();
        io = new InputOutput();
    }

    public String[] getFunctions() {
        return functions;
    }

    public String[] getRectangleMethods() {
        return rectangleMethods;
    }

    public void integrate(Data data) throws Exception {
        if (data.getMethod() == 1) {
            io.outResults(integrateFirst(data.getLeftBound(), data.getRightBound(), data.getPrecision(), data.getRectangleMethod()));
        } else if (data.getMethod() == 2) {
            io.outResults(integrateSecond(data.getLeftBound(), data.getRightBound(), data.getPrecision(), data.getRectangleMethod()));
        } else if (data.getMethod() == 3)
            io.outResults(integrateThird(data.getLeftBound(), data.getRightBound(), data.getPrecision(), data.getRectangleMethod()));
    }
    public double[] integrateFirst(double leftBound, double rightBound, double precision, int method) throws Exception {
        double prevSum = 0;
        double sum = 0;
        double accuracy = 0;
        long n;
        for (n = 1; n < 10000000; n *= 2) {
            double h = (rightBound - leftBound) / n;
            sum = 0;
            if (method == 1) {
                for (int i = 0; i < n; i++) {
                    double testValue = function.calculateFirst(leftBound + i * h);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateFirst(leftBound + i * h + epsilon);
                    } else sum += testValue;
                }
            }
            else if (method == 2) {
                for (int i = 1; i <= n; i++) {
                    double testValue = function.calculateFirst(leftBound + i * h - h / 2);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateFirst(leftBound + i * h - h / 2 + epsilon);
                    } else sum += testValue;
                }
            }
            else {
                for (int i = 0; i <= n; i++) {
                    double testValue = function.calculateFirst(leftBound + i * h);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateFirst(leftBound + i * h + epsilon);
                    } else sum += testValue;
                }
            }
            sum *= h;
            if (Double.isNaN(sum) || Double.isInfinite(sum)) {
                throw new Exception("Интеграл нельзя посчитать");
            }
            accuracy = Math.abs(sum - prevSum) / 3;
            prevSum = sum;
            if (accuracy <= precision)
                break;
            if (n == 1)
                continue;
            if (n * 2 >= 1000000) {
                throw new Exception("Интеграл нельзя посчитать");
            }
        }
        if (Double.isNaN(sum) || Double.isInfinite(sum)) {
            throw new Exception("Интеграл нельзя посчитать");
        }
        System.out.println(sum + " " + n + " " + accuracy);
        return new double[]{sum, n, accuracy};
    }

    public double[] integrateSecond(double leftBound, double rightBound, double precision, int method) throws Exception {
        double prevSum = 0;
        double sum = 0;
        double accuracy = 0;
        long n;
        for (n = 1; n < 10000000; n *= 2) {
            double h = (rightBound - leftBound) / n;
            sum = 0;
            if (method == 1) {
                for (int i = 0; i < n; i++) {
                    double testValue = function.calculateSecond(leftBound + i * h);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateSecond(leftBound + i * h + epsilon);
                    } else sum += testValue;
                }
            }
            else if (method == 2) {
                for (int i = 1; i <= n; i++) {
                    double testValue = function.calculateSecond(leftBound + i * h - h / 2);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateSecond(leftBound + i * h - h / 2 + epsilon);
                    } else sum += testValue;
                }
            }
            else {
                for (int i = 0; i <= n; i++) {
                    double testValue = function.calculateSecond(leftBound + i * h);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateSecond(leftBound + i * h + epsilon);
                    } else sum += testValue;
                }
            }
            sum *= h;
            if (Double.isNaN(sum) || Double.isInfinite(sum)) {
                throw new Exception("Интеграл нельзя посчитать");
            }
            accuracy = Math.abs(sum - prevSum) / 3;
            prevSum = sum;
            if (accuracy <= precision)
                break;
            if (n == 1)
                continue;
            if (n * 2 >= 1000000) {
                throw new Exception("Интеграл нельзя посчитать");
            }
        }
        if (Double.isNaN(sum) || Double.isInfinite(sum)) {
            throw new Exception("Интеграл нельзя посчитать");
        }
        return new double[]{sum, n, accuracy};
    }

    public double[] integrateThird(double leftBound, double rightBound, double precision, int method) throws Exception {
        double prevSum = 0;
        double sum = 0;
        double accuracy = 0;
        long n;
        for (n = 1; n < 10000000; n *= 2) {
            double h = (rightBound - leftBound) / n;
            sum = 0;
            if (method == 1) {
                for (int i = 0; i < n; i++) {
                    double testValue = function.calculateThird(leftBound + i * h);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateThird(leftBound + i * h + epsilon);
                    } else sum += testValue;
                }
            }
            else if (method == 2) {
                for (int i = 1; i <= n; i++) {
                    double testValue = function.calculateThird(leftBound + i * h - h / 2);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateThird(leftBound + i * h - h / 2 + epsilon);
                    } else sum += testValue;
                }
            }
            else {
                for (int i = 0; i <= n; i++) {
                    double testValue = function.calculateThird(leftBound + i * h);
                    if (Double.isNaN(testValue) || Double.isInfinite(testValue)) {
                        sum += function.calculateThird(leftBound + i * h + epsilon);
                    } else sum += testValue;
                }
            }
            sum *= h;
            if (Double.isNaN(sum) || Double.isInfinite(sum)) {
                throw new Exception("Интеграл нельзя посчитать");
            }
            accuracy = Math.abs(sum - prevSum) / 3;
            prevSum = sum;
            if (accuracy <= precision)
                break;
            if (n == 1)
                continue;
            if (n * 2 >= 1000000) {
                throw new Exception("Интеграл нельзя посчитать");
            }
        }
        if (Double.isNaN(sum) || Double.isInfinite(sum)) {
            throw new Exception("Интеграл нельзя посчитать");
        }
        return new double[]{sum, n, accuracy};
    }
}


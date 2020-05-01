public class Data {
    private double leftBound;
    private int rectangleMethod;
    private double rightBound;
    private double precision;
    private int method;

    public double getLeftBound() {
        return leftBound;
    }

    public void setLeftBound(double leftBound) {
        this.leftBound = leftBound;
    }

    public int getRectangleMethod() {
        return rectangleMethod;
    }

    public void setRectangleMethod(int rectangleMethod) {
        this.rectangleMethod = rectangleMethod;
    }

    public double getRightBound() {
        return rightBound;
    }

    public void setRightBound(double rightBound) {
        this.rightBound = rightBound;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public Data(double leftBound, int rectangleMethod, double rightBound, double precision, int method) {
        this.leftBound = leftBound;
        this.rectangleMethod = rectangleMethod;
        this.rightBound = rightBound;
        this.precision = precision;
        this.method = method;
    }
}

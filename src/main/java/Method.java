public enum Method {
    leftRectangle("метод левых треугольников"),
    rightRectangle("метод правых треугольников"),
    middleRectangle("метод средних треугольников"),
    simpson("метод Симпсона"),
    trapezoid("метод трапеций");

    private final String name;
    Method(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}

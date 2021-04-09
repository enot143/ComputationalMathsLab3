public enum Method {
    leftRectangle("метод левых прямоугольников"),
    rightRectangle("метод правых прямоугольников"),
    middleRectangle("метод средних прямоугольников"),
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

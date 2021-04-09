import java.io.IOException;
import java.text.DecimalFormat;

public class Integral {
    Function function;
    Method method;
    double a;
    double b;
    double eps;
    Double result = null, I_0 = null;
    double n = 4;
    double h, sum, x_i;

    public Integral(Function function, Method method, double a, double b, double eps) {
        this.function = function;
        this.method = method;
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    public void start() throws IOException, InputException {
        if (function == Function.SECOND){
            a = a + eps;
            b = b - eps;
        }
        if (function == Function.THIRD){
            if (Math.abs(a) == Math.abs(b)){
                a = 0.1;
            }
            else{
                throw new InputException("Интервал должен быть симметричным");
            }
        }
        do {
            I_0 = result;

            switch (method) {
                case trapezoid:
                    methodTrapezoid();
                    break;
                case simpson:
                    methodSimpson();
                    break;
                case middleRectangle:
                    methodMiddle();
                    break;
                case rightRectangle:
                    methodRight();
                    break;
                case leftRectangle:
                    methodLeft();
                    break;
            }
            n *= 2;
            if (n > 10000000){
                System.out.println(n);
                throw new IOException("Нельзя найти ответ.");
            }
        } while (getAccuracy() );
    }

    public boolean getAccuracy(){
        if (I_0 != null){
            return !(Math.abs(result - I_0) <= eps);
        }
        return true;
    }

    /*
    Метод левых прямоугольников
     */
    public void methodLeft() {
        h = (b - a) / n;
        x_i = a;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += function.f(x_i);
            x_i += h;
        }
        result = sum * h;

    }

    /*
    Метод правых треугольников
     */
    public void methodRight() {
        h = (b - a) / n;
        x_i = a;
        sum = 0;
        for (int i = 0; i < n; i++) {
            x_i += h;
            sum += function.f(x_i);

        }
        result = sum * h;

    }

    /*
    Метод средних треугольников
     */
    public void methodMiddle() {
        h = (b - a) / n;
        sum = 0;
        x_i = a;
        x_i += h / 2;
        sum += function.f(x_i);
        for (int i = 0; i < n - 1; i++) {
            x_i += h;
            sum += function.f(x_i);
        }
        result = sum * h;
    }

    /*
    Метод Симпсона
     */
    public void methodSimpson() {
        x_i = a;
        sum = function.f(a);
        h = (b - a) / n;
        //TODO: проверить! проблема с выводом n - делим на 4?
        for (int i = 1; i < n; i++) {
            x_i += h;
            if (i % 2 == 0) {
                sum += 2 * function.f(x_i);
            } else sum += 4 * function.f(x_i);
        }
        sum += function.f(b);
        result = sum * h / 3.0;
    }

    /*
    Метод трапеций
     */
    public void methodTrapezoid() {
        x_i = a;
        sum = (function.f(a) + function.f(b)) / 2;
        h = (b - a) / n;
        for (int i = 1; i < n; i++) {
            x_i += h;
            sum += function.f(x_i);
        }
        result = sum * h;
    }


    public void getResult() {
        if (function == Function.THIRD){
            result = result*2;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String resultX = decimalFormat.format(result);
        System.out.println("Ответ : " + resultX);
        System.out.println("Число разбиения интервала интегрирования : " + n/2);
    }
}

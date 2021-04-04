import java.io.*;

public class Input {

    public Input() throws IOException {
        getFromKeyboard();
    }

    private Integral integral;
    private Function function;//функция
    private Method method;  //метод
    private Double a;       //нижний предел интегрирования
    private Double b;      //верхний предел интегрирования
    private Double eps;     //точность
    private final BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));


    public void getFromKeyboard() {
        validate("Выберите функцию: ");
        validate("Выберите метод: ");
        validate("Введите нижний предел интегрирования: ");
        validate("Введите верхний предел интегрирования: ");
        validate("Введите точность: ");
        integral = new Integral(function, method, a, b, eps);
    }


    public void validate(String s) {
        boolean correctInput = false;
        while (!correctInput) {
            try {
                correctInput = true;
                System.out.print(s);
                switch (s) {
                    case ("Выберите функцию: "):
                        inputFunction();
                        break;
                    case ("Выберите метод: "):
                        inputMethod();
                        break;
                    case ("Введите нижний предел интегрирования: "):
                        inputA();
                        break;
                    case ("Введите верхний предел интегрирования: "):
                        inputB();
                        break;
                    case ("Введите точность: "):
                        inputEps();
                        break;
                }
            } catch (Exception e) {
                correctInput = false;
                System.out.println("Ввод некорректен. Попробуйте еще раз.");
            }
        }
    }

    private void inputEps() throws IOException {
        eps = Double.parseDouble(keyboardReader.readLine());
        if (eps.toString().trim().equals("")) throw new IOException();
    }

    private void inputA() throws IOException {
        a = Double.parseDouble(keyboardReader.readLine());
        if (a.toString().trim().equals("")) throw new IOException();
    }

    private void inputB() throws IOException {
        b = Double.parseDouble(keyboardReader.readLine());
        if (b.toString().trim().equals("")) throw new IOException();
    }

    private void inputMethod() throws IOException {
        System.out.println("Введите число от 1 до 5:");
        System.out.println("1: " + Method.leftRectangle.toString());
        System.out.println("2: " + Method.rightRectangle.toString());
        System.out.println("3: " + Method.middleRectangle.toString());
        System.out.println("4: " + Method.simpson.toString());
        System.out.println("5: " + Method.trapezoid.toString());
        int a = Integer.parseInt(keyboardReader.readLine());
        switch (a) {
            case 1:
                method = Method.leftRectangle;
                break;
            case 2:
                method = Method.rightRectangle;
                break;
            case 3:
                method = Method.middleRectangle;
                break;
            case 4:
                method = Method.simpson;
                break;
            case 5:
                method = Method.trapezoid;
                break;
            default:
                throw new IOException();
        }
    }

    private void inputFunction() throws IOException {
        System.out.println("Введите число от 1 до 3.");
        System.out.println("1: " + Function.FIRST.toString());
        System.out.println("2 : " + Function.SECOND.toString());
        System.out.println("3 : " + Function.THIRD.toString());
        int a = Integer.parseInt(keyboardReader.readLine());
        switch (a) {
            case 1:
                function = Function.FIRST;
                break;
            case 2:
                function = Function.SECOND;
                break;
            case 3:
                function = Function.THIRD;
                break;
            default:
                throw new IOException();
        }
    }

    public Integral getIntegral() {
        return integral;
    }
}
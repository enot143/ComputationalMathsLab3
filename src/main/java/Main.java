import java.io.IOException;

public class Main {
    public static void main(String[] arg) throws IOException {
        Input input = new Input();
        Integral integral = input.getIntegral();
        integral.start();
        integral.getResult();
    }
}

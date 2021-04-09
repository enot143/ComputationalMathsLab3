import static java.lang.Math.*;
import static java.lang.Math.exp;

public enum Function {
        FIRST {      //y = 2𝑥3−5𝑥2-3𝑥+21
            public double f(double x) {
                return 2 * pow(x, 3) - 5 * pow(x, 2) - 3 * x + 21;
            }
            @Override
            public String toString() {
                return "y = 2\uD835\uDC65³−5\uD835\uDC65²-3\uD835\uDC65+21";
            }
        },
        SECOND {    //y = cos x
            public double f(double x) {
                return sin(x) / x;
            }
            @Override
            public String toString() {
                return "y = sin x / x";
            }
        },
        THIRD { //e^x - 2
            public double f(double x) {
                return 1/x;
            }

            @Override
            public String toString() {
                return "y = 1/x";
            }
        };
        public abstract double f(double x);
}

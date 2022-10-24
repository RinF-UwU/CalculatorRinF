package rinf.calculatorrinf.client;

public class CalculatorOperation {
    public static float x = 0, y = 0, result =0;
    public static byte nOp = 0;

    public static void calculatorOperation() {
        if(nOp == 1) {
            result = x + y;
        } else if(nOp == 2) {
            result = x - y;
        } else if(nOp == 3) {
            result = x * y;
        } else if(nOp == 4) {
            result = x / y;
        }
    }
}

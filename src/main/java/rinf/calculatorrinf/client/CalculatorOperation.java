package rinf.calculatorrinf.client;

public class CalculatorOperation {
    public static double x = 0, y = 0, result = 0;
    public static OperationType operationType = OperationType.NONE;

    public static void calculatorOperation() {
        if(operationType == OperationType.PLUS) {
            result = x + y;
        } else if(operationType == OperationType.MINUS) {
            result = x - y;
        } else if(operationType == OperationType.MULTIPLY) {
            result = x * y;
        } else if(operationType == OperationType.DIVISION) {
            result = x / y;
        } else result = y;
    }

    public enum OperationType {
        NONE,
        PLUS,
        MINUS,
        MULTIPLY,
        DIVISION
    }
}

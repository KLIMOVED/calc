class Calculation {
    public static int calculate(int num1, int num2, String operation) throws IllegalArgumentException {
        int result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("//т.к. введен оператор не удовлетворяющий заданию (+, -, /, *)");
        }
        return result;
    }
}

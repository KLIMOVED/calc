class Calculation {
    public static int calculate(int num1, int num2, char operation) throws IllegalArgumentException {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("//т.к введен оператор не удовлетворяющий заданию (+, -, /, *)");
        }
        return result;
    }
}

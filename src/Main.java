import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Input:");
        String expression = console.nextLine();
        System.out.println("Output:");
        try {
        System.out.println(calc(expression));
        } catch (IllegalArgumentException e) {
            System.out.println("throws Exception " + e.getMessage());
        }
        console.close();
    }

    public static String calc(String input) throws IllegalArgumentException {

        int num1;
        int num2;
        int res;
        String result;

        String[] symbols = input.split(" ");
        if (symbols.length > 3) {
            throw new IllegalArgumentException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (symbols.length < 3) {
            throw new IllegalArgumentException("//т.к. строка не является математической операцией");
        }

        num1 = Comparison.romanNumeral(symbols[0]);
        num2 = Comparison.romanNumeral(symbols[2]);
        if ((num1 == 0 && num2 != 0) || (num1 != 0 && num2 == 0)) {
            throw new IllegalArgumentException("//т.к. используются одновременно разные системы счисления");
        }

        String operation = symbols[1];
        if (num1 == 0) {
            try {
                num1 = Integer.parseInt(symbols[0]);
                num2 = Integer.parseInt(symbols[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("//т.к. калькулятор умеет работать только с целыми числами");
            }
            if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1) {
                throw new IllegalArgumentException("//т.к. калькулятор умеет работать только с арабскими или римскими цифрами от 1 до 10 одновременно");
            }
            result = Integer.toString(Calculation.calculate(num1, num2, operation));
        } else {
            res = Calculation.calculate(num1, num2, operation);
            if (res < 0) {
                throw new IllegalArgumentException("//т.к. в римской системе нет отрицательных чисел");
            }
            result = Convertation.convertNumberToRoman(res);
        }
        return result;
    }
}

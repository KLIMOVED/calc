import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Input:");
        String expression = console.nextLine();
        System.out.println("Output:");
        System.out.println(calc(expression));
    }

    public static String calc(String input) throws Exception {
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        String result = null;
        String[] symbols = input.split(" ");
        if (symbols.length > 3) {
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (symbols.length < 3) {
            throw new Exception("//т.к. строка не является математической операцией");
        }
        num1 = romanNumeral(symbols[0]);
        num2 = romanNumeral(symbols[2]);
        if ((num1 == 0 && num2 != 0) || (num1 != 0 && num2 == 0)) {
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        }
        String cha = symbols[1];
        char[] x = cha.toCharArray();
        char operation = x[0];
        if (num1 == 0 || num2 == 0) {
            try {
                num1 = Integer.parseInt(symbols[0]);
                num2 = Integer.parseInt(symbols[2]);
                if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1) {
                    throw new Exception("Калькулятор умеет работать только с арабскими или римскими цифрами от 1 до 10 одновременно!");
                }
                result = Integer.toString(calculate(num1, num2, operation));
            } catch (NumberFormatException e) {
                throw new Exception("Калькулятор умеет работать только с арабскими или римскими цифрами от 1 до 10 одновременно!");
            }
        } else {
            try {
                res = calculate(num1, num2, operation);
                result = romanSolution(res);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new Exception("//т.к. в римской системе нет отрицательных чисел");

            }

        }
        return result;
    }

    public static int calculate(int x1, int x2, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }

    public static int romanNumeral(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

    public static String romanSolution(int arabNumeral) {
        String[] romanNumberAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "*****", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String w = romanNumberAll[arabNumeral];
        return w;
    }
}

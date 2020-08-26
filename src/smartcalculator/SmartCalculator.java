package smartcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String input1;
        String input2;
        String[] snumbers;
        double[] numbers;
        ArrayList<Character> symbols;
        double total;

        do {
            System.out.println("Insert your expression:");
            input = scanner.nextLine();
            if (input.matches("\\s*/exit\\s*")) {
                System.out.println("Bye!");
                break;
            } else if (input.matches("\\s*/help\\s*")) {
                System.out.println("The program calculates the sum of numbers");
                continue;
            } else {
                try {
                input1 = trimAndCut(input);
                input2 = replaceConsecutive(input1);
                //System.out.println(input2);
                // snumbers --> String array of numbers
                snumbers = input2.split("\\+|\\-");

                numbers = getNumbers(snumbers);

                symbols = getSymbols(input2);

                total = calculateTotal(numbers, symbols);
                System.out.println("total = " + total);
                } catch (Exception e) {
                    System.out.println("Please insert expression or /help, /exit");
                }
            }

        } while (true);

    }

    private static String trimAndCut(String input) {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(input.trim());
        return matcher.replaceAll("");
    }

    private static String replaceConsecutive(String input) {
        String s1, s2, s3;
            //Replace even comsecutive minuses and consecutive + with a +
            s1 = matchReplaceAll("((\\-\\-)+)|(\\++)", "+", input);
            //Dealing with consecutive +
            s2 = matchReplaceAll("\\++", "+", s1);
            // We end up with "+-" which need to be replaced by minuses// 
            s3 = matchReplaceAll("(\\+\\-)|(\\-\\+)", "-", s2);
            //System.out.println("inside "+s3);
        if(s3.contains("++") || s3.contains("--") || s3.contains("+-") || s3.contains("-+")){
            return replaceConsecutive(s3);
        }else{
            return s3;
        }

        
    }

    private static String matchReplaceAll(String regex, String replace, String s) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll(replace);
    }

    private static double[] getNumbers(String[] input) {

        double[] numbers = new double[input.length];
        for (int i = 0; i < input.length; i++) {

            // in case the expression starts with a + or -
            if (input[i].equals("")) {
                input[i] = "0";
            }
            numbers[i] = Double.parseDouble(input[i]);
        }

        return numbers;
    }

    private static ArrayList<Character> getSymbols(String input) {
        char[] characters = input.toCharArray();
        ArrayList<Character> symbols = new ArrayList<>();

        for (char c : characters) {
            if (c == '+' || c == '-') {
                symbols.add(c);
            }
        }

        return symbols;
    }

    private static double calculateTotal(double[] numbers, ArrayList<Character> symbols) {
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i) == '-') {
                numbers[i + 1] = -numbers[i + 1];
            }
        }

        double total = 0;
        for (double n : numbers) {
            total += n;
        }
        return total;
    }
}

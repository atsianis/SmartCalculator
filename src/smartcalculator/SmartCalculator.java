package smartcalculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        String input1 = trimAndCut(input);
        String input2 = replaceConsecutive(input1);
        System.out.println(input2);
        
        
        
        

    }
    
    private static String trimAndCut(String input){
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(input.trim());
        return matcher.replaceAll("");
    }

    private static String replaceConsecutive(String input) {
        //Replace even comsecutive minuses with a +
        Pattern pattern = Pattern.compile("(\\-\\-)+");
        Matcher matcher = pattern.matcher(input);
        
        String s1 = matcher.replaceAll("+");
        
        // We end up with "+-" which need to be replaced by minuses
        pattern = Pattern.compile("\\+\\-");
        matcher = pattern.matcher(s1);
        
        String s2 = matcher.replaceAll("-");
        
        // Dealing with consecutive +
        pattern = Pattern.compile("\\++");
        matcher = pattern.matcher(s2);
        
        return matcher.replaceAll("+");
    }
}


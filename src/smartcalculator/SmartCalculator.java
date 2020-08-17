
package smartcalculator;

import java.util.Arrays;
import java.util.Scanner;

public class SmartCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] arr;
        int c;
        int a,b;
        do{
            input = scanner.nextLine();
            arr = input.split(" ");
            if (arr.length == 2){
                try{
                    a = Integer.parseInt(arr[0]);
                    b = Integer.parseInt(arr[1]);
                    System.out.println(a+b);
                }catch(NumberFormatException nfe){
                    //nothing happens
                }
            }else if(arr.length == 1){
                if(input.equals("/exit")){
                    System.out.println("Bye!");
                    break;
                }else{
                    try{
                    a = Integer.parseInt(arr[0]);
                    System.out.println(a);
                }catch(NumberFormatException nfe){
                    //nothing happens
                }
                }
            }
        }while (!input.equals("/exit"));   
    }
    }
    


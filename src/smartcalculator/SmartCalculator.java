
package smartcalculator;

import java.util.Arrays;
import java.util.Scanner;

public class SmartCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] arr;
        int a,b;
        do{
            input = scanner.nextLine();
            arr = input.split(" ");
            
            // checking for keywords or case of single input
            if(arr.length == 1){
                if(input.equals("/exit")){
                    System.out.println("Bye!");
                    break;
                }else if(input.equals("/help")){
                    System.out.println("The program calculates the sum of numbers");
                }else{
                    try{
                    a = Integer.parseInt(arr[0]);
                    System.out.println(a);
                }catch(NumberFormatException nfe){
                    //nothing happens for now if there are string inputs
                }
                }
            }else{
                int[] numbers = new int[arr.length];//create an array in which we're going to put the string parsed to integers
                boolean allok = true;
                for (int i = 0; i<arr.length; i++ ){
                    try{
                        numbers[i] = Integer.parseInt(arr[i]);
                    }catch(NumberFormatException nfe){
                        allok = false;
                        //nothing happens for now if there are string inputs
                    }
                }
                
                if (allok==true){
                    int sum=0;
                    for(int number:numbers){
                        sum+=number;
                    }
                    System.out.println(sum);
                }
            }
        }while (!input.equals("/exit"));  
        
        scanner.close(); 
    }
    }
    


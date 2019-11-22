/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    { 
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter your fraction problem: "); 
    	String input = s.nextLine();
    	while(!input.equalsIgnoreCase("quit")) {
    		System.out.println(produceAnswer(input));
    		System.out.println("Enter your fraction problem: ");
    		input = s.nextLine();
    	}

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){
        // TODO: Implement this function to produce the solution to the input
    	String firstOp =
    	input.substring(0,input.indexOf(' '));
    	String secondOp = 
    	input.substring(input.indexOf(' ') + 3, input.length());
    	String operator = input.substring(input.indexOf(' ') + 1,input.indexOf(' ') + 2);
    	
    	
    	String op2Whole = findWhole(secondOp); 
    	String op2Num = findNum(secondOp); 
    	String op2Deno = findDeno(secondOp); 
    	
    	String theAnswer = "whole:" + op2Whole + " numerator:" + op2Num + " denominator:" + op2Deno;
    	
    	return theAnswer; 
    	
  }

  // TODO: Fill in the space below with any helper methods that you think you will need
    public static String findWhole(String str) {
    	if (str.contains("_")) {
    		return str.substring(0, str.indexOf('_'));
    	}
    	if (str.contains("/")) {
    		return "0"; 
    	}
    	else return str;
    }
    public static String findNum(String str) {
    	if (str.contains("_")) {
    		return str.substring(str.indexOf('_') + 1, str.indexOf('/'));
    	}
    	else if(str.contains("/")) {
    		return str.substring(0, str.indexOf('/'));
    	}
    	else {
    		return "0";  
    	}
    }
    public static String findDeno(String str) {
    	if(str.contains("/")) {
    		return str.substring(str.indexOf("/") + 1);
    	}
    	else {
    		return "1"; 
    	}
    }
}

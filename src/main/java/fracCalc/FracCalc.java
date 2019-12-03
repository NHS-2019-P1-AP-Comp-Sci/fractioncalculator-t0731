/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	 public static void main(String[] args) 
	    { 
	        // TODO: Read the input from the user and call produceAnswer with an equation
	    	Scanner s = new Scanner(System.in);
	    	System.out.print("Enter your fraction problem or quit: "); 
	    	String input = s.nextLine();
	    	while(!input.equalsIgnoreCase("quit")) {
	    		System.out.println(produceAnswer(input));
	    		System.out.println("Enter your fraction problem or quit: ");
	    		input = s.nextLine();
	    	}

	    }

	
	public static String produceAnswer(String input) {
		
		int lhsDelimiterIndex = input.indexOf(" ");
		String lhs = input.substring(0, lhsDelimiterIndex);

	
		int rhsDelimiterIndex = input.indexOf(" ", lhsDelimiterIndex + 2);
		String rhs = input.substring(rhsDelimiterIndex + 1, input.length());

		
		String operator = input.substring(lhsDelimiterIndex + 1, rhsDelimiterIndex);

		int lhsWholeNum = wholeNum(lhs);
		int lhsNum = numerator(lhs);
		int lhsDeno = denominator(lhs);

		int rhsWholeNum = wholeNum(rhs);
		int rhsNum = numerator(rhs);
		int rhsDeno = denominator(rhs);

	
		int lhsImproperNum = lhsNum + convertToImpropernumerator(lhsWholeNum, lhsDeno);
		int rhsImproperNum = rhsNum + convertToImpropernumerator(rhsWholeNum, rhsDeno);

		
		lhsNum = lhsImproperNum * rhsDeno;
		rhsNum = rhsImproperNum* lhsDeno;

		lhsDeno = lhsDeno * rhsDeno;
		rhsDeno = lhsDeno;

		
		int numeratorCalculationResult;

		if (operator.equals("/")) {
			if (rhsNum < 0) {
				rhsDeno = Math.abs(rhsNum);
				rhsNum = -1 * lhsDeno;
			} else {
				rhsDeno = rhsNum;
				rhsNum = lhsDeno;
			}
			numeratorCalculationResult = lhsNum * rhsNum;

		} else if (operator.equals("*")) {
			if (rhsNum == 0 || lhsNum== 0)
				numeratorCalculationResult = 0;
			else
				numeratorCalculationResult = lhsNum * rhsNum;
		} else if (operator.equals("+")) {
			numeratorCalculationResult = lhsNum + rhsNum;
		} else if (operator.equals("-")) {
			numeratorCalculationResult = lhsNum - rhsNum;
		} else {
			numeratorCalculationResult = 0;
		}

		if (numeratorCalculationResult == 0) {
			return "0";
		}

		
		int resultDenominator;
		int resultWholeNum;
		int resultNumerator;

		if (operator.equals("/") || operator.equals("*")) {
			resultDenominator = lhsDeno * rhsDeno;
		} else {
			resultDenominator = lhsDeno;
		}

		resultWholeNum = (numeratorCalculationResult / resultDenominator);
		resultNumerator = numeratorCalculationResult - (resultWholeNum * resultDenominator);

		
		
		String output = "";

		
		if (resultWholeNum != 0) {
			output += resultWholeNum;
		}

		if (resultWholeNum != 0 && resultNumerator != 0) {
			output += "_";
		}

		if (resultNumerator != 0) {
			if ((resultWholeNum < 0)
					|| ((lhsWholeNum < 0 || lhsNum < 0) && (rhsWholeNum < 0 || rhsNum < 0))) {
				resultNumerator = Math.abs(resultNumerator);
			}
			output += resultNumerator + "/" + resultDenominator;
		}

		return output;
	}

	
	public static int convertToImpropernumerator(int wholeNumber, int denominator) {
		return wholeNumber * denominator;
	}

	
	public static int wholeNum(String s) {
		if (!s.contains("/")) {
			return Integer.parseInt(s);
		} else if (s.contains("_")) {
			return Integer.parseInt(s.substring(0, s.indexOf('_')));
		} else {
			return 0;
		}
	}

	
	public static int numerator(String s) {
		if (s.contains("/")) {
			int startIndex = 0;
			int endIndex = s.indexOf("/");

			if (s.contains("_")) {
				startIndex = s.indexOf("_") + 1;
			}

			int number = Integer.parseInt(s.substring(startIndex, endIndex));

			
			if (s.contains("_") && s.contains("-")) {
				return -number;
			}

			return number;

		} else {
			return 0;
		}
	}

	
	public static int denominator(String s) {
		if (s.contains("/")) {
			int startIndex = s.indexOf("/") + 1;
			int endIndex = s.length();

			int number = Integer.parseInt(s.substring(startIndex, endIndex));

			return number;
		} else {
			return 1;
		}
	}

	
}

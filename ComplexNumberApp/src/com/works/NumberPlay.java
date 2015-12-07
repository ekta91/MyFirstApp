package com.works;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberPlay {

	private static Scanner inputReader;

	private static String QUIT = "Q";
	private static String CLEAR = "C";

	public static void main(String[] args) {

		getUserInput();

	}

	private static void getUserInput() {
		inputReader = new Scanner(System.in);

		Boolean calc_running = false;

		while (!calc_running) {
			String[] inputArray = new String[3];

			System.out.println("Enter first number::");

			String firstOperand = inputReader.nextLine();

			ArrayList<ComplexParts> complexList = new ArrayList<ComplexParts>();

			complexList.add(getComplexParts(firstOperand));

			if (QUIT.equalsIgnoreCase(firstOperand)) {
				System.exit(0);
			} else if (CLEAR.equalsIgnoreCase(firstOperand)) {
				// try {
				// Runtime.getRuntime().exec("cls");
				System.out.println("STACK CLEARED");
				break;
				// } catch (IOException e) {
				// e.printStackTrace();
				// }
			} else {

				inputArray[0] = firstOperand;
			}

			System.out.println("Enter operator::");

			String operator = inputReader.nextLine();

			if (QUIT.equalsIgnoreCase(operator)) {
				System.exit(0);
			} else if (CLEAR.equalsIgnoreCase(operator)) {
				// try {
				// Runtime.getRuntime().exec("cls");
				System.out.println("STACK CLEARED");
				break;
				// } catch (IOException e) {
				// e.printStackTrace();
				// }
			} else {

				inputArray[1] = operator;
			}

			if (!operator.equals("sqrt")) {

				System.out.println("Enter Second number::");

				String secondOperand = inputReader.nextLine();

				complexList.add(getComplexParts(secondOperand));

				if (QUIT.equalsIgnoreCase(secondOperand)) {
					System.exit(0);
				} else if (CLEAR.equalsIgnoreCase(secondOperand)) {
					// try {
					// Runtime.getRuntime().exec("cls");
					System.out.println("STACK CLEARED");
					break;
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
				} else {

					inputArray[2] = secondOperand;
				}

				System.out.println("First Number is :: " + firstOperand
						+ "Operator is :: " + operator
						+ " and second Number enetered is :: " + secondOperand);

			} else {
				System.out.println("First Number is :: " + firstOperand
						+ "Operator is :: " + operator);
			}

			String finalResult = getResult(complexList, operator);

			System.out.println("Result is :: " + finalResult);

		}

		getUserInput();

	}

	private static String getResult(ArrayList<ComplexParts> complexList,String operator) {
		String resultFinal = null;

		CalculationLocal calc = new CalculationImpl();

		switch (operator) {
		case "+":
			resultFinal = calc.addition(complexList);
			break;

		case "-":
			resultFinal = calc.subtraction(complexList);
			break;

		case "*":
			resultFinal = calc.multiplication(complexList);
			break;

		case "/":
			resultFinal = calc.division(complexList);
			break;

		case "sqrt":
			resultFinal = calc.sqrt(complexList);
			break;

		}

		return resultFinal;

	}

	public static ComplexParts getComplexParts(String operand) {
		String delimeter = " ";
		String[] strTokenArray = operand.split(delimeter);

		ComplexParts parts = new ComplexParts();

		if (strTokenArray.length > 0) {

			for (int j = 0; j < strTokenArray.length; j++) {
				if (strTokenArray[j].contains("i")) {
					parts.setImaginary(strTokenArray[j]);
				} else if ((strTokenArray[j].length() == 1 && strTokenArray[j]
						.contains("+") ) || (strTokenArray[j].length() == 1 && strTokenArray[j]
								.contains("-"))) {
					parts.setOperator(strTokenArray[j]);
				}

				else if (!strTokenArray[j].contains("i")) {
					parts.setReal(strTokenArray[j]);
				}

			}

		}

		System.out.println("Real part is :: " + parts.getReal()
				+ " , imaginary part is :: " + parts.getImaginary()
				+ " and operator is :: " + parts.getOperator());
		return parts;
	}

}

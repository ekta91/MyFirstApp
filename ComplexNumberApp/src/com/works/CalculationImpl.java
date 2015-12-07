package com.works;

import java.util.ArrayList;

public class CalculationImpl implements CalculationLocal {

	@Override
	public String addition(ArrayList<ComplexParts> complexList) {

		String result = null;

		if (complexList.size() > 0) {

			ComplexParts firstComplex = complexList.get(0);

			String firstReal = firstComplex.getReal();
			String firstOperator = firstComplex.getOperator();
			String firstImg = firstComplex.getImaginary();

			ComplexParts secondComplex = complexList.get(1);

			String secondReal = secondComplex.getReal();
			String secondOperator = secondComplex.getOperator();
			String secondImg = secondComplex.getImaginary();

			double resultReal = 0.0;
			double resultImg = 0.0;
			
			if ("+".equals(firstOperator) && "+".equals(secondOperator)) 
			{
			 
			
				result = Double.toString(resultReal).concat(" + ").concat(Double.toString(resultImg).concat("i"));
				
				
			} 
			else if ("+".equals(firstOperator) && "-".equals(secondOperator)) 
			{
				result = Double.toString(resultReal).concat(" - ").concat(Double.toString(resultImg).concat("i"));
			
				
				

			} else if ("-".equals(firstOperator) && "+".equals(secondOperator)) 
			{
				result = Double.toString(resultReal).concat(" - ").concat(Double.toString(resultImg).concat("i"));
			

			} else if ("-".equals(firstOperator) && "-".equals(secondOperator)) 
			{
				result = Double.toString(resultReal).concat(" - ").concat(Double.toString(resultImg).concat("i"));
			}

		}

		return result;

	}

	@Override
	public String subtraction(ArrayList<ComplexParts> complexList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String multiplication(ArrayList<ComplexParts> complexList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String division(ArrayList<ComplexParts> complexList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sqrt(ArrayList<ComplexParts> complexList) {
		// TODO Auto-generated method stub
		return null;
	}

}

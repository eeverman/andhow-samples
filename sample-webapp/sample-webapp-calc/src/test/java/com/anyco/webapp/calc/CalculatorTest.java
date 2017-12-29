/*
 */
package com.anyco.webapp.calc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ericeverman
 */
public class CalculatorTest {
	
	public CalculatorTest() {
	}

	/**
	 * Test of doFooCalc method, of class Calculator.
	 */
	@Test
	public void testDoFooCalc() {
		Calculator calc = new Calculator();
		
		//should be 8 X 2 based on fixed value in CalcAndHowTestInit
		assertEquals(16d, calc.doFooCalc(2d), .000001d);
	}

	/**
	 * Test of doBarCalc method, of class Calculator.
	 */
	@Test
	public void testDoBarCalc() {
		Calculator calc = new Calculator();
		
		//should be .1 X 100 based on fixed value in CalcAndHowTestInit
		assertEquals(10d, calc.doBarCalc(100d), .000001d);
	}
	
}

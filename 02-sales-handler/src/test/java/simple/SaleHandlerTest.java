package simple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.api.AppFatalException;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import org.yarnandtail.andhow.junit5.RestoreSysPropsAfterThisTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * To keep the HelloWorld2 class as simple as possible, it just prints to Sys.out.
 * 
 * This isn't best practice - Don't worry there are lots of good test examples
 * in the other samples.
 */
@KillAndHowBeforeEachTest
public class SaleHandlerTest {
	
	@Test
	public void verySimpleDefaultTest() throws Exception {

		System.out.println("Begin 'SaleHandlerTest.verySimpleDefaultTest'");
		SaleHandler handler = new SaleHandler();

		BigDecimal tax = new BigDecimal(".11");	//This should be the configured value
		BigDecimal sale = new BigDecimal("10.00");
		BigDecimal expectedTotal = sale.add( sale.multiply(tax) );


		assertEquals(expectedTotal, handler.handle(new BigDecimal("10.00")));
	}

	
}

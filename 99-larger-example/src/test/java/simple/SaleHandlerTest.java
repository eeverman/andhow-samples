package simple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.junit5.*;

import java.math.BigDecimal;

public class SaleHandlerTest {
	
	@Test
	public void defaultConfigTaxRateShouldBe_11Percent() throws Exception {
		SaleHandler handler = new SaleHandler();

		// Total sale should be 10.00 + (10.00 * .11)
		assertEquals(new BigDecimal("11.10"), handler.handle(BigDecimal.TEN));
	}

	@Test @KillAndHowBeforeThisTest
	public void verifyTaxRateAt_12Percent() throws Exception {

		AndHow.findConfig().addFixedValue(
				SaleHandler.Config.TAX_RATE, new BigDecimal(".12"));

		SaleHandler handler = new SaleHandler();

		// Total sale should be 10.00 + (10.00 * .12)
		assertEquals(new BigDecimal("11.20"), handler.handle(BigDecimal.TEN));
	}

	
}

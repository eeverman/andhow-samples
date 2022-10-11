package simple;

import org.yarnandtail.andhow.property.BigDecProp;
import java.math.BigDecimal;

public class SaleHandler {

	// 1 Declare configuration Property's for this class
	public static interface Config {
		BigDecProp TAX_RATE = BigDecProp.builder().greaterThan(BigDecimal.ZERO)
				.notNull().desc("Tax rate as a decimal, eg .10").aliasIn("tax").build();
	}

	// Perhaps a lambda endpoint, service endpoint, etc.
	public Object handle(BigDecimal saleAmount) throws Exception {

		// TAX_RATE.getValue() returns a BigDecimal
		BigDecimal tax = saleAmount.multiply(Config.TAX_RATE.getValue());
		return new SaleDao().storeSale(saleAmount.add(tax));
	}
}
package com.anyco.webapp.calc;

import org.yarnandtail.andhow.AndHowConfiguration;
import org.yarnandtail.andhow.NonProductionConfig;
import org.yarnandtail.andhow.AndHowTestInit;
import com.anyco.webapp.calc.Calculator.CONFIG;
/**
 *
 * @author ericeverman
 */
public class CalcAndHowTestInit implements AndHowTestInit {

	//For testing, we just hardcode some calculation coefs.
	public AndHowConfiguration getConfiguration() {
		return NonProductionConfig.instance()
				.addFixedValue(CONFIG.FOO_COEF, 8d)
				.addFixedValue(CONFIG.BAR_COEF, .1D);
	}

}

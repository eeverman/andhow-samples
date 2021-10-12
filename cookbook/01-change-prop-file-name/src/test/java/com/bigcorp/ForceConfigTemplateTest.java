package com.bigcorp;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeThisTest;

public class ForceConfigTemplateTest {

	@Test
	@KillAndHowBeforeThisTest
	public void forceTemplateCreation() {
		AndHow.findConfig().addFixedValue(
				org.yarnandtail.andhow.Options.CREATE_SAMPLES, true);

		AndHow.instance();
	}
}

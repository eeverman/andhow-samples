package com.bigcorp;

import org.yarnandtail.andhow.*;

public class MyAndHowinit implements AndHowInit {
	@Override
	public AndHowConfiguration getConfiguration() {
		return AndHow.findConfig().setClasspathPropFilePath("/myapp.properties");
	}
}

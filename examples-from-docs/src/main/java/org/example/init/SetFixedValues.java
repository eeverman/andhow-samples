package org.example.init;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.property.StrProp;

/** This class will be found at runtime and used to initiate AndHow */
public class SetFixedValues implements AndHowInit {
	@Override public AndHowConfiguration getConfiguration() {
		return  StdConfig.instance()
				.addFixedValue(MY_PROP, "some value");
	}
	
	static final StrProp MY_PROP = StrProp.builder().build();
}

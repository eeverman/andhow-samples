package net.spacebase;

import org.yarnandtail.andhow.GroupInfo;
import org.yarnandtail.andhow.property.*;

/**
 *
 * @author ericeverman
 */
public class PrivatePlanet {

	private static interface CONFIG {
		@GroupInfo(name = "Your group config", desc = "description. . .")
		static interface YOUR_GROUP_HERE {
			StrProp IM_PRIVATE = StrProp.builder().defaultValue("TOP_SECRET").build();
		}
	}

	public String getSecret() {
		return CONFIG.YOUR_GROUP_HERE.IM_PRIVATE.getValue();
	}

}

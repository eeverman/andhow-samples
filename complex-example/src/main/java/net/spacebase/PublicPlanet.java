package net.spacebase;

import org.yarnandtail.andhow.GroupInfo;
import org.yarnandtail.andhow.property.*;

/**
 *
 * @author ericeverman
 */
public class PublicPlanet {

	static interface CONFIG {
		@GroupInfo(name = "Remote connection config", desc = "description. . .")
		static interface REMOTE {
			StrProp URL = StrProp.builder().mustEndWith("/").build();
			IntProp TIMEOUT = IntProp.builder().defaultValue(50).build();
		}
		@GroupInfo(name = "Cache config", desc = "description. . .")
		static interface CACHE {
			BolProp ENABLED = BolProp.builder().defaultValue(true).build();
			StrProp FILE = StrProp.builder().mustBeNonNull().build();
		}
		@GroupInfo(name = "Event broadcast config", desc = "description. . .")
		static interface BROADCAST {
			StrProp URL = StrProp.builder().mustEndWith("/").build();
			BolProp ENABLED = BolProp.builder().defaultValue(true).build();
		}
	}

	public String getRemoteUrl() {
		return CONFIG.REMOTE.URL.getValue();
	}

	public int getRemoteTimeout() {
		return CONFIG.REMOTE.TIMEOUT.getValue(); //-- Note the strong typing of the return value
	}
	
	public String getCacheFile() {
		return CONFIG.CACHE.FILE.getValue();
	}

	public boolean isCacheEnabled() {
		return CONFIG.CACHE.ENABLED.getValue();
	}

	public String getBroadcastUrl() {
		return CONFIG.BROADCAST.URL.getValue();
	}

	public boolean isBroadcastEvents() {
		return CONFIG.BROADCAST.ENABLED.getValue();
	}

}

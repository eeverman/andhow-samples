package org.example;

import org.yarnandtail.andhow.GroupInfo;
import org.yarnandtail.andhow.property.*;

public class TransactionManager {

	@GroupInfo(name="Connection Config", desc = "Config's an http service connection")
	interface Connection {
		StrProp BASE_URL = StrProp.builder().notNull()
			.aliasIn("url").startsWith("http://").endsWith("/")
			.desc("Base url for a service request").build();
		IntProp RETRY_CNT = IntProp.builder().defaultValue(1)
			.aliasIn("retry").aliasIn("retry_cnt")
			.greaterThanOrEqualTo(0).lessThan(10)
			.desc("# of request retries.  0 = no retry.").build();
	}

}

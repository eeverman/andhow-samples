package com.anyco.andhowsamplewebapp.auth;

import org.yarnandtail.andhow.GroupInfo;
import org.yarnandtail.andhow.property.IntProp;
import org.yarnandtail.andhow.property.StrProp;

@GroupInfo(name="Authentication Configuration", desc="Configures AD endpoints and related...")
public interface Config {
	StrProp AD_URL = StrProp.builder().mustStartWith("http").mustEndWith("/")
			.description("Base url to the Active Directory endpoint").build();
	
	IntProp AD_TIMEOUT = IntProp.builder().mustBeGreaterThan(5).mustBeNonNull()
			.description("How long to wait on AD before throwing an error").build();
}

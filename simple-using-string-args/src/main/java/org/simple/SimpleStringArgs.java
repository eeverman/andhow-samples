package org.simple;

import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.property.*;

@GroupInfo(name="Launch Config", desc="More details...")
public class SimpleStringArgs {
	
	final static IntProp COUNT_DOWN_START = IntProp.builder().mustBeNonNull()
			.desc("Start the countdown from this number")
			.mustBeGreaterThanOrEqualTo(1).build();
	
	private final static StrProp LAUNCH_CMD = StrProp.builder().mustBeNonNull()
			.desc("What to say when its time to launch")
			.mustMatchRegex(".*Go.*").build();
	
	private final static BolProp NOTIFY_NEWS = BolProp.builder().defaultValue(true)
			.desc("If true, post launch events to the AP news feed").build();
	
	public String launch() {
		String launch = "";
		
		for (int i = COUNT_DOWN_START.getValue(); i >= 1; i--) {
			launch = launch += i + "...";
		}
		
		return launch + LAUNCH_CMD.getValue();
	}
	
	public static void main(String[] args) {
		
		AndHow.findConfig()
				.setCmdLineArgs(args)
				.addFixedValue(NOTIFY_NEWS, false);
		
		SimpleStringArgs gs = new SimpleStringArgs();
		System.out.println(gs.launch());
	}
	
	public boolean isNewsNotified() { return NOTIFY_NEWS.getValue(); }
}
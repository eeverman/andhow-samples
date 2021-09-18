package simple;

import org.junit.jupiter.api.Test;
import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import org.yarnandtail.andhow.junit5.RestoreSysPropsAfterThisTest;
import simple.HelloWorld;

/**
 * Very simplistic test.
 * 
 * To keep the HelloWorld class as simple as possible, it just prints to Sys.out,
 * so there isn't an easy way to capture the output.  This test class shows
 * some simple ways to configure it, even though there are not any assertions.
 * 
 * This isn't best practice - Don't worry there are lots of good test examples
 * in the other samples.
 */
@KillAndHowBeforeEachTest
public class HelloWorldTest {
	
	@Test
	public void verySimpleDefaultTest() {

		System.out.println("Begin 'HelloWorldTest.verySimpleDefaultTest'");
		HelloWorld.main(null);	//Should print "Hello, Dave" twice
	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void readPropertyValuesFromSystemProperties() {

		//Set Property values via system properties
		System.setProperty("org.simple.HelloWorld.NAME", "Duke");
		System.setProperty("org.simple.HelloWorld.REPEAT_COUNT", "3");

		System.out.println("Begin 'HelloWorldTest.readPropertyValuesFromSystemProperties'");
		HelloWorld.main(null);	//Should print "Hello, Duke", 3 times

	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void readPropertyValuesFromPropertyFile() {

		//Find the AndHow configuration and tell it to use a 
		AndHow.findConfig().setClasspathPropFilePath("/helloworld.properties");

		System.out.println("Begin 'HelloWorldTest.readPropertyValuesFromPropertyFile'");
		HelloWorld.main(null);	//Should print "Hello, Kathy", 4 times

	}
	
}

package simple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.api.AppFatalException;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import org.yarnandtail.andhow.junit5.RestoreSysPropsAfterThisTest;
import simple.HelloWorld;

/**
 * To keep the HelloWorld2 class as simple as possible, it just prints to Sys.out.
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
		System.setProperty("simple.HelloWorld.Config.NAME", "Duke");
		System.setProperty("simple.HelloWorld.Config.REPEAT_COUNT", "3");

		System.out.println("Begin 'HelloWorldTest.readPropertyValuesFromSystemProperties'");
		HelloWorld.main(null);	//Should print "Hello, Duke", 3 times

	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void readPropertyValuesFromPropertyFile() {

		//Find the AndHow configuration and tell it to use a different config file
		AndHow.findConfig().setClasspathPropFilePath("/helloworld.properties");

		System.out.println("Begin 'HelloWorldTest.readPropertyValuesFromPropertyFile'");
		HelloWorld.main(null);	//Should print "Hello, Dawn", 4 times

	}

	@Test
	public void setInvalidNameValueThrowsAnError() {

		System.out.println("Begin 'HelloWorldTest.setInvalidNameValueThrowsAnError'");

		assertThrows(AppFatalException.class,
				() -> HelloWorld.main(new String[] {"simple.HelloWorld.Config.NAME=Bar"}));
	}

	@Test
	public void demonstrateCausingConfigTemplateToBeWritten() {

		System.out.println("Begin 'HelloWorldTest.demonstrateCausingConfigTemplateToBeWritten'");

		HelloWorld.main(new String[] {"AHForceCreateSamples"});
	}
	
}

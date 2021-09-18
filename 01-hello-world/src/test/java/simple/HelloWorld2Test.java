package simple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.yarnandtail.andhow.*;
import org.yarnandtail.andhow.api.AppFatalException;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;
import org.yarnandtail.andhow.junit5.RestoreSysPropsAfterThisTest;
import simple.HelloWorld2;

/**
 * To keep the HelloWorld2 class as simple as possible, it just prints to Sys.out.
 * 
 * This isn't best practice - Don't worry there are lots of good test examples
 * in the other samples.
 */
@KillAndHowBeforeEachTest
public class HelloWorld2Test {
	
	@Test
	public void verySimpleDefaultTest() {

		System.out.println("Begin 'HelloWorld2Test.verySimpleDefaultTest'");
		HelloWorld2.main(null);	//Should print "Hello, Dave" twice
	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void readPropertyValuesFromSystemProperties() {

		//Set Property values via system properties
		System.setProperty("simple.HelloWorld2.Config.NAME", "Duke");
		System.setProperty("simple.HelloWorld2.Config.REPEAT_COUNT", "3");

		System.out.println("Begin 'HelloWorld2Test.readPropertyValuesFromSystemProperties'");
		HelloWorld2.main(null);	//Should print "Hello, Duke", 3 times

	}
	
	@Test
	@RestoreSysPropsAfterThisTest //AndHow provided Junit extension to erase System.property changes
	public void readPropertyValuesFromPropertyFile() {

		//Find the AndHow configuration and tell it to use a 
		AndHow.findConfig().setClasspathPropFilePath("/helloworld2.properties");

		System.out.println("Begin 'HelloWorld2Test.readPropertyValuesFromPropertyFile'");
		HelloWorld2.main(null);	//Should print "Hello, Dawn", 4 times

	}

	@Test
	public void setInvalidNameValueThrowsAnError() {

		System.out.println("Begin 'HelloWorld2Test.setInvalidNameValueThrowsAnError'");

		assertThrows(AppFatalException.class,
				() -> HelloWorld2.main(new String[] {"simple.HelloWorld2.Config.NAME=Bar"}));
	}

	@Test
	public void demonstrateCausingConfigTemplateToBeWritten() {

		System.out.println("Begin 'HelloWorld2Test.demonstrateCausingConfigTemplateToBeWritten'");

		HelloWorld2.main(new String[] {"AHForceCreateSamples"});
	}
	
}

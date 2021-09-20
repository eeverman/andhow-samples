package simple;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.property.*;

/**
 * HelloWorld with validation and cmd line arguments
 * <hr>
 * <h3>Section //1 : Declare AndHow Properties</h3>
 * {@code Property} values can have validation.  At startup, AndHow <em>discovers and validates
 * all Properties in your entire application</em>, ensuring that a mis-configuration
 * application <em><a href="https://www.martinfowler.com/ieeeSoftware/failFast.pdf">fails fast</a></em>
 * at startup, rather than mysteriously failing later.
 * <p>
 * Placing {@code Property}'s in an interface is best practice for organization and visibility control.
 * Only code able to 'see' a {@code Property} can retrieve its value - standard Java visibility rules.
 * Fields in an interface are implicitly {@code static final}, saving a bit of typing.
 * <h3>Section //2 : Add command line arguments</h3>
 * AndHow loads Property values from several configuration sources in a
 * <a href="https://sites.google.com/view/andhow/user-guide/value-loaders">well established order</a>.
 * At startup, AndHow scans {@code System.Properties}, env. variables, JNDI values,
 * the {@code andhow.properties} file, etc., automatically.
 * <p>
 * Reading from commandline requires a bit of help from the application. This code:<br>
 * {@code AndHow.findConfig().setCmdLineArgs(args);}<br>
 * ...passes the command line arguments in to AndHow.
 * <p>
 * Calling {@code main()} from commandline to set {@code NAME} to 'Dar' would look like this:<br>
 * {@code  java -Dsimple.HelloWorld2.Config.NAME=Dar -cp [classpath] simple.HelloWorld2}<br>
 * <p>
 * Note the 'name' for NAME: Java canonical names are used to read Property values, ensuring name
 * uniqueness.
 */
public class HelloWorld2 {

	// 1 Declare
	private static interface Config {
		StrProp NAME = StrProp.builder().mustStartWith("D")
				.defaultValue("Dave").build();

		IntProp REPEAT_COUNT = IntProp.builder().mustBeLessThan(5)
				.defaultValue(2).build();
	}
	
	public static void main(String[] args) {
		
		// 2 Add command line arguments
		AndHow.findConfig().setCmdLineArgs(args);
			
		// 3 Use
		for (int i = 0; i < Config.REPEAT_COUNT.getValue(); i++) {
			System.out.println("Hello, " + Config.NAME.getValue());
		}
	}
}
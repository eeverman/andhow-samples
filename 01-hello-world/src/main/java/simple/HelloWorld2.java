package simple;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.property.*;

/**
 * HelloWorld with validation and values taken from
 * <hr>
 * <h3>Section //1 : Declare AndHow Properties</h3>
 * {@code Property} values can have validation.  At startup, <em>all Properties in your entire
 * application</em> are auto-discovered and validated, ensuring that a mis-configuration
 * application <em>fails fast</em> at startup, rather than mysteriously error-ing later.
 * <p>
 * Placing {@codeProperty}'s in an interface is a best practice for organization and visibility.
 * Only code able to 'see' the {@code Property} instances can retrieve the values - standard
 * Java visibility rules.  Fields declared in an interface are implicitly {@code static final},
 * saving a bit of typing.
 * <h3>Section //2 : Add command line arguments</h3>
 * AndHow loads Property values from several configuration sources in a
 * <a href="https://sites.google.com/view/andhow/user-guide/value-loaders">well established order</a>.
 * At startup, AndHow scans {@code System.Properties}, env. variables, JNDI values,
 * the {@code andhow.properties} file, etc. automatically.
 * <p>
 * To read configuration from commandline, however, requires a bit of help from the application:<br>
 * {@code AndHow.findConfig().setCmdLineArgs(args);}<br>
 * passes the command line arguments in to AndHow.
 * <p>
 * Invoking {@code main()} from commandline to set NAME='Dar' would look like this:<br>
 * {@code  java -Dorg.simple.HelloWorld2.Config.NAME=Dar -cp [classpath] simple.HelloWorld2}<br>
 * <p>
 * Note how we didn't have to make up a 'name' for NAME - The Java canonical name is used by default
 * to read Property values from configuration sources.  Thus, the names used to specify Property
 * values are always unique, just as the class names and the fields in them are unique.
 */
public class HelloWorld2 {

	//1 Declare
	private static interface Config {
			StrProp NAME = StrProp.builder().mustStartWith("D")
					.defaultValue("Dave").build();

			IntProp REPEAT_COUNT = IntProp.builder().mustBeLessThan(5)
					.defaultValue(2).build();
	}
	
	public static void main(String[] args) {
		
		//2 Add command line arguments
		AndHow.findConfig().setCmdLineArgs(args);
			
		//3 Use
		for (int i = 0; i < Config.REPEAT_COUNT.getValue(); i++) {
			System.out.println(Config.NAME.getCanonicalName());
			System.out.println("Hello, " + Config.NAME.getValue());
		}
	}
}
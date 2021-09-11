package org.simple;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.property.*;

/**
 * This is the example from the AndHow project's Readme file.
 * 
 * <h3>Section //1 : Declare AndHow Properties</h3>
 * Here the Properties are moved into an interface, a best practice for organization and visibility.
 * Only code able to 'see' the interface can retrieve the Property values, just like standard
 * Java visibility.  Also, fields declared in an interface are implicitly {@code static final},
 * saving a bit of typing.
 * <p>
 * We also added validation to the Properties.  At startup, <em>all Properties in your entire
 * application</em> are auto-discovered and validated.  This ensures that a mis-configuration
 * application <em>fails fast</em> at startup, rather than mysteriously erroring later.
 * 
 * <h3>Section //2 : Add command line arguments</h3>
 * AndHow automatically loads Property values from several configuration sources at startup.
 * For instance, these examples would scan for property values in {@code System.Properties},
 * env. variables, JNDI values, an {@code andhow.properties} file, etc. automatically.
 * <p>
 * To read configuration from commandline, however, the app must pass the values in to AndHow, e.g.:<br>
 * {@code AndHow.findConfig().setCmdLineArgs(args);}
 * <p>
 * Invoking {@code main()} from commandline to set NAME='Dar' would look like this:<br>
 * {@code  java -Dorg.simple.HelloWorld2.Config.NAME=Dar -cp [classpath] org.simple.HelloWorld2}<br>
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
			System.out.println("Hello, " + Config.NAME.getValue());
		}
	}
}
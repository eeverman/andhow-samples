package org.simple;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.property.*;

/**
 * This is the example from the AndHow project's Readme file.
 * 
 * <h3>Section //1 : Declaring AndHow Properties</h3>
 * Properties must be <code>final static</code>, but may be <code>private</code> or any other scope.
 * <code>builder</code> methods simplify adding validation, description, defaults and other metadata.
 * Properties are strongly typed, so default values and validation are type specific, e.g.,
 * <code>StrProp</code> has Regex validation while the <code>IntProp</code> has
 * GreaterThan / LessThan rules available.
 * 
 * <h3>Section //2 : Using AndHow Properties</h3>
 * AndHow Properties are used just like static final constants with an added
 * <code>.getValue()</code> tacked on. Strong typing means that calling 
 * <code>COUNT_DOWN_START.getValue()</code> returns an <code>Integer</code>
 * while calling <code>LAUNCH_CMD.getValue()</code> returns a <code>String</code>.
 * <p>
 * An AndHow Property (and its value) can be accessed anywhere it is visible.
 * <code>COUNT_DOWN_START</code> is public in a public class, so it could be
 * used anywhere, while <code>LAUNCH_CMD</code> is private.
 * AndHow Properties are always <code>static</code>, so they can be accessed in
 * both static and instance methods, just like this example shows.
 * 
 * <h3>Section //3 : Accepting Command Line Arguments</h3>
 * If an application needs command line arguments <i>(CLAs)</i>,
 * just pass them to AndHow at startup as this example shows.
 * Properties are referred to using 'dot notation', e.g.:<br>
 * <code>java -jar GettingStarted.jar org.simple.GettingStarted.LAUNCH_CMD=GoManGo</code><br>
 * If you don't need to accept CLA's, you can leave line <b>//3</b> out -
 * AndHow will initialize and startup without any explicit <b><i>init</i></b>
 * method when the first Property is accessed.
 * 
 * <h3>Running the example</h3>
 * If you run the example from the main method and no additional configuration
 * is available, the default value for each property is used and the example prints:
 * <pre>{@code 
 * 3...2...1...Go-Go-Go!
 * Gone-Gone-Gone!
 * }</pre>
 * 
 * See the AndHow Projects readme file and the project documentation for more info.
 * 
 * @author eeverman
 */
public class GettingStarted {
	
	//1
	public final static IntProp COUNT_DOWN_START = IntProp.builder().mustBeNonNull()
			.mustBeGreaterThanOrEqualTo(1).defaultValue(3).build();
	
	private final static StrProp LAUNCH_CMD = StrProp.builder().mustBeNonNull()
			.desc("What to say when its time to launch")
			.mustMatchRegex(".*Go.*").defaultValue("Go-Go-Go!").build();
	
	public String launch() {
		String launch = "";
		
		//2
		for (int i = COUNT_DOWN_START.getValue(); i >= 1; i--) {
			launch = launch += i + "...";
		}
		
		return launch + LAUNCH_CMD.getValue();
	}
	
	public static void main(String[] args) {
		AndHow.findConfig().setCmdLineArgs(args);	//3 Optional
		
		System.out.println( new GettingStarted().launch() );
		System.out.println( LAUNCH_CMD.getValue().replace("Go", "Gone") );
	}
}
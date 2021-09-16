package simple;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.property.*;

/**
 * The classic HelloWorld for AndHow...
 * <hr>
 * <h3>Section //1 : Declare AndHow Properties</h3>
 * {@code StrProp} &amp; {@code IntProp} are AndHow {@code Property}'s.
 * Properties are created as <em>constants</em> in your application, thus, they are always
 * {@code final static}, but may be {@code private} or any scope.
 * Properties are strongly typed, so default values and validation are type specific.
 * 
 * <h3>Section //2 : Using AndHow Properties</h3>
 * Properties are used just like static final constants with {@code .getValue()} tacked on.
 * Strong typing means that {@code NAME.getValue()} returns a {@code String} while
 * {@code REPEAT_COUNT.getValue()} returns an {@code Integer}.
 * <p>
 * These Properties have defaults, so no further configuration is needed:
 * running {@code HelloWorld.main()} will print <b>{@code Hello, Dave}</b> twice.
 * We can override the defaults by adding a {@code andhow.properties} file on the
 * classpath like this:
 * <pre>{@code
 * simple.HelloWorld.NAME: Kathy
 * simple.HelloWorld.REPEAT_COUNT: 4
 * }</pre>
 * Resulting in <b>{@code Hello, Kathy}</b> x4.
 */
public class HelloWorld {
	
	//1 Declare AndHow Properties
	private final static StrProp NAME = StrProp.builder()
			.defaultValue("Dave").build();
		
	public final static IntProp REPEAT_COUNT = IntProp.builder()
			.defaultValue(2).build();
	
	public static void main(String[] args) {
		
		//2 Use AndHow Properties
		for (int i = 0; i < REPEAT_COUNT.getValue(); i++) {
			System.out.println("Hello, " + NAME.getValue());
		}
	}
}
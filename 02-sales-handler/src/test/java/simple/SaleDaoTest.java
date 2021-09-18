package simple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.yarnandtail.andhow.junit5.KillAndHowBeforeEachTest;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * To keep the HelloWorld2 class as simple as possible, it just prints to Sys.out.
 * 
 * This isn't best practice - Don't worry there are lots of good test examples
 * in the other samples.
 */
@KillAndHowBeforeEachTest
public class SaleDaoTest {
	
	@Test
	public void verySimpleDefaultTest() throws Exception {

		SaleDao dao = new SaleDao();

		Properties props = dao.getExportedConfig();

		assertEquals("changeme", props.getProperty("hibernate.connection.password"));
		assertEquals("jdbc://mydb", props.getProperty("hibernate.connection.url"));

		// These are not in the exported properties b/c the default export option
		// is to not export canonical names if there is an 'out' alias on the Property.
		assertFalse(props.containsKey("simple.SaleDao.Db.PWD"));
		assertFalse(props.containsKey("simple.SaleDao.Db.URL"));
	}

	
}

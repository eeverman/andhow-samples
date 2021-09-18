package simple;

import org.yarnandtail.andhow.AndHow;
import org.yarnandtail.andhow.export.ExportCollector;
import org.yarnandtail.andhow.export.ManualExportAllowed;
import org.yarnandtail.andhow.property.StrProp;

import java.util.Properties;

// Pretend data access object
public class SaleDao {

	// 2 Declare DB connection Properties
	@ManualExportAllowed
	private static interface Db {
		StrProp URL = StrProp.builder().mustStartWith("jdbc://").mustBeNonNull()
				.aliasInAndOut("hibernate.connection.url").build();
		StrProp PWD = StrProp.builder().mustBeNonNull()
				.aliasInAndOut("hibernate.connection.password").build();
	}

	// 3 Export Db properties to a {@code util.Properties} instance
	Properties getExportedConfig() throws Exception {
		Properties props = AndHow.instance().export(Db.class)
				.collect(ExportCollector.stringProperties(""));

		return props;
	}

	// Pretend database storage call
	Object storeSale(Object sale) throws Exception {
		Hibernate h = new Hibernate(getExportedConfig());
		return h.save(sale);
	}

	// Pretend Hibernate instance
	static class Hibernate {
		public Hibernate(Properties props) {}
		public Object save(Object o) { return o; }
	}
}

package org.example;

import org.yarnandtail.andhow.GroupInfo;
import org.yarnandtail.andhow.property.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReportGenerator {

	/* In doc example, this interface is private, but that only works in JDK11+ */
	@GroupInfo(name="Record filter", desc="Filters are AND'ed together")
	interface Filter {
		StrProp REGION = StrProp.builder()
			.oneOfIgnoringCase("EAST", "WEST").build();
		StrProp ZIP = StrProp.builder().matches("\\d{5}(\\-\\d{4})?")
			.desc("Zipcode w optional plus 4 (12345 or 12345-1234)").build();
		LocalDateTimeProp START_TIME = LocalDateTimeProp.builder()
			.defaultValue(LocalDateTime.parse("2010-01-01T00:00"))
			.desc("Include records after this date-time").build();
		BigDecProp MIN_SALE = BigDecProp.builder()
			.defaultValue(BigDecimal.TEN).greaterThanOrEqualTo(BigDecimal.ZERO)
			.desc("Min sale amount to include").build();
	}

	/* In doc example, this interface is private, but that only works in JDK11+ */
	interface Format {
		DblProp MARGIN = DblProp.builder().defaultValue(1d)
			.greaterThan(.25d).desc("Margin in inches").build();
		BolProp WITH_HEADERS = BolProp.builder().defaultValue(true).build();
	}
}

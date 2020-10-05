package com.clampg.microservices.msscbrewery.web.mappers;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

@Component
public class DateMapper {
	public OffsetDateTime asOffsetDateTime(Timestamp ts) {
		if (ts == null) return null;
		
		return OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue(),
				ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(),
				ts.toLocalDateTime().getMinute(), ts.toLocalDateTime().getSecond(),
				ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
	}
	public Timestamp asTimeStamp(OffsetDateTime dt) {
		if (dt == null) return null;
		return Timestamp.valueOf(dt.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
	}
}

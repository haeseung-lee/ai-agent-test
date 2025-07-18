package com.example.ai_agent_test.gemini.tools;

import java.time.LocalDateTime;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DateTimeTools {
	
	@Tool(description = "Get the current date and time in the user's timezone")
	String getCurrentDateTime() {
		String dateTime = LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
		System.out.println("####dateTime : " + dateTime );
		return dateTime;
	}
}

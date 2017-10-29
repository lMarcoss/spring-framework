package com.leo.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskComponent")
public class TaskComponent {
	private static final Log log = LogFactory.getLog(TaskComponent.class);

	@Scheduled(fixedDelay = 5000)
	public void doTask() {
		log.info("TIME IS: " + new Date());
	}
}

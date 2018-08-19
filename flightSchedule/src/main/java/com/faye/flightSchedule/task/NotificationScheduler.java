package com.faye.flightSchedule.task;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.faye.flightSchedule.ETACrawler;
import com.faye.flightSchedule.EmailSender;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationScheduler {
	
	@Autowired
	private final ETACrawler etaCrawler;
	
	@Autowired
	private final EmailSender emailSender;
	
	static Map<String, String> schedules = Collections.synchronizedMap(new HashMap<String, String>());
	
	static {
		schedules.put("sz11phil", "");
	}
	
	public NotificationScheduler(ETACrawler etaCrawler, EmailSender emailSender) {
		this.etaCrawler = etaCrawler;
		this.emailSender = emailSender;
	}
	
	@Scheduled(cron="*/60 * * * * *")
    public void captureData() throws Exception {
		String user = "sz11phil";
		String password = "lileo333";
		String content = etaCrawler.simulateLogin(user, password);
		
		if(!schedules.get(user).equals(content)) {
			schedules.put(user, content);
			emailSender.send(content);
			System.out.println("发送成功！"+LocalDateTime.now());
		}else {
			System.out.println("没有变化！"+LocalDateTime.now());
		}
    }
}

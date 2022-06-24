package com.PI.apiBooking;

import com.PI.apiBooking.Utils.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class ProjectApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException {
		emailSenderService.sendHtmlMail("nicolasezdias@gmail.com");
	}
}

package com.PI.apiBooking.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;


@Service
public class EmailSenderService{
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine thymeleafTamplateEngine;

    private final String serviceAddress = "correodeautenticacionctd@gmail.com";
    private final String subject = "Digital Booking";

    public void sendMailUser(String to, String user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(subject);
        helper.setFrom(serviceAddress);
        helper.setTo(to);
        Context context = new Context();
        context.setVariable("user",user);
        helper.setSubject(subject);
        helper.setFrom(serviceAddress);
        helper.setTo(to);
        String htmlbody = thymeleafTamplateEngine.process("mailUser",context);
        helper.setText(htmlbody, true);
        mailSender.send(message);
    }

    public void sendMailBooking(String to, String user, LocalDate arrival, LocalDate departure, String category, String productName, String location, String image) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(subject);
        helper.setFrom(serviceAddress);
        helper.setTo(to);
        Context context = new Context();
        context.setVariable("user",user);
        context.setVariable("arrival",arrival);
        context.setVariable("departure",departure);
        context.setVariable("category",category);
        context.setVariable("productName",productName);
        context.setVariable("location",location);
        context.setVariable("image",image);
        String htmlbody = thymeleafTamplateEngine.process("mailBooking",context);
        helper.setText(htmlbody, true);
        mailSender.send(message);
    }

}
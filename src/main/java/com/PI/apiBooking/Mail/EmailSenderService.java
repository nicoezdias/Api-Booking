package com.PI.apiBooking.Mail;

import com.PI.apiBooking.Model.DTO.ImageProductDto;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Repository.IUserRepository;
import com.PI.apiBooking.Service.Impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine thymeleafTamplateEngine;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ImageService imageService;


    private final String serviceAddress = "correodeautenticacionctd@gmail.com";
    private final String subject = "Digital Booking";

    public void sendMailUser(UserDto user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(subject);
        helper.setFrom(serviceAddress);
        helper.setTo(user.getEmail());
        Context context = new Context();
        context.setVariable("user",user.getName()+" "+user.getSurname());
        helper.setSubject(subject);
        helper.setFrom(serviceAddress);
        String htmlbody = thymeleafTamplateEngine.process("mailUser",context);
        helper.setText(htmlbody, true);
        mailSender.send(message);
        System.out.println("Mail enviado");
    }

    public void sendMailBooking(BookingDto bookingDto) throws MessagingException {
        User user = userRepository.findById(bookingDto.getUser().getId()).get();
        Product product = productRepository.findById(bookingDto.getProduct().getId()).get();
        ImageProductDto imagen = imageService.findProfileImageByProductId(product.getId());
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(subject);
        helper.setFrom(serviceAddress);
        helper.setTo(user.getEmail());

        Context context = new Context();
        context.setVariable("user",user.getName()+" "+user.getSurname());
        context.setVariable("arrival",bookingDto.getArrival());
        context.setVariable("departure",bookingDto.getDeparture());
        context.setVariable("category",product.getCategory().getTitle());
        context.setVariable("productName",product.getName());
        context.setVariable("location",product.getDirection()+", "+product.getCity().getName()+", "+product.getCity().getProvince().getName()+", "+ product.getCity().getProvince().getCountry().getName());
        context.setVariable("image",imagen.getUrl());
        String htmlbody = thymeleafTamplateEngine.process("mailBooking",context);
        helper.setText(htmlbody, true);
        mailSender.send(message);
        System.out.println("Mail enviado");
    }

}
package com.backend.pharmacy_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@CrossOrigin(origins = "http://localhost:4200/")
@Component
@RestController
//email gửi tự động
@EnableScheduling
public class MailerController {
    @Autowired
    private JavaMailSender emailSender;

    @GetMapping("email/send")
//    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate dayPlusAWeek = LocalDate.now().plusDays(1);
        LocalDate dayPlusAWeek = LocalDate.now();
        String day = formatter.format(dayPlusAWeek);

        String array = "khanhphan900@gmail.com";
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(array);
        message.setSubject("Chào quý khách");
        message.setText("Chào bạn \n"
                + "Bạn đã thanh toán thành công đơn hàng ngày: " + day );

        // Send Message!
        this.emailSender.send(message);
    }
}

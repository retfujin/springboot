/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.juvenxu.mvnbook.account.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author fujd
 */
public class AccountEmailServiceImpl implements AccountEmailService{

    private JavaMailSender javaMailSender;
    
    private String systemEmail;
    
    public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException {
        
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText, true);
            
            javaMailSender.send(msg);
        } catch (MessagingException ex) {
            throw new AccountEmailException("failed to send mail.",ex);
        }
        
        
        
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
    
    
    
}

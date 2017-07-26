/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juvenxu.mvnbook.account.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import javax.mail.Message;
import javax.mail.MessagingException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author fujd
 */
public class AccountEmailServiceTest {
    private GreenMail greenMail;
    
    @Before
    public void startMailServer(){
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("retfu1@163.com", "dafucom33");
        System.out.println(greenMail.getSmtp());
     //   greenMail.start();
        
    }
    @Test
    public void testSendEmail() throws AccountEmailException, InterruptedException, MessagingException{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService service = (AccountEmailService)ctx.getBean("accountEmailService");
        
        String subject = "标题1";
        String htmlText = "<h1>sss<h1>";
        service.sendEmail("retfujin@163.com", subject, htmlText);
        
        greenMail.waitForIncomingEmail(4000, 1);
        
        Message[] msg = greenMail.getReceivedMessages();
        assertEquals(1,msg.length);
        assertEquals(subject,msg[0].getSubject());
    //    assertEquals(htmlText,GreenMailUtil.getBody(msg[0]).trim());
        System.out.println(GreenMailUtil.getBody(msg[0]).trim());
    }
    
    @After
    public void stopServer(){
        greenMail.stop();
    }
}

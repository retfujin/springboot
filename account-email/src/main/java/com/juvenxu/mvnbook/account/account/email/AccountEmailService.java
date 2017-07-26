/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juvenxu.mvnbook.account.account.email;

/**
 *
 * @author fujd
 */
public interface AccountEmailService {
    void sendEmail(String to,String subject,String htmlText) throws AccountEmailException;
}

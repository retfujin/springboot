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
public class AccountEmailException extends Exception {
    public AccountEmailException(String message,Exception ex){
        super(message, ex);
    }
}

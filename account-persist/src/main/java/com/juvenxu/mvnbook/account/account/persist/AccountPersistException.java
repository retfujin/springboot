/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juvenxu.mvnbook.account.account.persist;

/**
 *
 * @author fujd
 */
public class AccountPersistException extends Exception {
    public AccountPersistException(String describe,Exception ex){
        super(describe, ex);
    }
}

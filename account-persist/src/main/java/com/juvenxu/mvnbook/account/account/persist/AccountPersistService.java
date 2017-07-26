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
public interface AccountPersistService {
    Account creatAccount(Account account) throws AccountPersistException;
    Account readAccount(String id) throws AccountPersistException;
    Account updateAccount(Account account) throws AccountPersistException;
    void deleteAccount(String id) throws AccountPersistException;
    
}

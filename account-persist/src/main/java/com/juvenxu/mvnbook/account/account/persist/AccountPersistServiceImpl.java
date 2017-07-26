/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juvenxu.mvnbook.account.account.persist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author fujd
 */
public class AccountPersistServiceImpl implements AccountPersistService{

    private String file;
    
    private SAXReader reader = new SAXReader();
    
    private Document readDocument() throws AccountPersistException{
        File dateFile = new File(file);
        if(!dateFile.exists()){
            dateFile.getParentFile().mkdirs();
            Document doc = DocumentFactory.getInstance().createDocument();
            Element rootEle = doc.addElement("account-persist");
            rootEle.addElement("accounts");
            writeDocument(doc);
        }
        try{
            return reader.read(dateFile);
        }catch(DocumentException ex){
            throw new AccountPersistException("Unable to read persist data.xml",ex);
        }
    }
    
    @Override
    public Account creatAccount(Account account) throws AccountPersistException {
        Document doc = readDocument();
        Element accountEle = doc.getRootElement().element("accounts");
        accountEle.add(creatAccountElement(account));
        writeDocument(doc);
        
        return readAccount(account.getId());
        
    }

    @Override
    public Account readAccount(String id) throws AccountPersistException {
        Document doc = readDocument();
        Element accountEle = doc.getRootElement().element("accounts");
        for(Element account:(List<Element>)accountEle.elements()){
            if(account.elementText("id").equals(id)){
                return buildAccount(account);
            }
        }
        
        return null;
    }

    @Override
    public Account updateAccount(Account account) throws AccountPersistException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAccount(String id) throws AccountPersistException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void writeDocument(Document doc) throws AccountPersistException {
        Writer out = null;
        try{
            out = new OutputStreamWriter(new FileOutputStream(file),"utf-8");
            XMLWriter writer = new XMLWriter(out,OutputFormat.createPrettyPrint());
            writer.write(doc);
            
        }catch(IOException e){
            throw new AccountPersistException("Unable to write persist data.xml",e);
        }finally{
            if(out!=null){
                try {
                    out.close();
                } catch (IOException ex) {
                    throw new AccountPersistException("Unable to close persist data.xml",ex);
                }
            }
                
        }
    }

    private Account buildAccount(Element account) {
        Account model = new Account();
        model.setId(account.elementText("id"));
        model.setEmail(account.elementText("email"));
        model.setActivated(("true".equals(account.elementText("activated"))?true:false));
        model.setName(account.elementText("name"));
        model.setPassword(account.elementText("password"));
        
        return model;
    }
    
    private Element creatAccountElement(Account account){
        Element ele = new org.dom4j.dom.DOMElement("account");
        ele.addElement("id").addText(account.getId());
        ele.addElement("email").addText(account.getEmail());
        ele.addElement("activated").addText(Boolean.toString(account.isActivated()));
        ele.addElement("name").addText(account.getName());
        ele.addElement("password",account.getPassword());
        
        return ele;
    }



    public void setFile(String file) {
        this.file = file;
    }
    
}

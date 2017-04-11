package com.zkbr.mystudy.jspservletjdbc.model;
/**
 * 
 * @author fujd
 */
public class Product {
        private int proTypeId;//类型id
        private String proTypeName;//类型名称
    
	private int proId;//产品id
	private int number; //数量
	private String model;//型号
	private String proName;//产品名称
        private String proRemark;//产品描述

    public int getProTypeId() {
        return proTypeId;
    }

    public void setProTypeId(int proTypeId) {
        this.proTypeId = proTypeId;
    }

    public String getProTypeName() {
        return proTypeName;
    }

    public void setProTypeName(String proTypeName) {
        this.proTypeName = proTypeName;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

   

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProRemark() {
        return proRemark;
    }

    public void setProRemark(String proRemark) {
        this.proRemark = proRemark;
    }
	
	
	
}

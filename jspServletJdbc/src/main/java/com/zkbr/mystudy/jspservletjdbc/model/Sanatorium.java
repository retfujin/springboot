package com.zkbr.mystudy.jspservletjdbc.model;

public class Sanatorium {
	private int housintId;
	private int structureId;
	private int number;
	private int quantity;
	private String recreation;
	private String procedures;
	private String corpsName;
	
	public int getHousintId() {
		return housintId;
	}
	public void setHousintId(int housintId) {
		this.housintId = housintId;
	}
	public int getStructureId() {
		return structureId;
	}
	public void setStructureId(int structureId) {
		this.structureId = structureId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRecreation() {
		return recreation;
	}
	public void setRecreation(String recreation) {
		this.recreation = recreation;
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	public String getCorpsName() {
		return corpsName;
	}
	public void setCorpsName(String corpsName) {
		this.corpsName = corpsName;
	}
}

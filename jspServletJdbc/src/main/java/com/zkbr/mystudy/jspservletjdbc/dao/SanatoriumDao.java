package com.zkbr.mystudy.jspservletjdbc.dao;

import com.zkbr.mystudy.jspservletjdbc.model.Product;
import com.zkbr.mystudy.jspservletjdbc.util.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SanatoriumDao {
	private Connection connection;
	private String sql;

	public SanatoriumDao() {
		super();
		connection = DbConnect.getConnection();
	}
	
	public List<Product> getAllHousing() {
		List<Product> ls = new ArrayList<Product>();
		sql = "SELECT h.id, s.proTypeName,h.proName, h.number, h.model, h.proRemark" +
				" FROM housing h, structure s " +
				"WHERE h.sid = s.id;";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Product product = new Product();
				product.setProId(resultSet.getInt("id"));
                                product.setNumber(resultSet.getInt("number"));
				product.setModel(resultSet.getString("model"));
                                product.setProName(resultSet.getString("proName"));
				product.setProTypeName(resultSet.getString("proTypeName"));
                                
				ls.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ls;
	}
	
	public List<Product> getStructure() {
		List<Product> sanatorium = new ArrayList<Product>();
		sql = "SELECT * FROM structure";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Product structure = new Product();
				structure.setProTypeId(resultSet.getInt("id"));
				structure.setProTypeName(resultSet.getString("proTypeName"));
				sanatorium.add(structure);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sanatorium;
	}
	
	public Product getDescriptionByHousingId(int proId) {
		Product product = new Product();
		sql = "SELECT h.id, s.proTypeName,h.proName, h.number, h.model, h.proRemark" +
				" FROM housing h, structure s " +
				"WHERE s.id = h.sid AND h.id = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, proId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
                                
				product.setProId(resultSet.getInt("id"));
                                product.setNumber(resultSet.getInt("number"));
				product.setModel(resultSet.getString("model"));
                                product.setProName(resultSet.getString("proName"));
				product.setProTypeName(resultSet.getString("proTypeName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	
	public int addCorps(Product type) {
		sql = "INSERT INTO structure (proTypeName) " +
				"VALUES (?);";
		int housingId = 0;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, type.getProTypeName());
			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				housingId = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return housingId;
	}
	
	public void addDiscription(Product housing) {
		sql = "INSERT INTO housing (sid, number, model, proName, proRemark) " +
				"VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, housing.getProTypeId());
			preparedStatement.setInt(2, housing.getNumber());
			preparedStatement.setString(3, housing.getModel());
      
			preparedStatement.setString(4, housing.getProName());
			preparedStatement.setString(5, housing.getProRemark());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

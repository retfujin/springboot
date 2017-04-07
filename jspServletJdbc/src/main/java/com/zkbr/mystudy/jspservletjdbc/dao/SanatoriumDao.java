package com.zkbr.mystudy.jspservletjdbc.dao;

import com.zkbr.mystudy.jspservletjdbc.model.Sanatorium;
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
	
	public List<Sanatorium> getAllHousing() {
		List<Sanatorium> sanatorium = new ArrayList<Sanatorium>();
		sql = "SELECT h.id, s.cname, h.number, h.quantity, h.recreation, h.procedures " +
				"FROM housing h, structure s " +
				"WHERE h.sid = s.id;";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Sanatorium housing = new Sanatorium();
				housing.setHousintId(resultSet.getInt("id"));
				housing.setCorpsName(resultSet.getString("cname"));
				housing.setNumber(resultSet.getInt("number"));
				housing.setQuantity(resultSet.getInt("quantity"));
				housing.setRecreation(resultSet.getString("recreation"));
				housing.setProcedures(resultSet.getString("procedures"));
				sanatorium.add(housing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sanatorium;
	}
	
	public List<Sanatorium> getStructure() {
		List<Sanatorium> sanatorium = new ArrayList<Sanatorium>();
		sql = "SELECT * FROM structure";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Sanatorium structure = new Sanatorium();
				structure.setStructureId(resultSet.getInt("id"));
				structure.setCorpsName(resultSet.getString("cname"));
				sanatorium.add(structure);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sanatorium;
	}
	
	public Sanatorium getDescriptionByHousingId(int housingId) {
		Sanatorium housing = new Sanatorium();
		sql = "SELECT s.cname, h.number, h.quantity, h.recreation, h.procedures " +
				"FROM housing h, structure s " +
				"WHERE s.id = h.sid AND h.id = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, housingId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				housing.setCorpsName(resultSet.getString("cname"));
				housing.setNumber(resultSet.getInt("number"));
				housing.setQuantity(resultSet.getInt("quantity"));
				housing.setRecreation(resultSet.getString("recreation"));
				housing.setProcedures(resultSet.getString("procedures"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return housing;
	}
	
	public Sanatorium getQuantityByNumber(int number) {
		Sanatorium housing = new Sanatorium();
		sql = "SELECT s.cname, h.number, h.quantity " +
				"FROM housing h, structure s " +
				"WHERE s.id = h.sid AND h.number = ?;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, number);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				housing.setCorpsName(resultSet.getString("cname"));
				housing.setNumber(resultSet.getInt("number"));
				housing.setQuantity(resultSet.getInt("quantity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return housing;
	}
	
	public int addCorps(Sanatorium structure) {
		sql = "INSERT INTO structure (cname) " +
				"VALUES (?);";
		int housingId = 0;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, structure.getCorpsName());
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
	
	public void addDiscription(Sanatorium housing) {
		sql = "INSERT INTO housing (sid, number, quantity, recreation, procedures) " +
				"VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, housing.getStructureId());
			preparedStatement.setInt(2, housing.getNumber());
			preparedStatement.setInt(3, housing.getQuantity());
			preparedStatement.setString(4, housing.getRecreation());
			preparedStatement.setString(5, housing.getProcedures());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

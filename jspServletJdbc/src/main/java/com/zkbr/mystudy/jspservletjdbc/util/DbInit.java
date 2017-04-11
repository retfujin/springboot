package com.zkbr.mystudy.jspservletjdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInit {

	public static void initDB(Connection connection) {
		if (isDbEmpty(connection)) {
			try {
				Statement statement = connection.createStatement();
				
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS `structure` (" +
						"`id` int(10) NOT NULL AUTO_INCREMENT, " +
						"`proTypeName` varchar(50) NOT NULL, " +
						"PRIMARY KEY (`id`)" +
						") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;");
				statement.executeUpdate("INSERT INTO `structure` (`id`, `proTypeName`) VALUES " +
						"(1, '分类1'), " +
						"(2, '分类2'), " +
						"(3, '分类3');");
				
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS `housing` (" +
						"`id` int(10) NOT NULL AUTO_INCREMENT, " +
						"`sid` int(10) NOT NULL, " +
						"`number` tinyint(3) NOT NULL, " +
						"`model` varchar(250) NOT NULL, " +
						"`proName` varchar(250) DEFAULT NULL, " +
						"`proRemark` varchar(250) DEFAULT NULL, " +
						"PRIMARY KEY (`id`), " +
						"KEY `currency_fk1` (`sid`), " +
						"CONSTRAINT `currency_fk1` FOREIGN KEY (`sid`) REFERENCES `structure` (`id`)" +
						") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;");
				statement.executeUpdate("INSERT INTO `housing` (`id`, `sid`, `number`, `model`, " +
						"`proName`, `proRemark`) VALUES " +
						"(1, 1, 1,  '质量一级','产品1', NULL), " +
						"(2, 3, 0,  '质量二级','产品2', NULL), " +
						"(3, 3, 0,  '质量二级','产品3', NULL), " +
						"(4, 2, 0,  '质量三级','产品4', '22223; " +
						"4444');");
				
				statement.executeUpdate("CREATE TABLE `users` ("
						+ "`userid` INT(10) NOT NULL AUTO_INCREMENT, "
						+ "`username` VARCHAR(20) NULL DEFAULT NULL, "
						+ "`password` VARCHAR(32) NULL DEFAULT NULL, "
						+ "PRIMARY KEY (`userid`)) "
						+ "COLLATE='utf8_general_ci' " + "ENGINE=InnoDB;");
				statement.executeUpdate("INSERT INTO `users` "
						+ "(`userid`, `username`, `password`) "
						+ "VALUES (1, 'admin', 'admin');");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isDbEmpty(Connection connection) {
		String sql = "SELECT table_name FROM information_schema.tables "
				+ "WHERE table_name = ?";
		boolean boolResult = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, "housing");
			ResultSet resultSet = preparedStatement.executeQuery();
			boolResult = !resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			boolResult = true;
		}
		return boolResult;
	}
}

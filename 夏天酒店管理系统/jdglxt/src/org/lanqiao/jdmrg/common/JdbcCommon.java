package org.lanqiao.jdmrg.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcCommon {
	static Connection conn = null; 
	
	static{
		try {
			//加载数据库驱动
			Class.forName(JdbcProperties.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return connection
	 */
	public static Connection getConnection(){
		try {
			conn =  DriverManager.getConnection(JdbcProperties.getUrl(), 
					JdbcProperties.getUsername(), 
					JdbcProperties.getPwd()); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection() {
		//5. 释放资源
		try {
			if(null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

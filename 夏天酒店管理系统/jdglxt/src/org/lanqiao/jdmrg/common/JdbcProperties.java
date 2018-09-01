package org.lanqiao.jdmrg.common;

import java.util.Properties;

public class JdbcProperties {
	private static final String JDBC_NAME = "jdbc.properties"; //文件路径
	private static String driver;
	private static String url;
	private static String username;
	private static String pwd;

	private static final Properties p = new Properties();
	
	static{
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(JDBC_NAME));
			driver = p.getProperty("jdbc.driver");
			url = p.getProperty("jdbc.url");
			username = p.getProperty("jdbc.username");
			pwd = p.getProperty("jdbc.pwd");
		} catch (Exception e) {
			System.err.println("log:数据库配置文件(jdbc.properties)信息有误！请检查文件路径、文件名是否正确！");
			e.printStackTrace();
		}
	}

	public static String getDriver() {
		return driver;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPwd() {
		return pwd;
	}
}

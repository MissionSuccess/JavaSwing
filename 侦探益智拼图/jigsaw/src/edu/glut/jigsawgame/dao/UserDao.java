package edu.glut.jigsawgame.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.glut.jigsawgame.common.DatabaseCrud;
import edu.glut.jigsawgame.common.JdbcCommon;
/**
 * �����ݵ�����
 * @author GuoX
 *
 */
public class UserDao {
	/**
	 * ����û�
	 * @param username
	 * @param pwd
	 */
	public void addUser(String username,String pwd) {
		String sql = "insert into user_pwd (username,pwd) values(?,?)";
		Object[] params = {username,pwd};
		boolean ret = (boolean)DatabaseCrud.doCrud(sql, params);
		JdbcCommon.closeConnection();
	}
	
	/**
	 * �����û���
	 * @param user
	 * @return
	 */
	public boolean findUser(String user) {
		try {
			String sql = "select * from user_pwd where username = ?";
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, user);
			if(null != rs && rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * �����û�����
	 * @param user
	 * @return
	 */
	public String findPwd(String user) {
		String pwd = null;
		try {
			String sql = "select pwd from user_pwd where username = ?";
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, user);
			if(null != rs && rs.next()) {
				pwd = rs.getString("pwd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwd;
	}
}

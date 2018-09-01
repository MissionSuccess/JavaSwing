package org.lanqiao.jdmrg.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.common.DatabaseCrud;
import org.lanqiao.jdmrg.common.JdbcCommon;


public class ClientDao implements IBaseDao<Client>{
static Client cli = null ;
	@Override
	public boolean add(Client obj) {
		String sql = "insert into Client(accountNum,pwd,nickname,age,name,id,phoneNum) values(?,?,?,?,?,?,?)";
		Object values[] = {obj.getAccountNum(),obj.getPwd(),obj.getNickname(),obj.getAge(),obj.getName(),obj.getId(),obj.getPhoneNum()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	@Override
	public boolean deleteById(Serializable accountNum) {
		String sql = "delete from Client where accountNum = ?";
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, accountNum);		
		return ret;
	}

	@Override
	public boolean update(Client obj) {
		String sql = "update Client set accountNum = ?,pwd = ?,nickname = ?,age = ?,name = ?,id = ?, phoneNum = ? where accountNum = ?";
		Object values[] = {obj.getAccountNum(),obj.getPwd(),obj.getNickname(),obj.getAge(),obj.getName(),obj.getId(),obj.getPhoneNum(),obj.getAccountNum()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}
	
	/**根据账号找密码*/
	public Client findByaccountNum(Serializable accountNum) {
		String sql = "select accountNum,pwd from Client where accountNum=?";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, accountNum);
			if (null != rs && rs.next()) {
				cli = new Client(rs.getString("accountNum"),rs.getString("pwd"),null,-1,null,null,null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}
	
	/**根据账号修改密码*/
	public boolean updateByacconutNum(Client obj) {
		String sql = "update Client set pwd = ?  where accountNum = ?";
		Object values[] = {obj.getPwd(),obj.getAccountNum()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}
	
	@Override
	public Client findById(Serializable accountNum) {
		String sql = "select accountNum,pwd,nickname,age,name,id,phoneNum from Client where accountNum = ?";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, accountNum);
			if (null != rs && rs.next()) {
				cli = new Client(rs.getString("accountNum"),rs.getString("pwd"),rs.getString("nickname"),rs.getInt("age"),rs.getString("name"),rs.getString("id"),rs.getString("phoneNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}

	@Override
	public ArrayList<Client> listAll() {
		ArrayList<Client> ls = new ArrayList<>();
		String sql = "select accountNum,pwd,nickname,age,name,id,phoneNum from Client";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			if(null != rs ){
				while ( rs.next()) {
				cli = new Client(rs.getString("accountNum"),rs.getString("pwd"),rs.getString("nickname"),rs.getInt("age"),rs.getString("name"),rs.getString("id"),rs.getString("phoneNum"));
				ls.add(cli);
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public boolean isExist(Serializable accountNum) {
		boolean ret = false;
		try {
			String sql = "select 1 from Client where accountNum = ? ";
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql,accountNum);
			ret = rs != null && rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
}

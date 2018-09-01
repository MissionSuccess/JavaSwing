package org.lanqiao.jdmrg.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.DatabaseCrud;
import org.lanqiao.jdmrg.common.JdbcCommon;


public class RoomerDao {
static Roomer rer = null ;
	public boolean add(Roomer obj) {
		String sql = "insert into Roomer(accountNum,name,contact,roomNo,roomType,roomPrice,firstTime,lastTime,dayNum,inTime,id,roomerState) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object values[] = {obj.getAccountNum(),obj.getName(),obj.getContact(),obj.getRoomNo(),obj.getRoomType(),obj.getRoomPrice(),obj.getFirstTime(),obj.getLastTime(),obj.getDayNum(),obj.getInTime(),obj.getId(),obj.getRoomerState()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	public boolean deleteById(Roomer obj) {
		String sql = "delete from Roomer where accountNum = ? and name = ? and contact = ? and roomNo = ? and roomType = ? and roomPrice = ? and firstTime = ? and lastTime = ? and dayNum = ? and inTime = ?";
		Object values[] = {obj.getAccountNum(),obj.getName(),obj.getContact(),obj.getRoomNo(),obj.getRoomType(),obj.getRoomPrice(),obj.getFirstTime(),obj.getLastTime(),obj.getDayNum(),obj.getInTime()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql,values);		
		return ret;
	}

	public boolean update(Roomer obj) {
		String sql = "update Roomer set roomerState = ? where  accountNum = ? and name = ? and contact = ? and roomNo = ? and roomType = ? and roomPrice = ? and firstTime = ? and lastTime = ? and dayNum = ? and inTime = ? ";
		Object values[] = {obj.getRoomerState(),obj.getAccountNum(),obj.getName(),obj.getContact(),obj.getRoomNo(),obj.getRoomType(),obj.getRoomPrice(),obj.getFirstTime(),obj.getLastTime(),obj.getDayNum(),obj.getInTime()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	public Roomer findById(String roomNo,String roomerState) {
		String sql = "select accountNum,name,contact,roomNo,roomType,roomPrice,firstTime,lastTime,dayNum,inTime,id,roomerState from Roomer where ROOMNO = ? and ROOMERSTATE = ?";
		Object values[] = {roomNo,roomerState};
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, values);
			if (null != rs && rs.next()) {
				rer = new Roomer(rs.getString("accountNum"),rs.getString("name"),rs.getString("contact"),rs.getString("roomNo"),rs.getString("roomType"),rs.getString("roomPrice"),rs.getString("firstTime"),rs.getString("lastTime"),rs.getInt("dayNum"),rs.getString("inTime"),rs.getString("id"),rs.getString("roomerState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rer;
	}
	
	//guo
	public ArrayList<Roomer> findAllById(Serializable accountNum) {
		ArrayList<Roomer> ls = new ArrayList<Roomer>(); 
		String sql = "select accountNum,name,contact,roomNo,roomType,roomPrice,firstTime,lastTime,dayNum,inTime,id,roomerState from Roomer where accountNum = ?";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, accountNum);
			while (null != rs && rs.next()) {
				Roomer re = new Roomer(rs.getString("accountNum"),rs.getString("name"),rs.getString("contact"),rs.getString("roomNo"),rs.getString("roomType"),rs.getString("roomPrice"),rs.getString("firstTime"),rs.getString("lastTime"),rs.getInt("dayNum"),rs.getString("inTime"),rs.getString("id"),rs.getString("roomerState"));
				ls.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	/**
	 * 查询所有客户信息
	 * @param accountNum
	 * @return
	 */
	public ArrayList<Roomer> findAll() {
		ArrayList<Roomer> ls = new ArrayList<Roomer>(); 
		String sql = "select accountNum,name,contact,roomNo,roomType,roomPrice,firstTime,lastTime,dayNum,inTime,id,roomerState from Roomer";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			while (null != rs && rs.next()) {
				Roomer re = new Roomer(rs.getString("accountNum"),rs.getString("name"),rs.getString("contact"),rs.getString("roomNo"),rs.getString("roomType"),rs.getString("roomPrice"),rs.getString("firstTime"),rs.getString("lastTime"),rs.getInt("dayNum"),rs.getString("inTime"),rs.getString("id"),rs.getString("roomerState"));
				ls.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public ArrayList<Roomer> listAll() {
		ArrayList<Roomer> ls = new ArrayList<>();
		String sql = "select accountNum,name,contact,roomNo,roomType,roomPrice,firstTime,lastTime,dayNum,inTime,id,roomerState from Roomer";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			if(null != rs ){
				while ( rs.next()) {
					rer = new Roomer(rs.getString("accountNum"),rs.getString("name"),rs.getString("contact"),rs.getString("roomNo"),rs.getString("roomType"),rs.getString("roomPrice"),rs.getString("firstTime"),rs.getString("lastTime"),rs.getInt("dayNum"),rs.getString("inTime"),rs.getString("id"),rs.getString("roomerState"));
					ls.add(rer);
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public boolean isExist(Serializable accountNum) {
		boolean ret = false;
		try {
			String sql = "select 1 from Roomer where accountNum = ? ";
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql,accountNum);
			ret = rs != null && rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	
	}
	
	public boolean isRe(Roomer obj) {
		boolean ret = false;
		try {
			String sql = "select 1 from Roomer where   accountNum = ? and name = ? and contact = ? and roomNo = ? and roomType = ? and roomPrice = ? and firstTime = ? and lastTime = ? and dayNum = ? and inTime = ? ";
			Object values[] = {obj.getAccountNum(),obj.getName(),obj.getContact(),obj.getRoomNo(),obj.getRoomType(),obj.getRoomPrice(),obj.getFirstTime(),obj.getLastTime(),obj.getDayNum(),obj.getInTime()};

			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql,values);
			ret = rs != null && rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	
	}

	

}

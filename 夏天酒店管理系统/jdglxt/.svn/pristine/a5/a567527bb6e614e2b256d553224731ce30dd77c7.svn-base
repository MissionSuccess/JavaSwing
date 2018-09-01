package org.lanqiao.jdmrg.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.jdmrg.bean.Room;
import org.lanqiao.jdmrg.common.DatabaseCrud;
import org.lanqiao.jdmrg.common.JdbcCommon;


public class RoomDao implements IBaseDao<Room>{
static Room rom = null ;
	@Override
	public boolean add(Room obj) {
		String sql = "insert into Room(roomNo,roomType,roomPrice,roomState) values(?,?,?,?)";
		Object values[] = {obj.getRoomNo(),obj.getRoomType(),obj.getRoomPrice(),obj.getRoomState()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	@Override
	public boolean deleteById(Serializable roomNo) {
		String sql = "delete from Room where roomNo = ?";
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, roomNo);		
		return ret;
	}

	@Override
	public boolean update(Room obj) {
		String sql = "update Room set roomType = ?,roomPrice = ?,roomState = ?where roomNo = ?";
		Object values[] = {obj.getRoomNo(),obj.getRoomType(),obj.getRoomPrice(),obj.getRoomState(),obj.getRoomNo()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	@Override
	public Room findById(Serializable roomNo) {
		String sql = "select roomNo,roomType,roomPrice,roomState from Room where roomNo = ？";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, roomNo);
			if (null != rs && rs.next()) {
				rom = new Room(rs.getString("roomNo"),rs.getString("roomType"),rs.getInt("roomPrice"),rs.getString("roomState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rom;
	}

	@Override
	public ArrayList<Room> listAll() {
		ArrayList<Room> ls = new ArrayList<>();
		String sql = "select roomNo,roomType,roomPrice,roomState from Room";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			if(null != rs ){
				while ( rs.next()) {
					rom = new Room(rs.getString("roomNo"),rs.getString("roomType"),rs.getInt("roomPrice"),rs.getString("roomState"));
					ls.add(rom);
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public boolean isExist(Serializable RoomNo) {
		boolean ret = false;
		try {
			String sql = "select 1 from Room where RoomNo = ? ";
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql,RoomNo);
			ret = rs != null && rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	
	}

	

}

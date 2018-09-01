
package org.lanqiao.jdmrg.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.jdmrg.bean.Room;
import org.lanqiao.jdmrg.common.DatabaseCrud;
import org.lanqiao.jdmrg.common.JdbcCommon;

public class RoomerViewDao  {
	static Room rer = null ;
	public boolean add(Room obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteById(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(String rs,String ro) {
		String sql = "update ROOMVIEW set roomState = ? where roomNo = ?";
		Object values[] = {rs,ro};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	public Room findById(Serializable rNo) {
		String sql = "select roomNo,roomType,roomPrice,roomState from ROOMVIEW where roomNo = ?";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, rNo);
			if (null != rs && rs.next()) {
				rer = new Room(rs.getString("ROOMNO"),rs.getString("ROOMTYPE"),rs.getInt("ROOMPRICE"),rs.getString("ROOMSTATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rer;
	}
	/**
	 * 查找全部价格
	 * @return
	 */
	public int[][] findPriceByNum() {
		int pri[][] = new int[10][10];
		String sql = "select roomPrice from ROOMVIEW ";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			int i = 1, j = 1;
			while(null != rs && rs.next()) {
				pri[i][j] = rs.getInt("ROOMPRICE");
				j++;
				if(9 == j) {
					i++;
					j = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pri;
	}
	/**
	 * 查找全部状态
	 * @return
	 */
	public String[][] findAllState() {
		String pri[][] = new String[10][10];
		String sql = "select ROOMSTATE from ROOMVIEW ";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			int i = 1, j = 1;
			while(null != rs && rs.next()) {
				pri[i][j] = rs.getString("ROOMSTATE");
				j++;
				if(9 == j) {
					i++;
					j = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pri;
	}
	
	/**
	 * 查找全部房间类型
	 * @return
	 */
	public String[][] findAllType() {
		String pri[][] = new String[10][10];
		String sql = "select ROOMTYPE from ROOMVIEW ";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql);
			int i = 1, j = 1;
			while(null != rs && rs.next()) {
				pri[i][j] = rs.getString("ROOMTYPE");
				j++;
				if(9 == j) {
					i++;
					j = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pri;
	}
	
	/**
	 * 查找单个房间状态
	 * @return
	 */
	public boolean findsimState(String roomNo) {
		String pri = null;
		String sql = "select ROOMSTATE from ROOMVIEW where roomNo = ?";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql,roomNo);
			while(null != rs && rs.next()) {
				pri = rs.getString("ROOMSTATE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pri.equals("可预订")?true:false;
	}

	public ArrayList<Room> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isExist(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

}

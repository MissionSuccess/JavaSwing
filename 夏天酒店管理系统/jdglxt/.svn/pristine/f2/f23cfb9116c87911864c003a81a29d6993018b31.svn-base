package org.lanqiao.jdmrg.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.jdmrg.bean.FrontDesk;
import org.lanqiao.jdmrg.common.DatabaseCrud;
import org.lanqiao.jdmrg.common.JdbcCommon;

public class FrontDeskDao implements IBaseDao<FrontDesk>{
	static FrontDesk Fdesk  = null ;
	
	@Override
	public boolean add(FrontDesk obj) {
		String sql = "insert into Front_desk(accountNum,pwd) values(?,?,)";
		Object values[] = {obj.getAccountNum(),obj.getPwd()};
		boolean ret = (boolean) DatabaseCrud.doCrud(sql, values);
		JdbcCommon.closeConnection();
		return ret;
	}

	/**根据账号找密码*/
	public FrontDesk findByaccountNum(Serializable accountNum) {
		String sql = "select accountNum,password from Front_desk where accountNum=?";
		try {
			ResultSet rs = (ResultSet)DatabaseCrud.doCrud(sql, accountNum);
			if (null != rs && rs.next()) {
				Fdesk = new FrontDesk(rs.getString("accountNum"),rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Fdesk;
	}
	
	@Override
	public boolean deleteById(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(FrontDesk obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FrontDesk findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FrontDesk> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

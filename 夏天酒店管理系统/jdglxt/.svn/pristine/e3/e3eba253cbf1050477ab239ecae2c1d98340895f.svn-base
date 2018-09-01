package org.lanqiao.jdmrg.service;

import java.io.Serializable;
import java.util.ArrayList;

import org.lanqiao.jdmrg.bean.Room;
import org.lanqiao.jdmrg.dao.RoomDao;


public class RoomService implements IBaseService<Room> {
	 RoomDao roomDao = new RoomDao();

	@Override
	public boolean add(Room obj) {
		boolean ret = false;
		if (!roomDao.isExist(obj.getRoomNo())) {
			ret = roomDao.add(obj);
		}
		return ret;
	}

	@Override
	public boolean deleteById(Serializable id) {
		return roomDao.deleteById(id);
	}

	@Override
	public boolean update(Room obj) {
		boolean ret = false;
		if (roomDao.isExist(obj.getRoomNo())) {
			ret = roomDao.update(obj);
		}
		return ret;
	}

	

	@Override
	public ArrayList listAll() {
		return roomDao.listAll();
	}

	public Room selectById(Serializable roomNo) {
		return roomDao.findById(roomNo);
	}
	
}

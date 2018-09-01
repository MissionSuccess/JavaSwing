package org.lanqiao.jdmrg.service;

import java.io.Serializable;
import java.util.ArrayList;

import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.dao.ClientDao;

public class ClientService implements IBaseService<Client> {
	 ClientDao clientDao = new ClientDao();

	@Override
	public boolean add(Client obj) {
		boolean ret = false;
		if (!clientDao.isExist(obj.getId())) {
			ret = clientDao.add(obj);
		}
		return ret;
	}

	@Override
	public boolean deleteById(Serializable accountNum) {
		return clientDao.deleteById(accountNum);
	}

	@Override
	public boolean update(Client obj) {
		boolean ret = false;
		if (clientDao.isExist(obj.getId())) {
			ret = clientDao.update(obj);
		}
		return ret;
	}

	

	@Override
	public ArrayList listAll() {
		return clientDao.listAll();
	}

	public Client selectById(Serializable accountNum) {
		return clientDao.findById(accountNum);
	}
	
}

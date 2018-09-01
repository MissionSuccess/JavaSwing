package org.lanqiao.jdmrg.service;

import java.io.Serializable;
import java.util.ArrayList;

public interface IBaseService<E> {
	boolean add(E obj); 
	
	boolean deleteById(Serializable id); 
	
	boolean update(E obj); 
	
	
	
	ArrayList<E> listAll();
}

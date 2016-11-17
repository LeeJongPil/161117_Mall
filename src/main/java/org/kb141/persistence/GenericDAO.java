package org.kb141.persistence;

import java.util.List;

public interface GenericDAO<E, K> {

	public void create(E vo) throws Exception;
	
	public E read(K no) throws Exception;
	
	public void update(E vo) throws Exception;
	
	public void delete(K no) throws Exception;
	
	public List<E> getList() throws Exception;
	
}

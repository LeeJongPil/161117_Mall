package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public abstract class AbstractDAO<E, K> implements GenericDAO<E, K>{

	protected String mapperName;
	
	@Inject
	protected SqlSession sqlSession;

	public void create(E vo) throws Exception{
		sqlSession.insert("org.kb141.mapper." + mapperName + ".create", vo);
	}
	
	public E read(K no) throws Exception{
		return sqlSession.selectOne("org.kb141.mapper." + mapperName + ".read", no);
	}
	
	public void update(E vo) throws Exception{
		if (sqlSession.update("org.kb141.mapper." + mapperName + ".update", vo) < 1){
			throw new Exception("UPDATE ERROR");
		}
		
	}
	
	public void delete(K no) throws Exception{
		if(sqlSession.delete("org.kb141.mapper." + mapperName + ".delete", no) < 1) {
			throw new Exception("DELETE ERROR");
		}
	}

	public List<E> getList() throws Exception{
		return sqlSession.selectList("org.kb141.mapper."+ mapperName + ".getList");
	}
	
}

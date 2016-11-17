package org.kb141.persistence;

import org.kb141.domain.ProductVO;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl extends AbstractDAO<ProductVO, Integer> implements ProductDAO{

	public ProductDAOImpl(){
		this.mapperName = "ProductMapper";
	}
	
}

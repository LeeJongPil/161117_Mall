package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.ProductVO;
import org.kb141.persistence.ProductDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDAOTest {
	
	@Inject
	private ProductDAO dao;
	
	
	@Test
	public void createTest() throws Exception {
		
		dao.create(new ProductVO("hhkb", "pro2", "image.jpg"));
		
	}
	@Test
	public void  readTest() throws Exception{
		
		System.out.println(dao.read(1));
		
	}
	@Test
	public void updateTest() throws Exception{
		
		ProductVO vo = new ProductVO();
		vo.setPno(1);
		vo.setPname("hhkb2");
		vo.setPmaker("pro2");
		vo.setPimage("image2");
		dao.update(vo);
	}
	
	@Test
	public void deleteTest() throws Exception{
		
		dao.delete(1);
		
		
	}
}

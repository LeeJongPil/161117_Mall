package org.kb141.web;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBTest {
	
	@Inject
	private DataSource ds;
	
	
	@Test
	public void connectionTest() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.13:3306/bit88?useSSL=false&serverTimezone=Asia/Seoul"
				, "makemoney", "makemoney");
		
		System.out.println(con);
		
		con.close();
		
	}
	
	
	@Test
	public void connectionTest2() throws Exception {
		
		Connection con = ds.getConnection();
		
		System.out.println(con);
		
		con.close();
		
		
	}
	
}

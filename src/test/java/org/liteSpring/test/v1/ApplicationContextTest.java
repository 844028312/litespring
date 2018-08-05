package org.liteSpring.test.v1;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.liteSpring.context.ApplicationContext;
import org.liteSpring.context.support.ClassPathXmlApplicationContext;
import org.liteSpring.context.support.FileSystemXmlApplicationContext;
import org.liteSpring.service.v1.PetStoreService;

public class ApplicationContextTest {
	
	@Test
	public void classPathXml(){
		ApplicationContext contenxt=new ClassPathXmlApplicationContext("petStore_v1.xml");
		
		PetStoreService pat=(PetStoreService)contenxt.getBean("petStore");
		
		assertNotNull(pat);
	}
	
	@Test
	public void fileSystemXml(){
		ApplicationContext contenxt=new FileSystemXmlApplicationContext("E:\\dev\\petStore_v1.xml");
		
		PetStoreService pat=(PetStoreService)contenxt.getBean("petStore");
		
		assertNotNull(pat);
	}
}

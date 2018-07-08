package org.liteSpring.test.v1;


import org.junit.Test;
import org.liteSpring.beans.BeanDefination;
import org.liteSpring.beans.BeanFactory;
import org.liteSpring.beans.support.BeanCreationException;
import org.liteSpring.beans.support.BeanDefinitionStoreException;
import org.liteSpring.beans.support.DefaultBeanFactory;
import org.liteSpring.service.v1.PetStoreService;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BeanFactoryTest extends TestCase {
	
	@Test
	public void testGetBean(){
		BeanFactory factory=new DefaultBeanFactory("petStore_v1.xml");
		
		BeanDefination bd=factory.getBeanDefination("petStore");
		
		assertEquals("org.liteSpring.service.v1.PetStoreService", bd.getBeanClassName());
		
		PetStoreService pat=(PetStoreService)factory.getBean("petStore");
		
		assertNotNull(pat);
	}
	
	@Test
	public void testInvalidBean(){
		BeanFactory factory=new DefaultBeanFactory("petStore_v1.xml");
		try{
			factory.getBean("invalidBean");
		}catch(BeanCreationException e){
			return ;
		}
		Assert.fail("expect BeanCreationException");
	}
	
	@Test
	public void testInvalidXML(){
		
		try{
			BeanFactory factory=new DefaultBeanFactory("xxx.xml");
		}catch(BeanDefinitionStoreException e){
			return ;
		}
		Assert.fail("expect BeanDefinitionStoreException");
	}
}

package org.liteSpring.test.v1;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.liteSpring.beans.BeanDefinition;
import org.liteSpring.beans.factory.xml.XmlBeanDefinitionReader;
import org.liteSpring.beans.support.BeanCreationException;
import org.liteSpring.beans.support.BeanDefinitionStoreException;
import org.liteSpring.beans.support.DefaultBeanFactory;
import org.liteSpring.core.io.ClassPathResource;
import org.liteSpring.service.v1.PetStoreService;

import junit.framework.Assert;

public class BeanFactoryTest  {
	DefaultBeanFactory factory;
	XmlBeanDefinitionReader reader;
	
	@Before
	public void setFactory(){
		factory=new DefaultBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
	}
	
	@Test
	public void testGetBean(){
		reader.loadBeanDefinition(new ClassPathResource("petStore_v1.xml"));
		
		BeanDefinition bd=factory.getBeanDefination("petStore");
		
		assertTrue(bd.isSingleton());
		
		assertFalse(bd.isPrototype());
		
		assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());
		
		assertEquals("org.liteSpring.service.v1.PetStoreService",bd.getBeanClassName());
		
		PetStoreService petStore = (PetStoreService)factory.getBean("petStore");
		
		assertNotNull(petStore);
		
		PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");
		
		assertTrue(petStore.equals(petStore1));
	}
	
	@Test
	public void testInvalidBean(){
		
		reader.loadBeanDefinition(new ClassPathResource("petStore_v1.xml"));
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
			
			reader.loadBeanDefinition(new ClassPathResource("xxx.xml"));
		}catch(BeanDefinitionStoreException e){
			return ;
		}
		Assert.fail("expect BeanDefinitionStoreException");
	}
}

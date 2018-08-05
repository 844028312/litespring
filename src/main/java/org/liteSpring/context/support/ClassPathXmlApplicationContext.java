package org.liteSpring.context.support;

import org.liteSpring.beans.BeanFactory;
import org.liteSpring.beans.factory.xml.XmlBeanDefinitionReader;
import org.liteSpring.beans.support.DefaultBeanFactory;
import org.liteSpring.context.ApplicationContext;
import org.liteSpring.core.io.ClassPathResource;
import org.liteSpring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
	

	
	public ClassPathXmlApplicationContext(String path){
		super(path);
	}

	

	@Override
	protected Resource getResourceAsPath(String path) {
		
		return new ClassPathResource(path,getClassLoader());
	}



	

}

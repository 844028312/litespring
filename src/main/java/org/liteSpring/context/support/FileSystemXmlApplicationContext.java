package org.liteSpring.context.support;

import org.liteSpring.beans.factory.xml.XmlBeanDefinitionReader;
import org.liteSpring.beans.support.DefaultBeanFactory;
import org.liteSpring.context.ApplicationContext;
import org.liteSpring.core.io.ClassPathResource;
import org.liteSpring.core.io.FileSystemResource;
import org.liteSpring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {
	
	private DefaultBeanFactory factory;
	
	public FileSystemXmlApplicationContext(String fileName){
		super(fileName);
	}
	
	
	@Override
	protected Resource getResourceAsPath(String path) {
		
		return new FileSystemResource(path);
	}

}

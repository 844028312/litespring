package org.liteSpring.context.support;

import org.liteSpring.beans.BeanFactory;
import org.liteSpring.beans.factory.xml.XmlBeanDefinitionReader;
import org.liteSpring.beans.support.DefaultBeanFactory;
import org.liteSpring.context.ApplicationContext;
import org.liteSpring.core.io.ClassPathResource;
import org.liteSpring.core.io.Resource;
import org.liteSpring.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext{
	
	private DefaultBeanFactory factory;
	
	private ClassLoader loader;
	public AbstractApplicationContext(String path){
		factory=new DefaultBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		Resource resource=getResourceAsPath(path);
		reader.loadBeanDefinition(resource);
		factory.setClassLoader(loader);
	}
	
	public Object getBean(String beanName) {
		
		return factory.getBean(beanName);
	}
	
	protected abstract Resource getResourceAsPath(String path);
	
	
	public ClassLoader getClassLoader() {
		
		return this.loader=loader==null?ClassUtils.getDefaultClassload():loader;
		
	}

	public void setClassLoader(ClassLoader loader) {
		this.loader=loader;
	}
}

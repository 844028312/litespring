package org.liteSpring.beans;

import org.liteSpring.beans.support.GenericBeanDefinition;

public interface BeanFactory {
	
	
	
	public BeanDefination getBeanDefination(String beanName);
	
	public Object getBean(String beanName);
	
}

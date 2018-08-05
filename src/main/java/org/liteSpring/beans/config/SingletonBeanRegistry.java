package org.liteSpring.beans.config;

public interface SingletonBeanRegistry {
		
	void registryBean(String beanName,Object object);
	
	Object getSingleton(String beanName);
}

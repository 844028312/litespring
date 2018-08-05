package org.liteSpring.beans.support;

import org.liteSpring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
	
	BeanDefinition getBeanDefinition(String beanId);
	
	void registerBeanDefinition(String id, BeanDefinition bd);
}

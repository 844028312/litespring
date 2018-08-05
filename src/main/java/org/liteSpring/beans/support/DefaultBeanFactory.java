package org.liteSpring.beans.support;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.liteSpring.beans.BeanDefinition;
import org.liteSpring.beans.BeanFactory;
import org.liteSpring.beans.ConfigurableBeanFactory;
import org.liteSpring.test.v1.BeanFactoryTest;
import org.liteSpring.util.ClassUtils;

public class DefaultBeanFactory implements ConfigurableBeanFactory,BeanDefinitionRegistry {

	private Map<String,BeanDefinition> beanDefinationMap=new ConcurrentHashMap<String,BeanDefinition>();
	
	private ClassLoader loader;
	
	public BeanDefinition getBeanDefination(String beanName) {
		
		return beanDefinationMap.get(beanName);
	}

	public Object getBean(String beanName) {
		BeanDefinition bean=beanDefinationMap.get(beanName);
			if(bean==null){
				throw new BeanCreationException("bean Definition does not exist ");
				
			}
			ClassLoader cl=getClassLoader();
			Class<?> cls = null;
				try {
					cls=cl.loadClass(bean.getBeanClassName());
				    return  cls.newInstance();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new BeanCreationException("create bean is"+beanName+"is fail",e);
				}
			
		
	}
	
	

	public BeanDefinition getBeanDefinition(String beanId) {
		
		return beanDefinationMap.get(beanId);
	}

	
	public void registerBeanDefinition(String id, BeanDefinition bd) {
		
		beanDefinationMap.put(id, bd);
	}

	public ClassLoader getClassLoader() {
		
		return this.loader=loader==null?ClassUtils.getDefaultClassload():loader;
	}

	public void setClassLoader(ClassLoader loader) {
		
		this.loader=loader;
	}

}

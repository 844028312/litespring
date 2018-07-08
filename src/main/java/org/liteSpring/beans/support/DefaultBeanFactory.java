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
import org.liteSpring.beans.BeanDefination;
import org.liteSpring.beans.BeanFactory;
import org.liteSpring.test.v1.BeanFactoryTest;
import org.liteSpring.util.ClassUtils;

public class DefaultBeanFactory implements BeanFactory {

	private Map<String,BeanDefination> beanDefinationMap=new ConcurrentHashMap<String,BeanDefination>();
	
	public DefaultBeanFactory(String fileName){
		getBeanDefinationMap(fileName);
		
	}
	
	public BeanDefination getBeanDefination(String beanName) {
		
		return beanDefinationMap.get(beanName);
	}

	public Object getBean(String beanName) {
		BeanDefination bean=beanDefinationMap.get(beanName);
			if(bean==null){
				throw new BeanCreationException("bean Definition does not exist ");
				
			}
			ClassLoader cl=ClassUtils.getDefaultClassload();
			Class<?> cls = null;
				try {
					cls=cl.loadClass(bean.getBeanClassName());
				    return  cls.newInstance();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new BeanCreationException("create bean is"+beanName+"is fail",e);
				}
			
		
	}
	
	private void getBeanDefinationMap(String fileName){
		
		ClassLoader cl=ClassUtils.getDefaultClassload();
		InputStream is=cl.getResourceAsStream(fileName);
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(is);
			Element root=document.getRootElement();
			
			List<Element> beans=root.elements();
			
			for(Element element:beans ){
				GenericBeanDefinition beanDefination=new GenericBeanDefinition();
				beanDefination.setId(element.attributeValue("id"));
				beanDefination.setName(element.attributeValue("class"));
				beanDefinationMap.put(beanDefination.getId(), beanDefination);
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			throw new BeanDefinitionStoreException("IOException parsing xml document"+fileName+"is fail", e);
		}finally{
			if(is !=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}

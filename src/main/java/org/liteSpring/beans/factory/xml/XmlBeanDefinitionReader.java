package org.liteSpring.beans.factory.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.liteSpring.beans.BeanDefinition;
import org.liteSpring.beans.support.BeanDefinitionRegistry;
import org.liteSpring.beans.support.BeanDefinitionStoreException;
import org.liteSpring.beans.support.GenericBeanDefinition;
import org.liteSpring.core.io.Resource;
import org.liteSpring.util.ClassUtils;

public class XmlBeanDefinitionReader {
	private BeanDefinitionRegistry registry;
	
	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry){
		this.registry=registry;
	}
	
	public void loadBeanDefinition(Resource resource) {
		InputStream is=null;
		SAXReader reader=new SAXReader();
		try {
			is=resource.getInputStreanm();
			Document document=reader.read(is);
			Element root=document.getRootElement();
			
			List<Element> beans=root.elements();
			
			for(Element element:beans ){
				
				String id=element.attributeValue("id");
				String name=element.attributeValue("class");
				BeanDefinition bd=new GenericBeanDefinition(id,name);
				if(element.attributeValue(BeanDefinition.SCOPE)!=null){
					bd.setScope(element.attributeValue(BeanDefinition.SCOPE));
				}
				registry.registerBeanDefinition(id,bd);
			}
			
		} catch (Exception e) {
			
			throw new BeanDefinitionStoreException("IOException parsing xml document"+is+"is fail", e);
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

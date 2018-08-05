package org.liteSpring.beans.support;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.liteSpring.beans.config.SingletonBeanRegistry;
import org.liteSpring.util.Assert;

public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	
	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

	public void registryBean(String beanName, Object singletonObject) {
		
		Assert.notNull(beanName, "beanName must not null");
		
		Object oldObject =singletonObjects.get(beanName);
		if(oldObject !=null){
			throw new IllegalStateException("Could not register object [" + singletonObject +
					"] under bean name '" + beanName + "': there is already object [" + oldObject  + "] bound");
		}
		singletonObjects.put(beanName, singletonObject);
	}

	public Object getSingleton(String beanName) {
		
		return singletonObjects.get(beanName);
	}

}

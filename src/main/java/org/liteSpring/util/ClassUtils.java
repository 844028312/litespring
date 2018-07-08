package org.liteSpring.util;

public abstract class ClassUtils {
	
	public static ClassLoader getDefaultClassload(){
		ClassLoader cl=null;
		try{
			cl=Thread.currentThread().getContextClassLoader();
		}catch(Throwable e ){
			
		}
		if(cl==null){
			cl=ClassUtils.class.getClassLoader();
			
			if(cl==null){
				try{
					cl=ClassLoader.getSystemClassLoader();
				}
				catch(Throwable e ){
					
				}
			}
		}
		return cl;
	}
}

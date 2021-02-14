package com.example.demo;

import java.util.Properties;

import javax.annotation.Resource;

public class MyTest {
	

	@Resource(name="utilProp")
	private Properties  prop;

	@Resource(name="utilPropEnv")
	private Properties  propEnv;	
	
	public void init() {
		
		System.out.println("\nPropertie normal\n");
		System.out.println("var one = "+prop.getProperty("com.something.one"));
		System.out.println("var two = "+prop.getProperty("com.something.two"));
		System.out.println("var url = "+prop.getProperty("com.something.url"));
		
		
		System.out.println("\nPropertie con Env:\n");
		System.out.println("var one = "+propEnv.getProperty("com.something.one"));
		System.out.println("var two = "+propEnv.getProperty("com.something.two"));
		System.out.println("var url = "+propEnv.getProperty("com.something.url"));
		
		
		System.out.println("\n\n");
	}

}

package com.example.demo;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.PropertiesFactoryBean;


/**
 * Clase que sobre escribe la creacion de propiedades de PropertiesFactoryBean para ser sensible a variables de ambiente
 * @author Juan Villablanca
 *
 */
public class MyPropertiesFactoryBean extends PropertiesFactoryBean {

	private  static Pattern p = Pattern.compile("\\$\\{([^\\}]+)\\}");

	/**
	 *Esta metodo rescata las propiedades que se leyeron, las examina una a una y 
	 *si encuentra una variable de ambiente la reemplazara por el valor de la
	 *variable de ambiente. 
	 */
	@Override
	protected Properties createProperties() throws IOException {
		Properties props = mergeProperties();
		Set<String> keys = props.stringPropertyNames();
		for (String key : keys) {
			String valor =  props.getProperty(key);
			Matcher m = p.matcher(valor); 
			if(m.find()) {
				m.reset();
				StringBuffer sb = new StringBuffer();
				while(m.find()){
					String envVarName = m.group(1);
					String envVarValue = System.getenv(envVarName);
					m.appendReplacement(sb, envVarValue == null ? "[EnvVarNotFound("+envVarName+")]" : envVarValue);
				}
				m.appendTail(sb);
				props.setProperty(key,sb.toString());
			}
		}
		return props;
	}
}

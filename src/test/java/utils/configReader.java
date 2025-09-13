package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	   private Properties prop; 
	   
	    public configReader() { 
	        prop = new Properties(); 
	        try { 
	            FileInputStream fis = new FileInputStream("src/test/resources/config.properties"); 
	            prop.load(fis); 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	    } 
	 
	    public String getProperty(String key) { 
	        return prop.getProperty(key); 
	    } 

}

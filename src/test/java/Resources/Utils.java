package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.junit.runner.Request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification Request; 
	public RequestSpecification RequestSpec() throws IOException
	{
		
		
		if (Request==null) 
		{
			
	PrintStream	Log=new PrintStream(new FileOutputStream("Logs.file"));
		 Request=new RequestSpecBuilder().
				addFilter(RequestLoggingFilter.logRequestTo(Log)).
				addFilter(ResponseLoggingFilter.logResponseTo(Log)).setBaseUri(GlobalValue("BaseURL"))
				.setContentType(ContentType.JSON).addQueryParam("key","qaclick123").build();
		 return Request;
		}
		return Request;
	}
	public static  String GlobalValue(String Key) throws IOException
	{
	Properties	Prop=new Properties();
    FileInputStream File=new FileInputStream("C:\\Users\\Ashok\\maven_restapi\\src\\test\\java\\Resources\\URI.properties");
    Prop.load(File);
    System.out.println(Prop);
    return Prop.getProperty(Key);
 
    
    
    
	}

}

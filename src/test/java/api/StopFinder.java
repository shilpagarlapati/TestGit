package api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class StopFinder extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	@Test
	public void responseCode(){
		
	Response res=RestAssured.get("https://www.transportnsw.info/web/XML_STOPFINDER_REQUEST?TfNSWSF=true&language=en%20&name_sf=Wynyard%20Station,%20Sydney%E2%80%8B&outputFormat=rapidJSON&type_sf=any&version=10.2.2.48");
	
	int code=res.getStatusCode();
	log.info("response code is "+code );
	
	Assert.assertEquals(code, 200);
	}
	@Test
	public void testBody(){
		
	Response res=RestAssured.get("https://www.transportnsw.info/web/XML_STOPFINDER_REQUEST?TfNSWSF=true&language=en%20&name_sf=Wynyard%20Station,%20Sydney%E2%80%8B&outputFormat=rapidJSON&type_sf=any&version=10.2.2.48");

		String data=res.asString();
		 
		log.info(data);
		//System.out.println(data);
		
		log.info(res.getTime());
		
		
		
	}
	

}

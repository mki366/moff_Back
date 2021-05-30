package bit.com.a;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


public class ExampleSend {
	
	 public static void main(String[] args) {
		    String api_key = "NCSMB43IVVGNNBJP";
		    String api_secret = "JADFQOASE9YHKJO7ZLWGUELS8C8DDBAL";
		    Message coolsms = new Message(api_key, api_secret);

		    // 4 params(to, from, type, text) are mandatory. must be filled
		    HashMap<String, String> params = new HashMap<String, String>();
		    params.put("to", "010-2888-3498");
		    params.put("from", "010-2888-3498");
		    params.put("type", "LMS");
		    params.put("text", "나의 첫번째 메시지 전송  짜증");
		    params.put("app_version", "test app 1.2"); // application name and version

		    try {
		      JSONObject obj = (JSONObject) coolsms.send(params);
		      System.out.println(obj.toString());
		    } catch (CoolsmsException e) {
		      System.out.println(e.getMessage());
		      System.out.println(e.getCode());
		    }
		  }
}

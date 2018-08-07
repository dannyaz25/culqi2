package src.main.java.com.culqi.test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RestClient {

    private final String server = "https://lookup.binlist.net/";
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public RestClient() {
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    public  void getResultAPI(String bin) {
        String result = restTemplate.getForObject(server+bin, String.class);
        System.out.println(result);
        String test =  JSONObject.escape(result);
        System.out.println(test);
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(test);
            System.out.println(json);
            String x = (String) json.get("number");
            System.out.println("number" + x);
        }catch (ParseException ex){
            ex.printStackTrace();

        }
       // return result;
    }
}
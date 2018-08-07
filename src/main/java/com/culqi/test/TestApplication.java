package com.culqi.test;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import com.culqi.model.Tarjeta;
import src.main.java.com.culqi.test.RestClient;
import org.springframework.http.*;
import org.springframework.web.client.*;
import org.springframework.beans.factory.annotation.*;


@RestController
@EnableAutoConfiguration
public class TestApplication {

	RestClient restClient=new RestClient();
	@RequestMapping(value = "/tokens", method = RequestMethod.POST)
	public ResponseEntity<Tarjeta> update(@RequestBody Tarjeta tarjeta) {

        String bin=tarjeta.getPan();
        bin.substring(0,6);
		restClient.getResultAPI(bin);

		return new ResponseEntity<Tarjeta>(tarjeta, HttpStatus.OK);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestApplication.class, args);
	}

}
package com.sample.rest.client.controller;

import java.util.List;

//import org.dozer.Mapper;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Observed(name = "RestClientController")
@RestController
@RequestMapping("/restClient")
public class RestClientController {

    @Value("${rest-server}")
    String restServer;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;

    @RequestMapping("/city")
    @ResponseBody
    public List rest() {

//        WebClient client = WebClient.create(restServer);

//	    HttpClient httpClient = HttpClient.create()
//	            .tcpConfiguration(client ->
//	                    client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
//	                    .doOnConnected(conn -> conn
//	                            .addHandlerLast(new ReadTimeoutHandler(10))
//	                            .addHandlerLast(new WriteTimeoutHandler(10))));
//	     
//	    ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);     
//	 
//	    return WebClient.builder()
//	            .baseUrl("http://localhost:3000")
//	            .clientConnector(connector)
//	            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//	            .build();


//        UserInfo ui = new UserInfo();
//        ui.setName("Tom");
//        ui.setAddress("Tokyo yokohama japan");
//        ui.setId("00000012");
//        ui.setSex("male");
//        ui.setTel("090-3902-81444");
        List result = webClient.get().uri(restServer +"/restServer/showCities").retrieve()
                .bodyToMono(List.class).block();
        return result;


//        ResponseEntity<List> result = restTemplate.getForEntity(restServer + "/restServer/showCities", List.class);
//        return result.getBody();

    }

}

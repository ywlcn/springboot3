package com.boot.opentelemetry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("service")
public class ManualController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManualController.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/path1")
    public ResponseEntity<String> path1() {
        LOGGER.info("Incoming request at {} for request /paht1", applicationName);
        ResponseEntity<String> rep = restTemplate.getForEntity("http://localhost:8082/service/path2", String.class);
        return rep;
    }

    @GetMapping(path = "/path2")
    public ResponseEntity<String> path2() {
        return ResponseEntity.ok("response from path2");
    }

}

package com.accenture.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/simple")
    public String helloFromClientSimple() {
        return "Hello from client";
    }

    @GetMapping("/client")
    public List<String> client() {
        return discoveryClient.getServices();
    }

    @GetMapping("/")
    public String helloFromClient() {
        return "Hello from client " + restTemplate.getForObject("http://service:8080/", String.class);
    }
}

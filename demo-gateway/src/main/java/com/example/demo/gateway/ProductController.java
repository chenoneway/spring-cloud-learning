package com.example.demo.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
@RefreshScope
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${test:0}")
    private String test;

    @RequestMapping(value = "/get/{string}", method = RequestMethod.GET)
    public String get(@PathVariable String string) {
        return restTemplate.getForObject("http://demo-product-service/product/get/" + string, String.class) + test;
    }
}

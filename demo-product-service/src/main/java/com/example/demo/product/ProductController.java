package com.example.demo.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @RequestMapping(value = "/get/{string}", method = RequestMethod.GET)
    public String get(@PathVariable String string) {
        return "good product:" + string;
    }
}

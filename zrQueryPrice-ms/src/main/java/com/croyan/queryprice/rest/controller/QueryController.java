package com.croyan.queryprice.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("query")
public class QueryController {

    @GetMapping(produces = "application/json")
    public String getPrice() {
        return "test";
    }

}

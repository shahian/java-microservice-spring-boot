package com.shahian.mscustomer.controller;

import com.shahian.mscustomer.model.Address;
import com.shahian.mscustomer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RequestOrderController {

    private final RestTemplate restTemplate;

    @Autowired
    public RequestOrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping(value = "/v1/requestOrderByCustomerId")
    public ResponseEntity<?> findByCustomerId(@RequestParam Long id) {
        String url = "http://localhost:8082//ms-order/api/v1/orderByCustomerId?customerId={customerId}";
        Map<String, String> params = new HashMap<>();
        params.put("customerId", "123");
        String response=restTemplate.getForObject(url,String.class,params);
        if (response == null) {
            throw new NullPointerException("response is  empty");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }





}

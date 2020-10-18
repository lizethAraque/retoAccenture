package com.co.reto.service.impl;

import com.co.reto.repository.IServiceRetoIntegration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RetoService implements IServiceRetoIntegration {
    @Override
    public String getData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://testbankapi.firebaseio.com/products.json", String.class);
    }
}

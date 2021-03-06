package com.co.reto.service.impl;

import com.co.reto.model.CategoryModel;
import com.co.reto.model.StateModel;
import com.co.reto.model.SumProductsModel;
import com.co.reto.repository.IServiceRetoIntegration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RetoService implements IServiceRetoIntegration {
    @Override
    public String getData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://testbankapi.firebaseio.com/products.json", String.class);
    }

    @Override
    public String deleteData(CategoryModel categoryModel) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CategoryModel> entity = new HttpEntity<CategoryModel>(categoryModel, headers);
        restTemplate.delete( "https://testbankapi.firebaseio.com/products/-Lh7-wuYbP7AwpipuxNx.json", entity);
        return objectMapper.writeValueAsString(new StateModel(true));
    }


    @Override
    public String putData(CategoryModel[] categoryModel) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CategoryModel[]> entity = new HttpEntity<CategoryModel[]>(categoryModel, headers);
        restTemplate.put( "https://testbankapi.firebaseio.com/products/-Lh7-wuYbP7AwpipuxNx.json", entity);
        return objectMapper.writeValueAsString(new StateModel(true));


    }

    @Override
    public String getTotal() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CategoryModel[]> result = restTemplate.getForEntity("https://testbankapi.firebaseio.com/products/-Lh7-wuYbP7AwpipuxNx.json", CategoryModel[].class );
        List <CategoryModel>  categoryModels = Arrays.asList(result.getBody());
        int count=0;
        for (CategoryModel sum: categoryModels) {
            count = sum.getValue() + count;

        }
        return objectMapper.writeValueAsString(new SumProductsModel(count));

    }



}

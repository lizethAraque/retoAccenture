package com.co.reto.repository;

import com.co.reto.model.CategoryModel;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IServiceRetoIntegration {

    public String getData();
    public String deleteData();
    public String putData(CategoryModel[] categoryModel) throws JsonProcessingException;
}

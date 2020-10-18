package com.co.reto.controller.impl;

import com.co.reto.model.CategoryModel;
import com.co.reto.service.impl.RetoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/reto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})


public class RetoController {

    @Autowired
    RetoService servicio;

    @ApiOperation(value = "/get/Data")
    @RequestMapping(value = "/get/Data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getInformationGET() {

        try {
            return new ResponseEntity<String>(servicio.getData(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Se presentaron problemas tecnicos  para  obtener los datos", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "/post/Data")
    @RequestMapping(value = "/post/Data", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getInformationPOST() {
        try {
            return new ResponseEntity<String>(servicio.getData(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Se presentaron problemas tecnicos  para  obtener los datos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "/put/Data")
    @PutMapping(value = "/put/Data", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> putInformation(@RequestBody CategoryModel[] categoryModel) {

        try {
            return new ResponseEntity<String>(servicio.putData(categoryModel), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Se presentaron problemas tecnicos  para  insertar los datos", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}


package com.ifelseco.stock.controller;

import com.ifelseco.stock.entity.Product;
import com.ifelseco.stock.entity.Stock;
import com.ifelseco.stock.model.BaseResponseModel;
import com.ifelseco.stock.model.ProductStockModel;
import com.ifelseco.stock.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController implements StockOperations {

    private StockService stockService;
    private final ModelMapper modelMapper;

    public StockController(StockService stockService, ModelMapper modelMapper) {
        this.stockService = stockService;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseEntity<?> getStock(String productId) {
        BaseResponseModel baseResponseModel = new BaseResponseModel();
        ProductStockModel productStockModel = stockService.getStock(productId);
        if (productStockModel != null) {
            baseResponseModel.setCode(200);
            baseResponseModel.setMessage("Success");
            productStockModel.setBaseResponseModel(baseResponseModel);
            return new ResponseEntity<>(productStockModel, HttpStatus.OK);
        } else {
            baseResponseModel.setCode(400);
            baseResponseModel.setMessage("Bad Request");
            productStockModel.setBaseResponseModel(baseResponseModel);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}

package com.ifelseco.stockapi.controller;

import com.ifelseco.stockapi.entity.Stock;
import com.ifelseco.stockapi.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock-api")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{productId}")
    ResponseEntity<Stock> getProductStock(@PathVariable String productId){
        Stock stock=stockService.getProductStock(productId);
        if(stock!=null) {
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

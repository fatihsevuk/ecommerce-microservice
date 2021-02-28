package com.ifelseco.stock.service.impl;


import com.ifelseco.stock.entity.Stock;
import com.ifelseco.stock.model.ProductStockModel;
import com.ifelseco.stock.repository.StockRepository;
import com.ifelseco.stock.service.StockService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;
    private RestTemplate restTemplate;

    public StockServiceImpl(StockRepository stockRepository, RestTemplate restTemplate) {
        this.stockRepository = stockRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductStockModel getStock(String productId) {
        ProductStockModel productStockModel=restTemplate.getForObject("http://stock-api:8080/stock-api/"+productId,ProductStockModel.class);
        return productStockModel;
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock findByStockId(Long id) {
        return stockRepository.findById(id).orElse(null);
    }


}

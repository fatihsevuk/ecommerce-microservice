package com.ifelseco.stockapi.service.impl;

import com.ifelseco.stockapi.entity.Stock;
import com.ifelseco.stockapi.repository.StockRepository;
import com.ifelseco.stockapi.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    @Override
    public Stock getProductStock(String productId) {
        return stockRepository.findByProductId(productId);
    }
}

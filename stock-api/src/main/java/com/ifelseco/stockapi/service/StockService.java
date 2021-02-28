package com.ifelseco.stockapi.service;

import com.ifelseco.stockapi.entity.Stock;

public interface StockService {
    Stock getProductStock(String productId);
}

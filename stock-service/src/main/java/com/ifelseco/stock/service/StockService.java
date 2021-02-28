package com.ifelseco.stock.service;

import com.ifelseco.stock.entity.Stock;
import com.ifelseco.stock.model.ProductStockModel;

public interface StockService {
    ProductStockModel getStock(String productId);
    Stock save(Stock stock);
    Stock findByStockId(Long id);
}

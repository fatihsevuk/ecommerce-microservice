package com.ifelseco.stockapi.repository;

import com.ifelseco.stockapi.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRepository extends CrudRepository<Stock,Long> {

    Stock findByProductId(String productId);
}

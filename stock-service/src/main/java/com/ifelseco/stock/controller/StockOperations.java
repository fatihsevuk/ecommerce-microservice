package com.ifelseco.stock.controller;

import com.ifelseco.stock.entity.Stock;
import com.ifelseco.stock.model.ProductStockModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/stock")
@Api("/api/stock")
public interface StockOperations {


    @GetMapping("/{productId}")
    @ApiOperation(value = "Get Stock", notes = "Get actual product stock info",response = ProductStockModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Stock info successfully fetched", response = ProductStockModel.class),
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Unauthorized access, please sign-in again"),
            @ApiResponse(code = 403, message = "Forbidden access, you cannot access this info"),
            @ApiResponse(code = 404, message = "We don't have info you want "),
            @ApiResponse(code = 500, message = "Ops. Something went wrong!"),
            @ApiResponse(code = 501, message = "Ops. We do not have this feature yet!"),
            @ApiResponse(code = 503, message = "Ops. This service is temporarily unavailable, try again later!"),

    })
    ResponseEntity<?> getStock(@ApiParam(required = true, name = "productId", value = "Retrieving product id")
            @PathVariable String productId);




}

package com.ifelseco.cart.controller;

import com.ifelseco.cart.model.CartModel;
import com.ifelseco.cart.model.CartItemModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cart")
@Api("/api/cart")
public interface CartOperations {


    @GetMapping
    @ApiOperation(value = "Get Cart", notes = "Get actual cart info",response = CartModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cart info successfully fetched", response = CartModel.class),
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Unauthorized access, please sign-in again"),
            @ApiResponse(code = 403, message = "Forbidden access, you cannot access this info"),
            @ApiResponse(code = 404, message = "We don't have info you want "),
            @ApiResponse(code = 500, message = "Ops. Something went wrong!"),
            @ApiResponse(code = 501, message = "Ops. We do not have this feature yet!"),
            @ApiResponse(code = 503, message = "Ops. This service is temporarily unavailable, try again later!"),

    })
    CartModel getCart();

    @PostMapping("/items")
    @ApiOperation(value = "Add To Cart", notes = "Add item to cart",response = CartModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Item added to cart successfully", response = CartModel.class),
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Unauthorized access, please sign-in again"),
            @ApiResponse(code = 403, message = "Forbidden access, you cannot access this info"),
            @ApiResponse(code = 404, message = "We don't have info you want "),
            @ApiResponse(code = 500, message = "Ops. Something went wrong!"),
            @ApiResponse(code = 501, message = "Ops. We do not have this feature yet!"),
            @ApiResponse(code = 503, message = "Ops. This service is temporarily unavailable, try again later!"),

    })
    ResponseEntity<?> addItemToCart(@ApiParam(required = true, name = "item", value = "Item to add to cart")
                            @RequestBody CartItemModel item);

    @DeleteMapping("/items/{itemId}")
    @ApiOperation(value = "Delete Item", notes = "Delete item by id from cart")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Item deleted succesfully"),
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Unauthorized access, please sign-in again"),
            @ApiResponse(code = 403, message = "Forbidden access, you cannot access this info"),
            @ApiResponse(code = 404, message = "We don't have info you want "),
            @ApiResponse(code = 500, message = "Ops. Something went wrong!"),
            @ApiResponse(code = 501, message = "Ops. We do not have this feature yet!"),
            @ApiResponse(code = 503, message = "Ops. This service is temporarily unavailable, try again later!"),

    })
    void deleteItem(@ApiParam(required = true, name = "itemId", value = "ItemId to be deleted")
                              @PathVariable("itemId") String id);


    @PatchMapping("/items")
    @ApiOperation(value = "Update Cart", notes = "Update item in cart",response = CartModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cart successfully updated", response = CartModel.class),
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Unauthorized access, please sign-in again"),
            @ApiResponse(code = 403, message = "Forbidden access, you cannot access this info"),
            @ApiResponse(code = 404, message = "We don't have info you want "),
            @ApiResponse(code = 500, message = "Ops. Something went wrong!"),
            @ApiResponse(code = 501, message = "Ops. We do not have this feature yet!"),
            @ApiResponse(code = 503, message = "Ops. This service is temporarily unavailable, try again later!"),

    })
    CartModel updateCart(@RequestBody CartModel cartModel);


}

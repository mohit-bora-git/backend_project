package com.jecrc.cheggbookmanagement.service;


import com.jecrc.cheggbookmanagement.model.entities.Orders;
import com.jecrc.cheggbookmanagement.model.requests.CreateOrderRequestDto;
import com.jecrc.cheggbookmanagement.model.requests.UpdateOrderRequestDto;



public interface OrderService {

    Orders placeOrder(Integer userId,Integer bookId);

    Orders returnOrder(Integer userId,Integer bookId);
}

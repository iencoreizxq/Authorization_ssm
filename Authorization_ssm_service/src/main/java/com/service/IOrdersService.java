package com.service;

import com.domain.Orders;

import java.util.List;

public interface IOrdersService {

    public List<Orders> findAll(int page,int size) throws Exception;
}

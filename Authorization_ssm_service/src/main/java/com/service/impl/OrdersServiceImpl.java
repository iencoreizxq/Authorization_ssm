package com.service.impl;

import com.dao.IOrdersDao;
import com.domain.Orders;
import com.github.pagehelper.PageHelper;
import com.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //参数pagenum是页码值，参数pagesize代表是每页显示条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }
}

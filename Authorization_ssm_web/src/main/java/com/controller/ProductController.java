package com.controller;


import com.domain.Product;
import com.service.IProductService;
import com.utils.DateStringEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new DateStringEditor());
    }
    /**
     * 查询全部
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list1");
        return mv;
    }

    /**
     * 产品添加
     */
    @RequestMapping("/save")
    public String saveProduct(Product product) throws  Exception{
        productService.saveProduct(product);
        return "redirect:findAll";
    }
}

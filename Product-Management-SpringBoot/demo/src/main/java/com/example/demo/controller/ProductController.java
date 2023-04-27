package com.example.demo.controller;


import com.example.demo.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.service.ProductService;

import java.util.Date;
import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value={"/","/products"})
    public String getProducts(Model model) {
        List<ProductEntity> productEntityList = productService.getProducts();
        if(productEntityList.size() == 0){
            ProductEntity entity = new ProductEntity();
            entity.setName("Java Book");
            entity.setDescription("Java A-Z");
            entity.setCreateAt(new Date());
            entity.setPrice(189);
            productEntityList.add(entity);
        }
        model.addAttribute("products", productEntityList);
        return "product";
    }

}

package com.example.Demo.Service.Products;

import com.example.Demo.Modal.Products;
import com.example.Demo.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ProductsServiceIml implements ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceIml(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    @Override
    public Products addProduct(Products products) {
        try{
            if(!products.getName_product().isEmpty() && !products.getDescription().isEmpty() && products.getPrice() > 0){
                //return productsRepository.save(products);
                  return productsRepository.createProduct(products.getName_product(), products.getDescription(), products.getPrice());
            } else {
                return  null;
            }
        } catch(DataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateProduct(Products products){
        productsRepository.updateProduct(products.getName_product(), products.getDescription(), products.getPrice(), products.getId());
    }

    @Override
    public void deleteProduct(long id) {
        //productsRepository.deleteById(id);
        productsRepository.deleteProduct(id);
    }
}

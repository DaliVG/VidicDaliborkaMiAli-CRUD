package es.cifpcm.vidicdaliborkamiali.web;

import es.cifpcm.vidicdaliborkamiali.dao.ProductsRepository;
import es.cifpcm.vidicdaliborkamiali.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    static
    ProductsRepository productsRepository;

    public static List<Products> findAll() {
        return productsRepository.findAll();
    }

    public static Optional<Products> findById(int id) {
        return productsRepository.findById(id);
    }

    public static Products saveProduct(Products product) {
        return productsRepository.save(product);
    }

    public static Products updatedProduct(int id, Products product) {
        Products updatedProduct = productsRepository.findById(id).orElse(null);
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setProductPicture(product.getProductPicture());
        updatedProduct.setProductStock(product.getProductStock());
        updatedProduct.setProductPrice(product.getProductPrice());
        return productsRepository.save(updatedProduct);
    }
    public static void deleteById(int id) {
        productsRepository.deleteById(id);
    }
}

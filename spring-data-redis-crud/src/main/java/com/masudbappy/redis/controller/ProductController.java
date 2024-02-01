package com.masudbappy.redis.controller;

import com.masudbappy.redis.entity.Product;
import com.masudbappy.redis.repository.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductDao dao;

    @Autowired
    public ProductController(ProductDao dao) {
        this.dao = dao;
    }

    /**
     * Save product.
     *
     * @param product the product
     * @return the product
     */
    @PostMapping
    public Product save(@RequestBody Product product) {
        return dao.save(product);
    }

    /**
     * Gets all products.
     *
     * @return the all products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    /**
     * Find product product.
     *
     * @param id the id
     * @return the product
     */
    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return dao.findProductById(id);
    }

    /**
     * Remove string.
     *
     * @param id the id
     * @return the string
     */
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return dao.deleteProduct(id);
    }
}

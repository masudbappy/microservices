package com.masudbappy.redis.repository.dao;

import com.masudbappy.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Product dao.
 */
@Repository
public class ProductDao {

    /**
     * The constant HASH_KEY.
     */
    public static final String HASH_KEY = "Product";

    private final RedisTemplate template;
    @Autowired
    public ProductDao(RedisTemplate template) {
        this.template = template;
    }

    /**
     * Save product.
     *
     * @param product the product
     * @return the product
     */
    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    /**
     * Find product by id product.
     *
     * @param id the id
     * @return the product
     */
    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }


    /**
     * Delete product string.
     *
     * @param id the id
     * @return the string
     */
    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}

package ra.jpa.model.service;

import ra.jpa.model.entity.Category;
import ra.jpa.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product saveOrUpdate(Product product);
    Product findById(Long id);
    void delete(Long id);
}

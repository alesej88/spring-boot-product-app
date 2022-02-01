package service;

import dto.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {
private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAll(){
return productRepository.getAll();
    }
public void save(Product product){
productRepository.save(product);
}
public Product findById(Integer id){
       return productRepository.FindById(id);
}
}

package repository;

import dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList;
@PostConstruct
public void init(){
productList = new ArrayList<>();
productList.add(new Product(1,"Картофель", 5 ));
productList.add(new Product(2,"Томаты", 10));
productList.add(new Product(3, "Яблоки", 2));
}

    public List<Product> getAll() {
        return List.copyOf(productList);
    }
    public void save(Product product){
    productList.add(product);
    }
    public Product FindById(int id){
return productList.stream().filter(product -> product.getId() ==id).findFirst().orElse(null);
    }
}

package controller;

import dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
// MVC
// http://localhost:8080/app/all GET//

    @GetMapping("/all")
    public String getAllProduct(Model model) {
        model.addAttribute("products", productService.getAll());
        return "product_list";
    }

    // http://localhost:8080/app/info/3 GET
    @GetMapping("/info/{id}")
    public String getProductInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("student", productService.findById(id));
        return "product_info";
    }
// http://localhost:8080/app/add GET
@GetMapping("/add")
public String getProductAddFrom() {
    return "product_form";
}
}
    // http://localhost:8080/app/add POST
    @PostMapping("/add")
    public String saveProduct(@RequestParam Integer id,
                              @RequestParam String name,
                              @RequestParam Float weight) {
        productService.save(new Product(id, name, weight));
        return "redirect:all";
    }
}
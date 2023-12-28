package ra.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.jpa.model.entity.Category;
import ra.jpa.model.entity.Product;
import ra.jpa.model.service.CategoryService;
import ra.jpa.model.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public String home(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/home";
    }

    @GetMapping("/create-product")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/add";
    }

    @PostMapping("/add-product")
    public String add(@ModelAttribute("product") Product product) {
        if (productService.saveOrUpdate(product) != null) {
            return "redirect:/product";
        }
        return "redirect:/add-product";
    }

    @GetMapping("/delete-product/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/edit-product/{id}")
    public String edit(@PathVariable("id") Product product, Model model) {
//        Product product = productService.findById(id);
        model.addAttribute("product", product);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/edit";
    }

    @PostMapping("/update-product")
    public String update(@ModelAttribute("product") Product product) {
        if (productService.saveOrUpdate(product) != null) {
            return "redirect:/product";
        }
        return "redirect:/edit-product";
    }
}

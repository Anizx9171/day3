package ra.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.jpa.model.entity.Category;
import ra.jpa.model.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String category(Model model){
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/home";
    }

    @GetMapping("create-category")
    public String create(Model model){
        Category category=new Category();
        model.addAttribute("category",category);
        return "category/add";
    }
    @PostMapping("/add-category")
    public String add(@ModelAttribute("category") Category category){
        if(categoryService.saveOrUpdate(category)!=null){
            return "redirect:/category";
        }
        return "redirect:/create-category";
    }

    @GetMapping("/delete-category/{id}")
    public String delete(@PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/category";
    }

    @GetMapping("/edit-category/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        Category category=categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }

    @PostMapping("/update-category")
    public String update(@ModelAttribute("category") Category category){
        if(categoryService.saveOrUpdate(category)!=null){
            return "redirect:/category";
        }
        return "redirect:/edit-category/";
    }
}

package mk.ukim.finki.wpproject.web.controller;

import mk.ukim.finki.wpproject.model.Category;
import mk.ukim.finki.wpproject.model.Product;
import mk.ukim.finki.wpproject.service.CategoryService;
import mk.ukim.finki.wpproject.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;
    private final CategoryService categoryService;


    public ProductsController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;

    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error,
                                 @RequestParam Long categoryId,
                                 Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        if (this.categoryService.findById(categoryId).isPresent()) {

            List<Product> products = this.productService.findAllByCategory(categoryId);
            model.addAttribute("products", products);
        }

        //List<Product> products = this.productService.findAll();
        //model.addAttribute("products", products);
        //model.addAttribute("bodyContent", "products");

        return "products";
    }

}


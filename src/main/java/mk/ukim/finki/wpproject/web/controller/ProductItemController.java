package mk.ukim.finki.wpproject.web.controller;

import mk.ukim.finki.wpproject.model.Category;
import mk.ukim.finki.wpproject.model.Product;
import mk.ukim.finki.wpproject.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wpproject.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/productItem")
public class ProductItemController {

    private final ProductService productService;


    public ProductItemController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public String getProductById(@RequestParam(required = false) String error,
                                 @RequestParam Long productId,
                                 Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

       Product product = this.productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        model.addAttribute("product", product);


        return "item";
    }
}

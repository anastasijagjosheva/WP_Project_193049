package mk.ukim.finki.wpproject.web.controller;

import mk.ukim.finki.wpproject.model.Product;
import mk.ukim.finki.wpproject.model.ShoppingCart;
import mk.ukim.finki.wpproject.model.User;
import mk.ukim.finki.wpproject.service.ShoppingCartService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model){

        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        //User user = (User) req.getSession().getAttribute("user");
        String username =  req.getRemoteUser();
        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(username);
        model.addAttribute("productsInShoppingCart", shoppingCartService.listAllProductsInShoppingCart(shoppingCart.getId()));

        return "shopping-cart";

    }

    @PostMapping("/add-product")
    public String addProductToShoppingCart(@RequestParam Long productId, HttpServletRequest req, Authentication authentication){
        try{
            //User user = (User) req.getSession().getAttribute("user");
            //String username = (String) req.getRemoteUser();
            User user = (User) authentication.getPrincipal();

            this.shoppingCartService.addProductToShoppingCart(user.getUsername(), productId);
            return "redirect:/shopping-cart";

        }catch (RuntimeException exception){
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }


    @PostMapping("/remove-product")
    public String removeProductFromShoppingCart(@RequestParam Long productId,Authentication authentication){
        try{

            User user = (User) authentication.getPrincipal();

            this.shoppingCartService.removeProductFromShoppingCart(user.getUsername(), productId);
            return "redirect:/shopping-cart";

        }catch (RuntimeException exception){
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }

}
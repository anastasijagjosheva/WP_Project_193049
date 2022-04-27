package mk.ukim.finki.wpproject.service;

import mk.ukim.finki.wpproject.model.Product;
import mk.ukim.finki.wpproject.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);

    ShoppingCart removeProductFromShoppingCart(String username, Long productId);
}

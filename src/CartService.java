package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private final List<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
    }

    public List<Product> getCartItems() {
        return new ArrayList<>(cart);
    }

    public void clearCart() {
        cart.clear();
    }
}

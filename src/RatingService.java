package service;

import model.Product;

public class RatingService {
    public void rateProduct(Product product, double rating) {
        product.setRating(rating);
    }
}


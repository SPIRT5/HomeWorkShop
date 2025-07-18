package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
    Product getById(int id);
    List<Product> searchByKeyword(String keyword);
    List<Product> getTopRated(int count);
}

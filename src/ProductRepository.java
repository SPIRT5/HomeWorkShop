package repository;

import model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductRepository implements IProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Ноутбук", "Dell", 1200));
        products.add(new Product(2, "Смартфон", "Apple", 999));
        products.add(new Product(3, "Наушники", "Sony", 199));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Product> searchByKeyword(String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getTopRated(int count) {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getRating).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }
}

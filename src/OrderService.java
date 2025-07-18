package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<List<Product>> orderHistory = new ArrayList<>();
    private final List<String> statuses = new ArrayList<>();

    public void placeOrder(List<Product> items) {
        orderHistory.add(new ArrayList<>(items));
        statuses.add("В пути");
    }

    public List<List<Product>> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }

    public String trackOrder(int orderIndex) {
        if (orderIndex >= 1 && orderIndex <= statuses.size()) {
            return statuses.get(orderIndex - 1);
        }
        return "Не найден";
    }

    public boolean returnOrder(int orderIndex) {
        if (orderIndex >= 1 && orderIndex <= statuses.size()) {
            statuses.set(orderIndex - 1, "Возвращен");
            return true;
        }
        return false;
    }

    public boolean repeatLastOrder() {
        if (orderHistory.isEmpty()) return false;
        List<Product> last = orderHistory.get(orderHistory.size() - 1);
        placeOrder(last);
        return true;
    }
}
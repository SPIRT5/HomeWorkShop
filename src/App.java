import repository.IProductRepository;
import model.Product;
import repository.ProductRepository;
import service.CartService;
import service.OrderService;
import service.RatingService;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IProductRepository productRepo = new ProductRepository();
    private static final CartService cartService = new CartService();
    private static final OrderService orderService = new OrderService();
    private static final RatingService ratingService = new RatingService();
    private static final int RECOMMENDATION_LIMIT = 3;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showAllProducts();
                case "2" -> searchProducts();
                case "3" -> addToCart();
                case "4" -> showCart();
                case "5" -> placeOrder();
                case "6" -> showOrderHistory();
                case "7" -> trackOrder();
                case "8" -> returnOrder();
                case "9" -> repeatLastOrder();
                case "10" -> rateProduct();
                case "11" -> showRecommendations();
                case "0" -> running = false;
                default -> System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Показать все товары");
        System.out.println("2. Поиск товаров по ключевому слову");
        System.out.println("3. Добавить товар в корзину");
        System.out.println("4. Показать корзину");
        System.out.println("5. Оформить заказ");
        System.out.println("6. История заказов");
        System.out.println("7. Отследить заказ");
        System.out.println("8. Вернуть заказ");
        System.out.println("9. Повторить последний заказ");
        System.out.println("10. Оценить товар");
        System.out.println("11. Рекомендации по товарам");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void showAllProducts() {
        printProductList(productRepo.getAllProducts());
    }

    private static void searchProducts() {
        System.out.print("Введите ключевое слово: ");
        String keyword = scanner.nextLine();
        List<Product> results = productRepo.searchByKeyword(keyword);
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            printProductList(results);
        }
    }

    private static void addToCart() {
        int id = readIntInput("Введите ID товара: ");
        Product product = productRepo.getById(id);
        if (product != null) {
            cartService.addToCart(product);
            System.out.println("Товар добавлен в корзину.");
        } else {
            System.out.println("Товар не найден.");
        }
    }

    private static void showCart() {
        List<Product> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            printProductList(cartItems);
        }
    }

    private static void placeOrder() {
        List<Product> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        orderService.placeOrder(cartItems);
        cartService.clearCart();
        System.out.println("Заказ оформлен!");
    }

    private static void showOrderHistory() {
        if (orderService.getOrderHistory().isEmpty()) {
            System.out.println("История заказов пуста.");
        } else {
            orderService.getOrderHistory().forEach(System.out::println);
        }
    }

    private static void trackOrder() {
        int orderId = readIntInput("Введите номер заказа: ");
        String status = orderService.trackOrder(orderId);
        System.out.println("Статус заказа: " + status);
    }

    private static void returnOrder() {
        int orderId = readIntInput("Введите номер заказа для возврата: ");
        boolean success = orderService.returnOrder(orderId);
        System.out.println(success ? "Заказ возвращён." : "Невозможно вернуть заказ.");
    }

    private static void repeatLastOrder() {
        boolean success = orderService.repeatLastOrder();
        System.out.println(success ? "Последний заказ повторён." : "Нет предыдущих заказов для повторения.");
    }

    private static void rateProduct() {
        int id = readIntInput("Введите ID товара для оценки: ");
        Product product = productRepo.getById(id);
        if (product != null) {
            System.out.print("Введите рейтинг (0.0 - 5.0): ");
            double rating = Double.parseDouble(scanner.nextLine());
            ratingService.rateProduct(product, rating);
            System.out.println("Спасибо за вашу оценку!");
        } else {
            System.out.println("Товар не найден.");
        }
    }

    private static void showRecommendations() {
        System.out.println("Рекомендуемые товары:");
        printProductList(productRepo.getTopRated(RECOMMENDATION_LIMIT));
    }

    private static void printProductList(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("Список товаров пуст.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static int readIntInput(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }
}
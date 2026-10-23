package service;

import model.LoyaltyLevel;
import model.Order;
import model.Product;
import model.User;
import repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {
    // Внедряем универсальные дженерик-репозитории через интерфейсы!
    private final CrudRepository<User, Integer> userRepository;
    private final CrudRepository<Product, Integer> productRepository;
    private final CrudRepository<Order, Integer> orderRepository;

    // Чистый Dependency Injection (DI) через конструктор
    public OrderService(CrudRepository<User, Integer> userRepository,
                        CrudRepository<Product, Integer> productRepository,
                        CrudRepository<Order, Integer> orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    // 🌊 МЕТОД СО СТРИМОМ: Расчет стоимости заказа с учетом скидки лояльности
    public double calculateFinalAmount(User user, List<Product> products) {
        // 1. Считаем чистую сумму всех товаров в списке с помощью Stream API
        double totalAmount = products.stream()
                .mapToDouble(product -> product.getPrice()) // Превращаем поток товаров в поток их цен
                .sum(); // Суммируем всё автоматически!

        // 2. Вытаскиваем процент скидки из нашего Enum лояльности юзера
        double discountPercent = user.getLoyaltyLevel().getDiscount();

        // 3. Возвращаем итоговую цену за вычетом скидки
        return totalAmount * (1.0 - discountPercent);
    }
}

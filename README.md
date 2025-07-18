# HomeWorkShop

Принцип избегания магических чисел
Константа RECOMMENDATION_LIMIT = 3:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/App.java#L16

Принцип DRY
Метод printProductList:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/App.java#L148-L156

Метод readIntInput:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/App.java#L158-L162
Избавились от дублирующегося кода при поиске, просмотре всех товаров и при рекомендациях.

Принцип S (Single Responsibility) Принцип единственной ответственности 
CartService (отвечает только за корзину):
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/service/CartService.java

RatingService (отвечает только за рейтинг):
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/service/RatingService.java

Принцип O (Open/Closed) + I (Interface Segregation) + D (Dependency Inversion) Принцип открытости/закрытости
Интерфейс IProductRepository:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/repository/IProductRepository.java

Реализация ProductRepository:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/repository/ProductRepository.java

Использование интерфейса в App.java:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/App.java#L12-L15
Код открыт для расширения (можно добавить новый способ хранения продуктов), но закрыт для изменения уже существующего функционала.

Принцип L (Liskov Substitution Principle) подстановки Барбары Лисков
ProductRepository реализует интерфейс IProductRepository
Интерфейс IProductRepository:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/repository/IProductRepository.java

Реализация ProductRepository:
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/repository/ProductRepository.java
Класс можно безопасно заменить на интерфейс в любом месте программы — логика останется корректной.

Принцип I  (Interface Segregation Principle) разделение интерфейсов
Интерфейс IProductRepository содержит только необходимые методы: getAllProducts(), getById(), searchByKeyword().
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/repository/IProductRepository.java

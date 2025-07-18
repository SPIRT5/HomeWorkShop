# HomeWorkShop

Принцип избегания магических чисел
Константа RECOMMENDATION_LIMIT = 3:
(https://github.com/SPIRT5/HomeWorkShop/blob/main/src/App.java#L17)

Принцип DRY
Метод printProductList:
[https://github.com/SPIRT5/HomeWorkShop/blob/main/src/App.java#L149-L157](https://github.com/SPIRT5/HomeWorkShop/blob/main/src/App.java#L149)

Метод readIntInput:
[ttps://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/App.java#L159-L163](https://github.com/SPIRT5/HomeWorkShop/blob/main/src/App.java#L159)
Избавились от дублирующегося кода при поиске, просмотре всех товаров и при рекомендациях.

Принцип S (Single Responsibility) Принцип единственной ответственности 
CartService (отвечает только за корзину):
[https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/service/CartService.java](https://github.com/SPIRT5/HomeWorkShop/blob/main/src/CartService.java)

RatingService (отвечает только за рейтинг):
[https://github.com/SPIRT5/HomeWorkShop/blob/main/src/org/shop/service/RatingService.java](https://github.com/SPIRT5/HomeWorkShop/blob/main/src/RatingService.java)

Принцип O (Open/Closed) + I (Interface Segregation) + D (Dependency Inversion) Принцип открытости/закрытости
[https://github.com/SPIRT5/HomeWorkShop/blob/main/src/ProductRepository.java](https://github.com/SPIRT5/HomeWorkShop/blob/main/src/ProductRepository.java)
Код открыт для расширения (можно добавить новый способ хранения продуктов), но закрыт для изменения уже существующего функционала.

Принцип L (Liskov Substitution Principle) подстановки Барбары Лисков
Потенциальное расширение Product
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/Product.java

Принцип D (Dependency Inversion Principle) принцип инверсии зависимостей
https://github.com/SPIRT5/HomeWorkShop/blob/main/src/App.java#L13
Таким образом App зависит не от реализации, а от интерфейса. 


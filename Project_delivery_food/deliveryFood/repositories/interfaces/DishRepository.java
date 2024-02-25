package deliveryFood.repositories.interfaces;
// Вернуть один объект по его идентификатору.
//Изменить один объект по его идентификатору.
//Удаление одного объекта из базы данных по его идентификатору.
// При этом физического удаления происходить не должно,
// вместо этого логический параметр объекта просто должен быть выставлен в ложное значение.
// Такой функционал необходим для возможности восстановления удалённых объектов.

import deliveryFood.domain.interfaces.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> getAllDishes();
    void addDish(String name, double price);
    Dish getDishById(int id);
    Dish getDishByName(String name);
}

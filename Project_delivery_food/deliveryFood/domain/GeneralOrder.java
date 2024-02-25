package deliveryFood.domain;

import deliveryFood.domain.interfaces.Dish;
import deliveryFood.domain.interfaces.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralOrder implements Order {
    private LocalDateTime dateTime;
    private List<Dish> dishes = new ArrayList<>();

    public GeneralOrder() {
        dateTime = LocalDateTime.now();
    }

    @Override
    public List<Dish> getDishesInOrder() {
        return dishes;
    }

    @Override
    public boolean addDishToOrder(Dish dish) {
        return dishes.add(dish);
    }

    @Override
    public double getTotalPrice() {
        return dishes.stream()
                .map(Dish::getPrice)
                .reduce((x, y) -> x + y)
                .orElse(0.0);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GeneralOrder that = (GeneralOrder) object;

        if (!Objects.equals(dateTime, that.dateTime)) return false;
        return Objects.equals(dishes, that.dishes);
    }

    @Override
    public int hashCode() {
        int result = dateTime != null ? dateTime.hashCode() : 0;
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%tT\n", dateTime));
        for (int i = 0; i < dishes.size(); i++) {
            builder.append("N.").append(i+1).append(" ").append(dishes.get(i).toStringOrder()).append("\n");
        }
        builder.append(String.format("Total amount: %.2f", getTotalPrice()));
          return builder.toString();
    }
}
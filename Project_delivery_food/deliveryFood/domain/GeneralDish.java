package deliveryFood.domain;

import deliveryFood.domain.interfaces.Dish;

import java.util.Objects;

public class GeneralDish implements Dish {
    private int id;
    private boolean isAvailable;
    private String name;
    private double price;

    public GeneralDish(String name, double price) {
        this.name = name;
        this.price = price;
        this.isAvailable = true;
    }

    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GeneralDish that = (GeneralDish) object;

        if (id != that.id) return false;
        if (isAvailable != that.isAvailable) return false;
        if (Double.compare(price, that.price) != 0) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (isAvailable ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public String toString() {
        return String.format("%d. " +
                        " %s, price - %.2f, is active - %s.",
                id , name, price, isAvailable ? "yes" : "no");
    }

    @Override
    public String toStringOrder() {
        return String.format(" %s, price - %.2f",
                name, price);
    };
}

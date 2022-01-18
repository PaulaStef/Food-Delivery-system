package business;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {

    public abstract double computePrice();
    public abstract String getName();

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public double getRating() {
        throw new UnsupportedOperationException();
    }

    public double getCalories() {
        throw new UnsupportedOperationException();
    }

    public double getProtein() {
        throw new UnsupportedOperationException();
    }

    public double getFat() {
        throw new UnsupportedOperationException();
    }

    public double getSodium() {
        throw new UnsupportedOperationException();
    }

}

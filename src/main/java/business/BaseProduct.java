package business;

import java.util.Objects;

public class BaseProduct extends MenuItem{
    private String name;
    private double price;
    private double rating;
    private double calories;
    private double protein;
    private double fat;
    private double sodium;


    public BaseProduct(String name, double price, double rating, double calories, double protein, double fat, double sodium) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseProduct that = (BaseProduct) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public BaseProduct() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    @Override
    public double computePrice() {
        return price;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getSodium() {
        return sodium;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                '}';
    }
}

public class Car {
    String name;
    int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" + "name=" + name + ", price=" + price + '}';
    }
}

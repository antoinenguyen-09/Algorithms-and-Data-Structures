public class Book {
    String name; 
    int page; //use as key
    double price;

    public Book(String name, int page, double price) {
        this.name = name;
        this.page = page;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", page=" + page + ", price=" + price + '}';
    }
}

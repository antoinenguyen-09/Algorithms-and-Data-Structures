public class Node {
    Book value;
    Node left, right;

    public Node(Book value) {
        this.value = value;
        left = right = null;
    }
    public Node(String name, int page, double price)
    {
        value = new Book(name, page, price);
        left = right = null;
    } 
}

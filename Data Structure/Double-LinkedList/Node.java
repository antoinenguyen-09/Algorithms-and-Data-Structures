public class Node {
    Car value;
    Node next, pre;

    public Node() {
    }

    public Node(Car value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    public Node(Car value){
        this.value = value;
    }
}

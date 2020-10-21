public class NodeQueue {
    Node value;
    NodeQueue next;

    public NodeQueue(Node value) {
        this.value = value;
        next = null;
    }

    public NodeQueue(Node value, NodeQueue next) {
        this.value = value;
        this.next = next;
    }
}

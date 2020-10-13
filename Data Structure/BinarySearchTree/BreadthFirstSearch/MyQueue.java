public class MyQueue {
    NodeQueue head, tail;

    public MyQueue() {
        head = tail = null;
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public void Enqueue(Node p)
    {
        NodeQueue q = new NodeQueue(p);
        if(isEmpty())
        {
            head = tail = q;
        }
        else
        {
            tail.next = q;
            tail = q;
        }
    }
    public Node Dequeue()
    {
        if(isEmpty()) return null;
        Node p = head.value;
        head = head.next;
        return p;
    }
}

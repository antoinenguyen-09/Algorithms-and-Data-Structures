public class MyList {
    Node head, tail;
    int size;
    
    public MyList(){
        head = tail = null;
        size =0;
    }
    
    boolean isEmpty(){
        return head==null;
    }
    
    void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.value+", ");
            current = current.next;
        }
        System.out.println("");
    }
    
    void addFirst(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head = tail = node;
        } else{
            node.next = head;
            head = node;
        }
        size++;
    }
    
    void addLast(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head = tail = node;
        } else{
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
    void addIndex(int value, int index){
        if(index<0 || index>size) return;
        if(index==0) addFirst(value);
        else if(index==size) addLast(value);
        else{
            Node node = new Node(value);
            int count=0;
            Node current=head;
            while(count!=index-1){
                 count++;
                 current = current.next;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }
    
    int deleteFirst(){
        if(isEmpty()) return -1;
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }
    
    void deleteLast(){
        if(isEmpty()) return;
        Node current = head;
        while(current.next.next!=null){
            current = current.next;
        }
      //int value = current.next.value; (value la gia tri tra ve trong truong hop ham kieu int)
        current.next = null;
        tail = current;
        size--;
    }
    
    void deleteIndex(int index){
        if(index<0 || index>size) return;
        if(index==0) deleteFirst();
        else if(index==size-1) deleteLast();
        else{
            int count=0;
            Node current = head;
            while(count!=index-1){
                count++;
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }
    
    public static void main(String[] args){
        MyList list = new MyList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.display();
        list.addIndex(100, 3);
        list.display();
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        list.deleteIndex(4);
        list.display();
    }
}

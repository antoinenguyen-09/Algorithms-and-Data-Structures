public class MyDoubleList {
     Node head, tail;
     int size;
     
     public MyDoubleList(){
         head = tail = null;
         size = 0;
     }
     
     boolean isEmpty(){
         return head==null;
     }
     
     void display(){
         Node current = head;
         while(current!=null){
             System.out.print(current.value.toString()+", ");
             current = current.next;
         }
         System.out.println();
     } 
    
    void addFirst(Car value){
        Node node = new Node(value);
        if(isEmpty())
            head = tail = node;
        else{
            head.pre = node;
            node.next = head;
            head = node;
        }
        size++;
    }
    
    void addLast(Car value){
        Node node = new Node(value);
        if(isEmpty()) head = tail = node;
        else{
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }
    
    void addIndex(Car value, int index){
        if(index<0 || index>size) return;
        if(index==0) addFirst(value);
        if(index==size) addLast(value);
        else{
            Node node = new Node(value);
            int mid = size/2;
            if(index<=mid){
                Node current = head;
                int count=0;
                while(count!=index-1){
                   count++;
                   current = current.next;
                }
                node.next = current.next;
                current.next.pre = node;
                node.pre = current;
                current.next = node;
            } else{
                Node current = tail;
                int count=size-1;
                while(count!=index+1){
                    count--;
                    current = current.pre;
                }
                node.pre = current.pre;
                current.pre.next = node;
                node.next = current;
                current.pre =  node;
            }
        }
        size++;
    }
    
    void deleteFirst(){
        if(isEmpty()) return;
        head.next.pre = null;
        head = head.next;
        size--;
    }
    
    void deleteLast(){
        if(isEmpty()) return;
        tail.pre.next = null;
        tail = tail.pre;
        size--;
    }
    
    void deleteIndex(int index){
        if(index<0 || index>size) return;
        else if(index==0) deleteFirst();
        else if(index==size-1) deleteLast();
        else{
             int mid = size/2;
             if(index<=mid){
                Node current = head;
                int count=0;
                while(count!=index-1){
                   count++;
                   current = current.next;
                }
                current.next = current.next.next;
                current.next.next.pre = current;
             }
             else{
                 Node current = tail;
                 int count=size-1;
                 while(count!=index+1){
                     count--;
                     current = current.pre;
                 }
                 current.pre = current.pre.pre;
                 current.pre.pre.next = current;
             }
             size--;
        }
    }
    public static void main(String args[]){
         MyDoubleList list = new MyDoubleList();
         Car car1 = new Car("CRV", 1987);
         Car car2 = new Car("Fadil", 345);
         Car car3 = new Car("BMW", 3571);
         Car car4 = new Car("Peugout", 1320);
         Car car5 = new Car("Lamborghini", 26911);
         list.addFirst(car1);
         list.addFirst(car2);
         list.addFirst(car3);
         list.addFirst(car4);
         list.addFirst(car5);
         list.display();
         list.addLast(car1);
         list.addLast(car2);
         list.addLast(car3);
         list.addLast(car4);
         list.addLast(car5);
         list.display();
         list.addIndex(car5, 3);
         list.display();
         list.deleteFirst();
         list.display();
         list.deleteLast();
         list.display();
         list.deleteIndex(6);
         list.display();
    }
}

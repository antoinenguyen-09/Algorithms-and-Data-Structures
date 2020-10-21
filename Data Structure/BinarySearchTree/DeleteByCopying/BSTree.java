public class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }
    
    boolean isEmpty(){
        return root == null;
    }
    
    void insert(Book b){
        Node node = new Node(b);
        if(isEmpty())
            root=node;
        else{
            Node current = root;
            Node father = null;
            while(current!=null){
                if(current.value.page == b.page){
                    System.out.println("Cannot add a book with key "+ b.page);
                    return;
                }
                father = current;
                current = current.value.page < b.page ? current.right : current.left;
            }
            if(father.value.page<b.page) father.right = node;
            else father.left = node;
        }
    }
    
    void visit(Node p){
        System.out.println(p.value+" ");
    }
    
    void breadthFirst(Node pp)
    {
        MyQueue q = new MyQueue();
        q.Enqueue(pp);
        while(!q.isEmpty())
        {
            Node p = q.Dequeue();
            if(p.left!=null) q.Enqueue(p.left);
            if(p.right!=null) q.Enqueue(p.right);
            visit(p);
        }
    }
    
    void breadthFirst(){
        breadthFirst(root);
    }
    
    void deleteByCopy(Node p){   
        if(p==null || p.left==null) return;
        if(p.left.right==null){
            p.value = p.left.value;
            p.left = p.left.left;      //thi PE mac dinh xoa con trai
        } else{
            Node father = p.left;
            Node current = p.left;
            while(current.right!=null){
                father = current;
                current = current.right; //current la gia tri ngoai cung ben phai cua con ben trai (gioi nhat cua nhanh dot)
            }
            p.value = current.value;
            father.right = current.left;
        }
    }
    
    public static void main(String args[]){
        BSTree my = new BSTree();
        my.insert(new Book("A", 8, 0));
        my.insert(new Book("B", 4, 0));
        my.insert(new Book("C", 12, 0));
        my.insert(new Book("D", 2, 0));
        my.insert(new Book("E",6, 0));
        my.insert(new Book("F", 10, 0));
        my.insert(new Book("G", 14, 0));
        my.insert(new Book("H", 1, 0));
        my.insert(new Book("I", 3, 0));
        my.insert(new Book("K", 5, 0));
        my.insert(new Book("L", 7, 0));
        my.insert(new Book("J", 9, 0));
        my.insert(new Book("M", 11, 0));
        my.insert(new Book("M", 13, 0));   
        my.insert(new Book("M", 15, 0));
        my.deleteByCopy(my.root.left);
        System.out.println();
        my.breadthFirst();
        System.out.println();   
    }
}

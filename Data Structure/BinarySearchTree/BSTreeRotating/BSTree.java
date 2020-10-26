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
    
    Node findFather(Node p){
        if(p.value.page == root.value.page) return null;
        Node father = null;
        Node current = root;
        while(current!=null){
            if(current.value.page == p.value.page) return father;
            father = current;
            if(current.value.page < p.value.page) current = current.right;
            else current = current.left;
        }
        return null;
    }
    
    Node search(int key){
        Node current = root;;
        while(current!=null){
            if(current.value.page==key) return current;
            if(current.value.page<key) current = current.right;
            else current = current.left;
        }
        return null;
    }
    
    Node leftRotate(Node p){
        if(p==null || p.right==null) return p;
        Node child = p.right;
        p.right = child.left;
        child.left = p;
        return child;
    }
    
    public static void main(String args[]){
        BSTree my = new BSTree();
        System.out.println("Before left rotate: ");
//        System.out.println("Before right rotate: ");

        my.insert(new Book("A", 14, 46));
        my.insert(new Book("B", 15, 44));
        my.insert(new Book("C", 17, 54));
        my.insert(new Book("D", 16, 43));
        my.insert(new Book("E", 18, 24));
        my.insert(new Book("F", 19, 14));
        my.insert(new Book("G", 1, 14));
        my.insert(new Book("H", 2, 14));
        my.insert(new Book("I", 3, 14));
        my.insert(new Book("K", 4, 14));
        my.insert(new Book("L", 5, 14));
        my.insert(new Book("M", 6, 14));;
        
        my.breadthFirst();
        System.out.println();

        Node rotate = my.search(3);
        Node father = my.findFather(rotate); 
        System.out.println(father.value.toString());
//        System.out.println(father.left.value.toString());
        System.out.println(father.right.value.toString());
        
        Node afterrotate = my.leftRotate(rotate);
        if(father.value.page > rotate.value.page)
            father.left = afterrotate;
        else
            father.right = afterrotate;
        
        System.out.println("");
        System.out.println("After left rotate: ");
//        System.out.println("After right rotate: ");
        System.out.println(father.value.toString());
//        System.out.println(father.left.value.toString());
        System.out.println(father.right.value.toString());
        System.out.println("");
        my.breadthFirst();

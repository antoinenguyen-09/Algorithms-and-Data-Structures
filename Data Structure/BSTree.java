public class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }
    
    boolean isEmpty(){
        return root==null;
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
    
    void preOrder(Node p){
        if(p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void preOrder(){
        preOrder(root);
    }
    
    void postOrder(Node p){
        if(p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void postOrder(){
        postOrder(root);
    }
    
    void inOrder(Node p){
        if(p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void inOrder(){
        inOrder(root);
    }
    
    public static void main(String[] args) {
        BSTree my = new BSTree();
        my.insert(new Book("A", 8, 0));
        my.insert(new Book("B", 4, 0));
        my.insert(new Book("C", 12, 0));
        my.insert(new Book("D", 13, 0));
        my.insert(new Book("E", 19, 0));
        my.insert(new Book("F", 15, 0));
        my.insert(new Book("G", 8, 0));
        my.insert(new Book("H", 11, 0));
        my.insert(new Book("I", 14, 0));
//        System.out.println("");
//        my.preOrder();
        System.out.println("");
        my.inOrder();
//        System.out.println("");
//        my.postOrder();
    }
}

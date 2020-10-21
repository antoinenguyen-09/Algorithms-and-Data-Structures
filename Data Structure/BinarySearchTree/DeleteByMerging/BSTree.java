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
    
    void deleteByMerging(Node p){
        if(p==null || p.left==null) return;
//        if(p==null) return;
//        if(p.left==null) p = p.right;
        Node GrandFather = findFather(p);
        if(GrandFather==null){
            if(p.value.page == root.value.page){
                Node current = p.left;
                while(current.right!=null) current = current.right;
                current.right = p.right;
                root = p.left;
            }
        } else{
            Node current = p.left;
            while(current.right!=null) current = current.right;
            current.right = p.right;
            if(GrandFather.value.page<p.value.page)
                GrandFather.right = p.left;
            else
                GrandFather.left = p.left;
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
        my.deleteByMerging(my.root);

        my.breadthFirst();
        System.out.println();   
    }
}

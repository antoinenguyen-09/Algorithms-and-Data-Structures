import java.io.RandomAccessFile;
import java.util.Arrays;

class MyQueue{
    Node head, tail;

    public MyQueue() {
        head = tail = null;
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public void Enqueue(int v)
    {
        Node n = new Node(v);
        if(isEmpty())
        {
            head = tail = n;
        }
        else
        {
            tail.next = n;
            tail = n;
        }
    }
    public int Dequeue()
    {
        if(isEmpty()) return -1;
        int p = head.value;
        head = head.next;
        return p;
    }
}

public class BreadthFirstSearch {
    int [][]a;
    int n=13;
    
    public BreadthFirstSearch(){
        a = new int[n][n];
        try{
            RandomAccessFile raf = new RandomAccessFile("input.txt", "r");
            String ss="";
            int j=0;
            while((ss=raf.readLine())!=null){
                String []s = ss.split("\\s+");
                for(int i=0; i<n; i++){
                    a[j][i] = Integer.parseInt(s[i]);
                }
                j++;
            }
        } catch(Exception e){
            System.out.println("Co loi khi doc file"+e.getMessage());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                a[i][j] = a[j][i];
            }
        }
    }
    void display(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    void breadFirstSearch(char x){
        int k = (int) (x-65);
        boolean []b = new boolean[n];
        Arrays.fill(b, true);
        MyQueue q = new MyQueue();
        q.Enqueue(k);
        b[k] = false;
        while(!q.isEmpty()){
            int p = q.Dequeue();
            visit(p);
            for(int i=0; i<n; i++){
                if(b[i] && a[p][i]==1){
                    q.Enqueue(i);
                    b[i] = false;
                }
            }
        }
    }
    
    public static void main(String args[]){
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.display();
        bfs.breadFirstSearch('A');
    }
}    

public class DeepFirstSearch {
    int [][]a;
    int n=13;
    
    public DeepFirstSearch(){
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
    }
    
    void display(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    void visit(int x){
        System.out.print((char)(x+65)+"("+deg(x)+") --->");
    }
    
    int deg(int x){
        int count=0;
        for(int i=0; i<n; i++){
            if(a[i][x]>0)
               count+=a[i][x];
        }
        return count;
    }
    
    void depthFirst(boolean visit[], int k){
        visit(k);
        for(int i=0; i<n; i++){
            if(visit[i]&&a[i][k]!=0){
                visit[i] = false;
                depthFirst(visit, i);
            }
        }
        
    }
    
    void depthFirstSearch(char x){
        int k = (int)(x-65);
        boolean visit[] = new boolean[n];
        Arrays.fill(visit, true);
        visit[k]= false;
        depthFirst(visit, k);
    }    
    
    public static void main(String args[]){
        DeepFirstSearch dfs = new DeepFirstSearch();
        dfs.display();
        dfs.depthFirstSearch('A');
    }
}

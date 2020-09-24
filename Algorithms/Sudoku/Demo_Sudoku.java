import java.io.RandomAccessFile;

public class DemoSudoku {
    int size = 3;
    int n = size*size;
    int [] [] a;

    public DemoSudoku() {
        a = new int[n][n];
        int i=0;
        try{
            RandomAccessFile raf = new RandomAccessFile("sudoku_sample.txt", "r");
            String line="";
            while((line=raf.readLine())!=null){
                String[] sl = line.split("\\s+");
                for(int j=0; j<n; j++){
                    a[i][j] = Integer.parseInt(sl[j]);
                }
                i++;
            }
        } catch(Exception e){
            System.out.println("Co loi khi doc file "+ e.getMessage());
        }
    }
    
    boolean canPut(int value, int x, int y){
        boolean check=true;
        for(int i=0; i<n; i++){                                                 
            if(a[i][y] == value) check = false;
            if(a[x][i] == value) check = false;
        }
        for(int i = x/size*size; i<x/size*size+size; i++){
            for(int j = y/size*size; j<y/size*size+size; j++){
                if(a[i][j]==value) check=false;
            }
        }
        return check;
    }
    
    public void display(){
        for(int j=0; j < n; j++){
            for(int k=0; k<n; k++){
                System.out.print(a[j][k]+" ");
            }
            System.out.println();
        }
    }
    
    public void dienso(int x, int y){
        if(y==n){
            if(x==n-1){
                display(); //tim dc loi giai 
            } else{
                dienso(x+1, 0);
            }
        } else{
            if(a[x][y]==0){
               for(int i=1; i<=n; i++){
                   if(canPut(i, x, y)){
                       a[x][y] = i;
                       dienso(x, y+1);
                       a[x][y] = 0;
                   }
               }
            }
            else dienso(x,y+1); 
        }   
    }
    
    public static void main(String[] args){
        DemoSudoku ds = new DemoSudoku();
        ds.dienso(0, 0);
        
    }
}

import java.io.RandomAccessFile;

public class Dijkstra {
    int [][]a;
    int size=13;
    
    public Dijkstra(){
         a = new int[size][size];
         try{
            RandomAccessFile raf = new RandomAccessFile("input.txt", "r");
            String ss="";
            int j=0;
            while((ss=raf.readLine())!=null){
                String []s = ss.split("\\s+");
                for(int i=0; i<size; i++){
                    a[j][i] = Integer.parseInt(s[i]);
                }
                j++;
            }
        } catch(Exception e){
            System.out.println("Co loi khi doc file"+e.getMessage());
        }
    }
    
    void dijkstra(int from, int to){
        boolean []tobeVisited = new boolean[size];
        int []distance = new int[size]; //luu tru khoang cach ngan nhat
        int []point = new int[size]; //luu cac dinh lan luot di qua
        int k, INF = 999;
        for(int i=0; i<size; i++){
            tobeVisited[i] = false;
            distance[i] = a[from][i];
            point[i] = from;
        }
        tobeVisited[from] = true;
        while(true){
            int t=INF; // mac dinh tat ca cac diem chua di qua deu duoc dan nhan khoang cach la infinity
            k=-1;
            for(int i=0; i<size; i++){
                if(!tobeVisited[i] && distance[i]<t){
                    t = distance[i];
                    k = i;
                }
            }
            if(k==-1){
                System.out.println("No solution!");
                return;
            }
            tobeVisited[k] = true;
            if(k==to) break;
            for(int i=0; i<size; i++){
                if(tobeVisited[i]) continue;
                if(distance[i]>distance[k]+a[k][i]){
                    distance[i] = distance[k]+a[k][i];
                    point[i] = k;
                }
            }
        }
        System.out.println("Khoang cach ngan nhat tu "+(char)(from+65)+" -> "+(char)(to+65)+": "+distance[to]);
    }
    
    void display(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
      
    public static void main(String args[]){
        Dijkstra djk = new Dijkstra();
        djk.display();
        djk.dijkstra((int)('H'-65), (int)('D'-65));
    }
}

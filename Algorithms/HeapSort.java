import java.util.Random;
import java.util.Scanner;

public class HeapSort {
    public void heap(int []a, int n){
        for(int i=1; i<n; i++){
            int x = a[i];
            int s = i;
            while(s>0 && x>a[(s-1)/2]){
                a[s] = a[(s-1)/2];
                s = (s-1)/2;
            }
            a[s] = x;
        }
    }
    
    public void heapSort(int a[], int n){
        heap(a,n);
        for(int i=n-1; i>=0; i--){
            int x = a[i];
            a[i] = a[0];
            int s = 0; 
            int c = 2*s+1;
            if(c+1<i && a[c+1]>a[c]) c = c+1;
            while(c<i && x<a[c]){
                a[s] = a[c];
                s = c;
                c = 2*s+1;
                if(c+1<i && a[c+1]>a[c]) c=c+1;
            }
            a[s] = x;
        }
    }
    
    static void display(int []a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Input size of array: ");
        int size = Integer.parseInt(sc.nextLine());
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rd.nextInt(100);
        }
        System.out.println("Array before sorting");
        display(a);
 
        HeapSort hs = new HeapSort();
        hs.heapSort(a, size);
 
        System.out.println("Array after sorting");
        display(a);
     }
}

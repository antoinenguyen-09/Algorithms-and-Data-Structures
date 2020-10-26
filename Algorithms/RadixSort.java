import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RadixSort {
    void sort(int []a){
        int exp=1, n=a.length;
        int []c  = new int[n];
        int max = a[0];
        for(int i=0; i<n; i++) 
           if(max<a[i]) 
               max=a[i];
        while(max/exp != 0){
            int []b = new int[19];
            Arrays.fill(b,0);
            for(int i=0; i<n; i++)
                b[a[i]/exp%10+9]++;
            for(int i=1; i<19; i++)
                b[i] += b[i-1];
            for(int i=n-1; i>=0; i--)
                c[--b[a[i]/exp%10+9]] = a[i];
            for(int i=0; i<n; i++)
                a[i] = c[i];
            exp *= 10;
        }
    }
    
    static void display(int []a){
        for(int i=0; i<a.length; i++)
            System.out.print(a[i]+" ");
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
        System.out.println("Array before sorting: ");
        display(a);
 
        RadixSort rs = new RadixSort();
        rs.sort(a);
 
        System.out.println("Array after sorting: ");
        display(a);
     }
}

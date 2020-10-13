import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    void merge(int a[], int begin, int end, int mid){
        //tu [b,m) da sort, [m,e) da sort, merging 2 subarray --> sort array
        int[] c = new int [end-begin];
        int i = begin, j = mid, k = 0;
        while(i<mid && j<end){
//            if(a[i]<a[j]){
//                c[k] = a[i];
//                i++;
//            }
//            else{
//               c[k] = a[j];
//               j++;
//            }
//            k++;
            c[k++] = a[i]<a[j] ? a[i++] : a[j++];
        }
        if(i==mid)
            for(;j < end; j++) c[k++] = a[j];
        else
            for(;i < mid; i++) c[k++] = a[i];
        for(i=0; i < k; i++){
            a[i+begin] = c[i];
        }
    }
    
    void sort(int []a, int begin, int end){
        if(begin==end-1) return;
        if(begin+2 == end){
            if(a[begin]>a[begin+1]){
                a[begin] = a[begin] ^ a[begin+1];     // co the dung phep XOR(^) hoac phep chia (/).
                a[begin+1] = a[begin] ^ a[begin+1];   // nhung phep XOR toi uu hon.
                a[begin] = a[begin] ^ a[begin+1];
            }
        } else{
            int mid = (begin+end)/2;
            sort(a, begin, mid);
            sort(a, mid, end);
            merge(a, begin, end, mid);
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
 
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, 0, size);
 
        System.out.println("Array after sorting");
        display(a);
     }
}

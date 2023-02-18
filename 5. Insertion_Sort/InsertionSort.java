import java.util.*;

// Time Complexity: O(n^2)
// Usually used for smaller values of n. Best when parts of the array are sorted
// Insertion sort is used in Hybrid Sorting Algorithms

// Start sorting from first 2 elements and then takes another element and sorts it

// Basically it first sorts the first 2 elements, the we take 
// the third element in consideration sort the third element in the right place
// and then take the next element and so on

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        Insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Insertion(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j]<arr[j-1]) swap(arr, j, j-1);
                else break;
            }
        }
    }

    static void swap(int[] arr, int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
/*

Loop 1: 
    i=0; j=1
    4 5 3 2 1 //j=0 break

Loop 2:
    i=1; j=2
    4 3 5 2 1 //j=1
    3 4 5 2 1 //j=0 break

And so on...

*/
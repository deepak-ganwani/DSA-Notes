import java.util.*;

// Approaches:

// Basically, select an element (Starting from the largest element and so on) 
// and put it at its right place

// Or select the minimum element and put it at first place and so on

// Time Complexity: O(n^2)
// Performs better than bubble sort on small lists

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        Selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Selection(int[] arr){
        //Find the max. item in the remaining array and swap it with the correct index(arr[length-1-i])
        for (int i = 0; i < arr.length-1; i++) {
            int lastIndex=arr.length-i-1;
            int maxInd=getMaxIndex(arr,0,lastIndex);
            swap(arr, maxInd, lastIndex);
        }
    }

    static int getMaxIndex(int[] arr, int startInd, int endInd) {
        int maxInd=startInd;
        for (int i = startInd+1; i < endInd+1; i++) {
            if(arr[i]>arr[maxInd]) maxInd=i;
        }
        return maxInd;
    }

    static void swap(int[] arr, int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
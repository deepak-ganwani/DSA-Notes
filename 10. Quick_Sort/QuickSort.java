import java.util.*;

// Pivot: 
// Choose any element -> After First Pass:
// Elements < P -> will be on LHS of P
// Elements > P -> will be on RHS of P

// Idea: After every pass, the pivot element arrives at the right place
// LHS and RHS are then sorted by the recursive calls

// Quick Sort doesn't use extra space

// How to put Pivot at Right Place?
// 3 pointers -> start, pivot, end
// If the start and end both are a violation, swap
// After every iteration, start++, end--

// How to pick the pivot?
// GFG Article -> Always picks the last element as the pivot element
// Other ways: Random Element, corner elements, middle element

// Time Complexity: Worst Case(Picking the lasrgest/smallest element): O(N^2)
//                  Best Case(Picking the Middle element):O(N*log(N))

// In-Place sorting algorithm
public class QuickSort {
    public static void main(String[] args) {
        // int low and high contain beginning and ending of current array
        // whereas start and end are just pounters changing in a loop.
        int[] arr={4, 2, 5, 12, 1};
        sort(arr, 0, 4);
        for(int i=0; i<5; i++) System.out.println(arr[i]);
    }

    static void sort(int[] arr, int low, int high) {
        if(low>=high) return;

        int start=low,end=high;
        int mid=start+(end-start)/2;
        int pivot=arr[mid];

        while(start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;

            if(start<=end) {
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }

        // The pivot arrives at the right place
        // Sort the 2 parts recursively
        sort(arr, low, end);
        sort(arr, start, high);
    }
}

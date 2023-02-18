// Binary Search Steps:
// 1 -> Compare the middle element with target element
// 2 -> Divide the array in 2 halves
// Repeat the process

// Therefore, the recurrence relation so formed is:
// F(N) = O(1) + F(N/2)

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        
    }

    static int BinarySearch(int[] arr, int startInd, int endInd, int target) {
        int mid=startInd+(endInd-startInd)/2;
        if(startInd>endInd) return -1;
        else if(arr[mid]>target) return BinarySearch(arr, startInd, mid-1, target);
        else if(arr[mid]<target) return BinarySearch(arr, mid+1, endInd, target);
        else return mid;
    }
}

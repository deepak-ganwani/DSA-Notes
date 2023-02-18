import java.util.*;

// Divide the Array into 2 parts
// Get both the parts sorted via recursion 
// Merge the sorted parts

// Time Complexity: O(N*log(N))
// Space Complexity: O(N)

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        sc.close();
    }

    static int[] sort(int[] arr) {
        if(arr.length==1) return arr;
        int mid=arr.length/2;
        int[] left=sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right=sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] finalArrArr=new int[left.length+right.length];
        int i=0, j=0, k=0;
        while(i<left.length && j<right.length) {
            if(left[i]<right[j]) {
                finalArr[k]=left[i];
                i++;
            }
            else {
                finalArr[k]=right[j];
                j++;
            }
            k++;
        }
        // Adding the remaining elements in the array;
        while(i<left.length){
            finalArr[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            finalArr[k]=right[j];
            j++;
            k++;
        }
        return finalArr;
    }
    // If u don't want to create copies of arrays,
    // Pass the Array Indexes into the functions for in-place sorting.
    // Design both the functions likewise
}
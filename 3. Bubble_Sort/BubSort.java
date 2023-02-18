import java.util.*;

// Bubble Sort is also known as Sinking sort or Exchange Sort
// Bubble Sort is a inplace Sorting Algorithm
// Because the Space Complexity is Constant O(1)
// Time Complexity: O(n^2) n->ArraySize

// In the algorithm there two nested for-loops required
// Lets call the outer loop i loop, and the inner loop j loop
// Everytime the i loop runs j times, the maximum element reaches the end
// Basically first time the max element is sorted to the last place and when 
// the loop runs the second time the second largest element gets sorted to the second last place

// Basically the j loop has to run from 0 to length-i times 
// (because the elements after length-i would already be sorted, hence it saves time)

// And the i loop has to run (length-1) times 
// (makes no sense to sort when the last 2 elements are sorted in the second last loop)

// Also there might be a case that when the array doesnt have to complete all the
// i loops for sorting
// If for a particular i-th loop the there are swaps occuring in the j loop then
// the array is sorted and you can break the program

public class BubSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        boolean sortCheck;
        for (int i = 0; i < arr.length-1; i++) {
            // Assume Array is sorted
            sortCheck=true;
            // If swapping takes place change sortCheck to false
            for (int j = 1; j < arr.length-i; j++) {
                //Swap if the element is less than the previous element
                if(arr[j]<arr[j-1]) {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    sortCheck=false;
                }
            }
            if(sortCheck) break; 
            // This saves time by not unnesarrily running for remaining i times
            // if the array gets sorted before
        }
    }
}
import java.util.*;

// Solves in 1 for-loop
// Time Complexity: O(n)

// When to Use?
// ~When given numbers from range 1 to N (V. Important)
// (Basically it must be a continuous range and you can design an algorithm likewise)

// Start iteration from the first element
// If the first element is not at the correct index swap it with the element at its correct place
// If a swap takes place don't increment i, and check the element at the first place again
// If the first element is rightly placed increment i by 1
// Follow the same process for the remaining elements.
// You only need to run the loop for N-1 times
// (Because the last element would be in the right place when the second last element is brought to the right place)
// (So no need to check for the last one)

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,6};
        Cycle(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Cycle(int[] arr){
        // Considering array is continuous 1 to N
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]!=i+1) 
            {
                swap(arr, i, arr[i]-1);
                i--;
            }
        }

        // Using while loop
        int i=0;
        while (i<arr.length) {
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]) swap(arr, i, correct);
            else i++;
        }
    }

    static void swap(int[] arr, int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}

// Type of Questions:
// Search the missing number in the range of numbers
// Search the repeating number in the range of numbers
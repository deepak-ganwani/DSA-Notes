import java.util.Arrays;

// Time Complexity of the code: O(N)

// In a given 2-D Matrix,
// Each row and each column is Sorted in Ascending Order (!!!IMPORTANT)
// Search an element in the matrix
// Example of the Matrix: (Let say target is 37)
//  10 20 30 40
//  15 25 35 45
//  28 29 37 49
//  33 34 38 50

// NOTE: Matrix can be NxM (Not necessarily NxN: Same number of rows and column)
// It just shouldn't be a jagged array.

// Solution:
//Starting from upper row (Here lower bound would be 10 and upper bound would be 40)

// If the upper bound of a row is greater than the target element then the entire column gets eliminated 
// (Because all the numbers in the column below will be greater than the upper bound value hence being greater than the target)
// Basically Comlumn--

// If the upper bound of the row is less than target element then the row gets eliminated
// (Because all the elements of that row would hense be less than target element)
// Basically now Row++

//Follow the same process till element found or the no. of elements in the Matrix is 1
//Basically till Rows<RowLength && Column>0

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] arr={{10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};

        System.out.println(Arrays.toString(MatSearch(arr, 37))); //Must return 2,2
    }

    //returns index in the form of an array -> 0 index: Row; 1 index: Column
    static int[] MatSearch(int[][] arr, int target) {
        int row=0;
        int column=arr[0].length-1;

        while(row<arr.length && column>=0) {
            if(arr[row][column]==target) return new int[]{row, column};
            else if(arr[row][column]<target) row++;
            else column--;
        }

        return new int[]{-1, -1};
    }
}
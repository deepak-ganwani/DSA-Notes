import java.util.*;

// The given 2-D Array is strictly sorted

//Eg:
//   1  2  3  4
//   5  6  7  8
//   9 10 11 12
//  13 14 15 16

// Some Basic Approaches
// Do a Normal Linear Search [O(n^2)] or The Upper Bound Lower Bound Approach [O(n)]
// Convert it into a 1-D array and then apply Binary Search

// Binary Search in 2-D(Time Complexity (Condsidering a NxM Matrix): O(log(N)+O(log(M))))

// Start with the Middle Column, perform Binary Search on it
// If the middle element is greater than target element, all the rows below it are eliminated
// All the elements strictly to the right of the middle element are also eliminated

// If the middle element is lesser than target element, all the rows above it are eliminated
// All the strictly to the left of the middle element are also eliminated

// In the end only 2 rows will be left
// Search for the target in the middle column
// If element not found divide the matrix in 4 Parts
// The 4 parts are the part of rows on the left and right of the middle column in each column
// Do binary search for those 4 Parts individually

//This enitre process can also be done column-wise

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] arr={{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.toString(matBinSearch(arr, 6)));//should return 1,2
        System.out.println(Arrays.toString(matBinSearch(arr, 89)));//should return -1,-1
    }

    //simple binSearch is required for the matrix search (Search in the row between the columns)
    static int[] binSearch(int[][] arr, int row, int colStart, int colEnd, int target) {
        while(colStart<=colEnd) {
            int mid= colStart+(colEnd-colStart)/2;
            if(arr[row][mid]==target) return new int[] {row, mid};
            else if(arr[row][mid]<target) colStart=mid+1;
            else colEnd=mid-1;
        }

        return new int[] {-1,-1};
    }

    //returns index in the form of an array -> 0 index: Row; 1 index: Column
    static int[] matBinSearch(int[][] arr, int target) {
        //Add a check point if the matrix is empty
        int row=arr.length;
        int col=arr[0].length;

        if(row==1) return binSearch(arr, 0, 0, col-1, target);

        // run a loop till 2 rows are remaining
        int rowStart=0;
        int rowEnd=row-1;
        int colMid=col/2;
        while(rowStart<(rowEnd-1)) {
            int mid=rowStart+(rowEnd-rowStart)/2;
            if(arr[mid][colMid]==target) return new int[] {mid, colMid};
            if(arr[mid][colMid]<target) rowStart=mid;//No +1 here cause index starts with 0 (and in the other methods we add +1/-1)
            else rowEnd=mid;
        }

        // now we have 2 rows
        // My Thoughts: Binary search on the 2 rows individually 
        
        // Kunal Kushwaha's Method
        // Check whether the target is in middle column of 2 rows
        if(arr[rowStart][colMid]==target) return new int[] {rowStart, colMid};
        if(arr[rowStart+1][colMid]==target) return new int[] {rowStart+1, colMid};
        //Otherwise
        // Search in 1st half then 2nd half(1st row left side and right side elements to the middle Column)
        // Search in 3rd half then 4th half
        // Search 1st half if target is less than or equal to 1st row element on the left of middle element
        // 2ndd half if target greater than 1st half last element and greater than or equal 2nd half 1st element
        // 3rd half if target greater than 2nd half last element and less than 3rd half last element
        // Similar for 4th one

        if(target<=arr[rowStart][colMid-1]) return binSearch(arr, rowStart, 0, colMid-1, target);
        if(target>=arr[rowStart][colMid+1] && target<=arr[rowStart][col-1]) return binSearch(arr, rowStart, colMid+1, col-1, target);
        if(target<=arr[rowStart+1][colMid-1]) return binSearch(arr, rowStart+1, 0, colMid-1, target);
        if(target>=arr[rowStart+1][colMid+1]) return binSearch(arr, rowStart+1, colMid+1, col-1, target);

        return new int[]{-1,-1};
    }
}
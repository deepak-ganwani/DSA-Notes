public class BinarySearch {
    public static void main(String[] args) {
        
    }

    //returns the index (-1 if not found)
    static int binSearch(int[] arr, int target) {
        //Array must be sorted
        //If not sorted, sort the Array First
        int start=0;
        int end=arr.length-1;

        while(start<=end) {  
            int mid=start+(end-start)/2;
            //this overcomes the possibility of int overflow on star+end

            if(target<arr[mid]) end=mid-1;
            else if(target>arr[mid]) start=mid+1;
            else return mid;
        }

        return -1;
    }

    //if the array is Sorted but the order is not known (ascending/descending)
    //returns the index (-1 if not found)
    static int orderAgnosticBS(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        
        //checking the order of sort of the array
        boolean isAsc=arr[start]<=arr[end];
        /* That was the shorter code for */
        //  boolean isAsc;
        //  if(arr[start]<=arr[end]) isAsc=true;
        //  else isAsc=false;

        while(start<=end) {  
            int mid=start+(end-start)/2;
            //this overcomes the possibility of int overflow on star+end

            if(target==arr[mid]) return mid;

            if(isAsc) {
                if(target<arr[mid]) end=mid-1;
                else if(target>arr[mid]) start=mid+1;
            }
            else {
                if(target>arr[mid]) end=mid-1;
                else if(target<arr[mid]) start=mid+1;
            }
        }

        return -1;
    }
}

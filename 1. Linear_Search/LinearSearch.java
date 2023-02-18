public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(arraySearch(arr, 1));
        System.out.println(arraySearch(arr, 12));

        String name="Deepak";
        System.out.println(stringSearch(name, 'a'));
        System.out.println(stringSearch(name, 'd'));
    }

    //Search in the Array
    //Returns index of array element if found (else -1)
    static int arraySearch(int[] arr, int target) {
        if(arr.length==0 ) return -1;
        for (int index = 0; index < arr.length; index++) {
            if(arr[index]==target) return index;
        }
        return -1;
    }

    //Search in the String
    //Returns True if found else false(boolean)
    static boolean stringSearch(String str, char target) {
        if(str.length()==0) return false;
        // for (int index = 0; index < str.length(); index++) {
        //     if(str.charAt(index)==target) return true;
        // }
        for (char ch : str.toCharArray()) {
            if(ch==target) return true;
        }
        return false;
    }
}
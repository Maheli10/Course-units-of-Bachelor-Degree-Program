import java.util.*;

class BinarySearch{

    public static int binarySearch(int[] arr,int left ,int right, int target) {

            if(left>right){
                return -1;
            }

            int mid = left+(right-left)/2;
            if (arr[mid] == target) {
                return mid; // target found
            } else if (arr[mid] < target) {
                return binarySearch(arr,mid +1,right,target);
            } else {
                return binarySearch(arr,mid -1,left,target); 
            }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11,33,45,98,33,5,32,5,3,90,876,3};
        int target = 7;

        int result = binarySearch(arr,0,arr.length-1, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }

        long start_time = System.nanoTime();
		
		int n= 100000, sum=0;
		
		for (int i=0; i<n; i++){
			sum+=i;
		}
		long end_time = System.nanoTime();
		System.out.println("Time : "+(end_time-start_time)+" ns");

    }
}

/* public class BinarySearchExample {
    // Method to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow

            if (arr[mid] == target) {
                return mid; // target found
            } else if (arr[mid] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11};
        int target = 7;

        int result = binarySearch(numbers, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
*/
import java.util.*;
/*
class BubbleSorting
{
	int [] arr= {5,15,8,100,20,30};
	
	
	public void bSort()
	{
		System.out.println("Sorted array: ");
		int temp=0;
		for(int j=0; j<arr.length; j++){
		for(int i=0; i<arr.length-1; i++)
		{
			if(arr[i]>arr[i+1])
			{
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
				
			}	
		}
			System.out.println(arr[j]);
		}
	
	}
	public static void main(String[] args)
	{
		BubbleSorting bs= new BubbleSorting();
		bs.bSort();
	}
}*/

public class BubbleSorting {

    // Performs one bubble pass
    void bubble(int arr[], int i) {
        // base case: finished one pass
        if (i == 0)
            return;

        // compare and swap
        if (arr[i] < arr[i - 1]) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        // recursive call for next pair
        bubble(arr, i - 1);
    }

    // Main recursive bubble sort
    void bubbleSort(int arr[], int n) {
        // base case: array sorted
        if (n == 1)
            return;

        // do one full bubble pass
        bubble(arr, n - 1);

        // sort remaining elements
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 4, 2, 8 };

        BubbleSorting rbs = new BubbleSorting();
        rbs.bubbleSort(arr, arr.length);

        // print sorted array
        for (int x : arr)
            System.out.print(x + " ");
    }
}

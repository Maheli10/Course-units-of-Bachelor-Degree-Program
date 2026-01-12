/*public class MergeSort{
	int[] ar={2,52,44,6,59,32};
	
	
	//
	public void Sort(int arr[], int l, int r)
	{
		//find sizes of two sub arrays
		int n1= m-l+1;
		int n2= r-m;
		
		//create temp arrays
		int L[]= new int[n1];
		int R[]= new int[n2];
		
		//copy data to temp arrays
		for(int i=0; i<n1; i++)
		{
			L[i]=ar[i+1];
		}
		for(int j=0; i<n2; i++)
		{
			L[i]=ar[m+i+j];
		}
		
		
		//code
		
		
		
		
		
		
		
		
		
	}
	
	public void displaySort()
	{
		for(int i=1; i<arr.length; i++)
		{
			System.out.println(ar[i]);
		}
	}
	
	public static void main(String [] args)
	{
		MergeSort ms= new MergeSort();
		ms.Sort();
		ms.displaySort();
	}
}

class sum
{
	public void Su()
	{
		int sum= x+y;
		System.out.println("Sum is "+sum);
	}
	public static void main(String [] args)
	{
		
		su();
	}
	
}
*/
public class MergeSort {

    int[] ar = {2, 52, 44, 6, 59, 32};

    // Merge function
    void merge(int arr[], int l, int m, int r) {
        // sizes of subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data to L
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        // copy data to R
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        // merge temp arrays
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining L
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copy remaining R
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Sort function
    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);        // left half
            sort(arr, m + 1, r);    // right half
            merge(arr, l, m, r);    // merge
        }
    }

    // Display function
    void display() {
        for (int x : ar) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.sort(ms.ar, 0, ms.ar.length - 1);
        ms.display();
    }
}

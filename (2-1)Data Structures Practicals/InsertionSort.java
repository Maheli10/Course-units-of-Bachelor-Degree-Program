class InsertionSort {
	int [] arr ={5,1,10,6};
	
	
	public void sort()
	{
		for(int i=1; i<arr.length; i++)
		{
			int key= arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j=j-1;
				
			}
			arr[j+1]= key;
		}
	}
	
	public void displayList()
	{
		System.out.println("Sorted array : ");
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args)
	{
		InsertionSort s= new InsertionSort();
		 s.sort();
		 s.displayList();
	}
}
 import java.util.Arrays;
 class Linear{
    public static void main(String [] args){
        int num= 9;
        int [] arr = {1, 3, 5, 7, 9, 11,33,45,98,33,5,32,5,3,90,876,3};
        for( int i=0; i<arr.length; i++){
            if(arr[i]== num){
                System.out.println("Index of the search is "+ i);
            }
            else{
                System.out.println("value not found");
            }
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
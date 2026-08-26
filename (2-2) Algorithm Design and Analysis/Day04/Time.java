import java.util.Arrays;

class Time{
	public static void main(String [] args){
		long start_time = System.nanoTime(); //record curent time in nano seconds.before loop starts
		
		int n= 100000, sum=0; //n is just a sample task 
		
		for (int i=0; i<n; i++){
			sum+=i;   //keeps track of the calculation result inside the loop.
		}
		long end_time = System.nanoTime(); //record time after loop finishes
		System.out.println("Time : "+(end_time-start_time)+" ns"); //by substracting find the time took for loop
	}
}

//use this code to measure performance.ex:- searching and sorting 
//used to find which part is slow in program
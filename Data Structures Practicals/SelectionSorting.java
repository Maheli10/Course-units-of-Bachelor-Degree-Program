import java.util.Scanner;

class Testing {
		int[] arr;
		int size;
		Testing(){
			Scanner sc=new Scanner(System.in);
			
			
			System.out.println("Enter the length of array: ");
			int size  =sc.nextInt();
			
			arr=new int[size];
			
			
			System.out.println("Enter the array element");
			for(int i=0; i<size; i++){
			arr[i]=sc.nextInt();
			}			
		}
		public void sSort(){
			int tem=0;
			for(int i=0;i<arr.length; i++){
				for(int j=i+1; j<arr.length; j++){
					
					if(arr[i]>arr[j]){
						tem=arr[j];
						 arr[j]=arr[i];
						 arr[i]=tem;
					}
				}
			}
		}
		
		public void display(){
			for(int n:arr){
				System.out.println(n);
			}
		}
		
		public static void main(String [] args){
			Testing ss=new Testing();
			
			ss.sSort();
			System.out.println("Sorted array:");
			ss.display();
		}
}
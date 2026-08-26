class BubbleSort{
    public void bubbleSort(int [] arr){
        for(int i=0; i<=arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                int temp= 0;
                if(arr[j]>arr[j+1]){
                    temp= arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]= temp;
                }

            }
        }
    }

    public static void main(String [] args){
        int [] arr= {45,7,4,1,9,5,2};
        BubbleSort bs= new BubbleSort();
        bs.bubbleSort(arr);
        for(int i=0;i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
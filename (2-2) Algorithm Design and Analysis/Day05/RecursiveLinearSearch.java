class RecursiveLinearSearch{
    public static int Linear(int []arr,int n,int i){
        if(i==0){
            return -1;
        }
        if(arr[i]==n)
        return i;

        return Linear(arr,n,i-1);
    }

    public static void main(String[] args){
        int [] arr={3,2,4,6,3,7,65,34,63,22,1};

        System.out.println("The index of 6 :"+ Linear(arr,1,arr.length-1));
    }
}

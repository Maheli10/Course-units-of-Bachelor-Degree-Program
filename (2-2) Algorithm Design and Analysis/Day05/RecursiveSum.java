class RecursiveSum{
    public static int Sum(int a,int b){
        if (a>b){
            return 0;
        }

        return a+Sum(a+1,b);

    }

    public static void main(String[] args){
        System.out.print("Sum of given number range: "+Sum(1,3));
        
    }
}
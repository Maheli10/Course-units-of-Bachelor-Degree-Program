class RecursiveFact{
    public static int Factorial(int a){
        if (a==1){
            return 1;
        }

        return a*Factorial(a-1);

    }

    public static void main(String[] args){
        System.out.print("Factorial: "+Factorial(5));
        
    }
}
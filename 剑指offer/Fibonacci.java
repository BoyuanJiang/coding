public class Fibonacci {
    public  static long Fibonacci(int n)
    {
        int[] result = {0,1};
        if (n<2)
            return result[n];
        int a=0,b=1,sum=0;
        for (int i=2;i<=n;i++)
        {
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}

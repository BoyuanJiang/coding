public class Power {
    public static double Power(double base, int exponent) {
        double res = 1;
        if (exponent == 0)
            return 1;
        else if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
            return res;
        } else {
            if (base==0)
                return 0;
            exponent = -exponent;
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
            return 1 / res;
        }

    }

    public static double Power1(double base, int exponent){
        // 一个更好的解法, 利用P93的递推公式
        int exp=exponent;
        double res=1.0;
        if (exponent==0)
            return 1;
        else if (exponent<0)
        {
            if (base==0)
                return 0;
            exp=-exp;
        }
        while (exp>0)
        {
            if ((exp&1)==1)
                res=res*base;
            base=base*base;
            exp=exp>>1;
        }
        return exponent>0?res:1/res;
    }

    public static void main(String[] args) {
        System.out.println(Power1(2, -3));
    }
}

public class NumberOf1 {
    public static int NumberOf1(int target) {
        //当target为负数时,如果直接右移target后与1进行与操作,会导致死魂还,因为负数的最高位为1,因此通过左移flag代替
        int flag=1;
        int count=0;
        while (flag!=0)
        {
            if ((target&flag)!=0)
                count++;
            flag = flag<<1;
        }
        return count;
    }

    public static int NumberOf11(int target) {
        //一个更优的解法,将target-1后与本身与运算,相当于把target最右边的1置为0,那么有多少个1就可以进行多少次操作
        int count=0;
        while (target!=0)
        {
            int tmp=target-1;
            target=target&tmp;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(NumberOf1.NumberOf11(179));
    }
}

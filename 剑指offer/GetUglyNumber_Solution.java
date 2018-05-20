public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution0(int index) {
        //直接遍历每一个数判断是否是丑数，时间复杂度太高
        if (index==1)
            return 1;
        int ugly_count=1;
        int curr_num=1;
        while (ugly_count!=index)
        {
            curr_num++;
            if (isUgly(curr_num))
                ugly_count++;
        }
        return curr_num;
    }

    private boolean isUgly(int num)
    {
        while (num%2==0)
            num/=2;
        while (num%3==0)
            num/=3;
        while (num%5==0)
            num/=5;
        if (num==1)
            return true;
        else return false;
    }

    public int GetUglyNumber_Solution(int index) {
        //按顺序保存丑数，不需要遍历每一个数
        if (index<=0) return 0;
        int[] uglyNums = new int[index];
        uglyNums[0]=1;
        int currIndex=1;
        int index2=0, index3=0, index5=0;
        while (currIndex!=index)
        {
            uglyNums[currIndex]=Min(uglyNums[index2]*2, uglyNums[index3]*3, uglyNums[index5]*5);
            while (uglyNums[index2]*2<=uglyNums[currIndex]) index2++;
            while (uglyNums[index3]*3<=uglyNums[currIndex]) index3++;
            while (uglyNums[index5]*5<=uglyNums[currIndex]) index5++;
            currIndex++;
        }
        return uglyNums[currIndex-1];
    }

    private int Min(int a, int b, int c){
        int min = a>b? b:a;
        min = min>c?c:min;
        return min;
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution sol = new GetUglyNumber_Solution();
        System.out.println(sol.GetUglyNumber_Solution(30));
    }
}

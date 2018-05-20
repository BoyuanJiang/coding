public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //使用异或运算对数组拆分成两组，每组均包含一个待求的数字
        if (array.length<2)
            return;
        int XorResult=array[0];
        num1[0]=0;
        num2[0]=0;
        for (int i=1;i<array.length;i++)
            XorResult^=array[i];
        for (int i=0;i<array.length;i++)
        {
            if ((XorResult&array[i])==XorResult)
                num1[0]^=array[i];
            else num2[0]^=array[i];
        }
    }

    public static void main(String[] args) {
        int[] array={2,4,3,6,3,2,5,5};
        FindNumsAppearOnce sol = new FindNumsAppearOnce();
        int[] num1=new int[1];
        int[] num2=new int[1];
        sol.FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}

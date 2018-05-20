public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
//        由于我们要找的数字出现次数比其他所有数字出现的次数还要多，那么要找的数字一定是最后一次把次数设为一的数字
        int count = 1;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                res = array[i];
                count = 1;
            } else if (res == array[i])
                count++;
            else
                count--;
        }
        int times=0;
        for (int i=0;i<array.length;i++)
        {
            if (array[i]==res)
                times++;
        }
        if (times>array.length/2)
            return res;
        else
            return 0;
    }

    private int Partition(int[] array, int start, int end)
    {
        int tmp = array[start];
        int i=start, j=end+1;
        while (true)
        {
            while (array[++i]<=tmp) if (i==end) break;
            while (array[--j]>=tmp) if (j==start) break;
            if (i>=j) break;
            swap(array, i, j);
        }
        swap(array, start, j);
        return j;
    }
    private void swap(int[] array, int i, int j)
    {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array.length==1)
            return array[0];
        int middle = array.length/2;
        int index = Partition(array, 0, array.length-1);
        while (middle!=index)
        {
            if (middle<index)
                index = Partition(array, 0, index-1);
            else
                index = Partition(array, index+1, array.length-1);
        }
        int times=0;
        int res=array[middle];
        for (int i=0;i<array.length;i++)
        {
            if (array[i]==res)
                times++;
        }
        if (times>array.length/2)
            return res;
        else
            return 0;
    }

    public static void main(String[] args) {
        int[] array = {1};
        MoreThanHalfNum_Solution sol = new MoreThanHalfNum_Solution();
        System.out.println(sol.MoreThanHalfNum_Solution1(array));
    }
}

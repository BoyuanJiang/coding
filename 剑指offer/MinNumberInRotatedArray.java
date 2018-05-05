//数组{3,4,5,1,2}为{1,2,3,4,5}的旋转数组,寻找该数组的最小值
public class MinNumberInRotatedArray {
    public static void main(String[] args) {
        MinNumberInRotatedArray minNumberInRotatedArray = new MinNumberInRotatedArray();
        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotatedArray.minNumberInRotateArray(array));
    }
    public int minNumberInRotateArray0(int [] array) {
//        O(n)时间复杂度
        if (array.length==0)
            return 0;
        for (int i=0;i<array.length-1;i++)
        {
            if (array[i+1]>=array[i])
                continue;
            else
                return array[i+1];
        }
        return array[array.length];
    }

    public int minNumberInRotateArray(int [] array) {
//        二分查找,O(log n)
        if (array.length==0)
            return 0;
        else if (array.length==1)
            return array[0];
        else {
            int i=0, j=array.length-1,mid=(i+j)/2;
            while (array[i]>=array[j])
            {
                if (j-i==1)
                {
//                    头指针和尾指针相邻时寻找结束,最小值位于尾指针的位置
                    mid=j;
                    break;
                }
                mid = (i+j)/2;
                if (array[mid]>=array[i])
                    i=mid;  //如果中间值大于等于头指针,则要找的在后半段
                else if (array[mid]<=array[j])
                    j=mid;  //如果中间值小于等于尾指针,则要找的在前半段
            }
            return array[mid];
        }

    }
}

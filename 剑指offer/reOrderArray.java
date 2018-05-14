import java.util.Arrays;

public class reOrderArray {
    public static void reOrderArray0(int [] array) {
//        无法保持两者的相对顺序
        if (array.length<2)
            return;
        int left = 0, right = array.length-1,tmp=0;
        while (left<right) {
            if (array[left] % 2 == 1)   //odd
                left++;
            if (array[right]%2==0)  //even
                right--;
            if (left>right)
                return;
            tmp=array[left];
            array[left]=array[right];
            array[right]=tmp;
        }
    }

    public static void reOrderArray(int [] array) {
//        保持相对顺序
        if (array.length<2)
            return;
        int oddCount=0;
        int[] orderedArray = new int[array.length];
        for (int i=0;i<array.length;i++)
            if (array[i]%2==1)
                oddCount++;
        int oddIndex=0,evenIndex=oddCount;
        for (int i=0;i<array.length;i++)
            if (array[i]%2==0)
                orderedArray[evenIndex++]=array[i];
            else
                orderedArray[oddIndex++]=array[i];
        for (int i=0;i<array.length;i++)
            array[i]=orderedArray[i];
    }
    public static void main(String[] args) {
        int[] array={3,5,6,4,2,1,8};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}

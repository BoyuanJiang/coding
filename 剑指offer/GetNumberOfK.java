public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int begin = GetFirstK(array, 0, array.length-1,k);
        int end = GetLastK(array, 0, array.length-1,k);
        if (begin<0&&end<0)
            return 0;
        else
            return end-begin+1;
    }

    private int GetFirstK(int[] array, int begin, int end, int k)
    {
        if (begin>end)
            return -1;
        int mid = (begin+end)>>1;
        if (array[mid]==k)
        {
            if (mid==0||array[mid-1]!=k)
                return mid;
            else {
                return GetFirstK(array,begin,mid-1,k);
            }
        }
        else if (array[mid]>k)
            return GetFirstK(array,begin,mid-1,k);
        else
            return GetFirstK(array,mid+1,end,k);
    }

    private int GetLastK(int[] array, int begin, int end, int k)
    {
        if (begin>end)
            return -1;
        int mid = (begin+end)>>1;
        if (array[mid]==k)
        {
            if (mid==array.length-1||array[mid+1]!=k)
                return mid;
            else
                return GetLastK(array, mid+1, end,k);
        }
        else if (array[mid]>k)
            return GetLastK(array, begin,mid-1,k);
        else
            return GetLastK(array, mid+1, end,k);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3};
        GetNumberOfK sol = new GetNumberOfK();
        System.out.println(sol.GetNumberOfK(array,4));
    }
}

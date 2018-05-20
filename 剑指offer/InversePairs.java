public class InversePairs {
    private int cnt = 0;

    public int InversePairs(int[] array) {
        int[] tmp=new int[array.length];
        sort(array,tmp,0,array.length-1);
        return cnt%1000000007;
    }

    private void sort(int[] array, int [] tmp, int lo, int hi) {
        if (lo>=hi) return;
        int mid = (lo+hi)>>1;
        sort(array, tmp, lo, mid);
        sort(array, tmp, mid+1, hi);
        merge(array, tmp, lo, mid, hi);
    }

    private void merge(int[] array, int[] tmp, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            tmp[k] = array[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
//                if (tmp[i-1]>tmp[j])
//                    cnt++;
                array[k] = tmp[j++];
            }
            else if (j > hi) {
//                if (tmp[i]>tmp[j-1])
//                    cnt++;
                array[k] = tmp[i++];
            }
            else if (tmp[i] > tmp[j]) {
                array[k] = tmp[j++];
                cnt+=mid-i+1;   //第一个数组还剩多少个数字就有多少对逆序对
                cnt%=1000000007;
            } else array[k] = tmp[i++];
        }
    }

    public static void main(String[] args) {
        int[] array={7,5,6,4};
        InversePairs sol = new InversePairs();
        System.out.println(sol.InversePairs(array));
    }
}

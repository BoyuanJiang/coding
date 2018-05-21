public class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
//        for (int num : nums) {
//            if (minQueue.size() < k || num > minQueue.peek())
//                minQueue.offer(num);
//            if (minQueue.size() > k)
//                minQueue.poll();
//        }
//        return minQueue.peek();
//    }

    public int partition(int[] array, int left, int right)
    {
        int i=left, j=right+1, pivot=array[i];
        while (true)
        {
            if (i>=j) break;
            while (j>left&&array[--j]<=pivot)
                if (j==left) break;
            while (i<right&&array[++i]>=pivot)
                if (i==right) break;
            if (i>=j) break;
            swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    private void swap(int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int getTopK(int[] array, int K, int left, int right)
    {
        if(K <= 0)
            return -1;
        if(left == right)
            return right;
        int pos = partition(array,left, right);
        int i=pos-left+1;
        if (i==K)
            return pos;
        else if (i<K)
            return getTopK(array, K-i,pos+1, right);
        else
            return getTopK(array, K,left, pos);

    }

    public static void main(String[] args) {
        int[] array={2,4,6,2,3,4,9,6};
        Solution sol = new Solution();
        int pos = sol.getTopK(array,3,0,array.length-1);
        for (int i=0;i<=pos;i++)
            System.out.println(array[i]);
    }
}

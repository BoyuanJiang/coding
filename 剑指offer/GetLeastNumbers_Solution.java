import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution0(int [] input, int k) {
        //借鉴快速排序的思想，但是会修改数组内容，时间复杂度为O(n)
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length<k||k==0)
            return res;
        int idx = Partition(input, 0, input.length-1);
        while (idx!=k-1)
        {
            if (idx>k-1)
                idx = Partition(input, 0, idx-1);
            else
                idx = Partition(input, idx+1, input.length-1);
        }
        for (int i=0;i<k;i++)
            res.add(input[i]);
        return res;
    }

    private int Partition(int[] input, int start, int end)
    {
        if (start==end)
            return start;
        int tmp = input[start];
        int i = start, j = end+1;
        while (true)
        {
            while (input[++i]<tmp) if (i==end) break;
            while (input[--j]>tmp) if (j==start) break;
            if (i>=j) break;
            swap(input, i, j);
        }
        swap(input, start, j);
        return j;
    }

    private void swap(int[] array, int i, int j)
    {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //使用优先队列实现一个最大堆
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length<k||k==0)
            return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i=0;i<input.length;i++)
        {
            if (maxHeap.size()!=k)
                maxHeap.add(input[i]);
            else {
                if (maxHeap.peek()>input[i])
                {
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }
        for (Integer integer:maxHeap)
        {
            res.add(integer);
        }
        return res;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution sol = new GetLeastNumbers_Solution();
        int[] input = {4,5,1,6};
        ArrayList<Integer> res = sol.GetLeastNumbers_Solution(input, 4);
        System.out.println(res);
    }
}

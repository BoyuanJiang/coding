public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        int[] array = new int[n];
        int curr=-1, count=n, step=0;
        while (count>0)
        {
            curr++;
            if (curr>=n) curr=0;
            if (array[curr]==-1) continue;
            step++;
            if (step==m)
            {
                array[curr]=-1;
                step=0;
                count--;
            }
        }
        return curr;
    }
}

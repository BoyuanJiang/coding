public class Sum_Solution {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean t=(n>0) && ((ans+=Sum_Solution(n-1))>0);
        return ans;
    }
}

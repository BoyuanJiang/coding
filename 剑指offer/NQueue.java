import java.util.ArrayList;
import java.util.Arrays;

public class NQueue {
    int N=8;
    int[] position = new int[N];
    public void backTrack(int n, ArrayList<String> res)
    {
        if (n==N)
        {
            System.out.println(Arrays.toString(position));
            res.add(Arrays.toString(position));
            return;
        }
        for (int i=0;i<N;i++)
        {
            position[n]=i;
            if (isFalce(n))
                backTrack(n+1,res);
        }
    }

    private boolean isFalce(int i)
    {
        for (int j=0;j<i;j++)
        {
            if (Math.abs(i-j)==Math.abs(position[i]-position[j])||position[i]==position[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        NQueue sol = new NQueue();
        sol.backTrack(0,res);
    }
}

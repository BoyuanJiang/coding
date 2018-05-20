import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //a1=(k-l+1)/2
        //an=(k+l-1)/2
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum<3)
            return res;
        int s=(int) Math.sqrt(2*sum);
        for (int l=s;l>=2;l--)
        {
            if (2*sum%l==0)
            {
                int k=2*sum/l;
                if (l%2==0&&k%2!=0||l%2!=0&&k%2==0)
                {
                    int a1=(k-l+1)>>1;
                    int an=(k+l-1)>>1;
                    ArrayList<Integer> tmp = new ArrayList<>();
                    for (int i=a1;i<=an;i++)
                        tmp.add(i);
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindContinuousSequence sol = new FindContinuousSequence();
        sol.FindContinuousSequence(100);
    }
}

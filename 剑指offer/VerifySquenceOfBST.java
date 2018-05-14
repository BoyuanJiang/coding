public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)
            return false;
        return judge(sequence,0,sequence.length-1);
    }

    private static boolean judge(int [] sequence, int start, int end)
    {
        if (end<=start)
            return true;
        int idx=end-1;
        while (idx>=start&&sequence[idx]>sequence[end])
            idx--;
        for (int l=idx;l>=start;l--)
            if (sequence[l]>sequence[end])
                return false;
        return judge(sequence, start, idx)&&judge(sequence, idx+1,end-1);
    }

    public static void main(String[] args) {
        int[] seq = {5,4,3,2,1};
        System.out.println(VerifySquenceOfBST(seq));
    }
}

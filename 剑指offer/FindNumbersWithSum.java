import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length<2)
            return res;
        int i=0, j=array.length-1;
        while (array[i]+array[j]!=sum&&i<j)
        {
            if (array[i]+array[j]>sum)
                j--;
            else i++;
        }
        if (array[i]+array[j]==sum)
        {
            res.add(array[i]);
            res.add(array[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array={1,2,4,7,11,15};
        FindNumbersWithSum sol = new FindNumbersWithSum();
        sol.FindNumbersWithSum(array,15);
    }
}

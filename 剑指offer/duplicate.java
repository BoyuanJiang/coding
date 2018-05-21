import java.util.HashSet;

public class duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length<2||numbers==null)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer:numbers)
        {
            if (set.contains(integer))
            {
                duplication[0]=integer;
                return true;
            }
            else set.add(integer);
        }
        return false;
    }
}

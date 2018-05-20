import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        String s="";
        for (int i=0;i<numbers.length;i++)
        {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1+""+str2;
                String s2 = str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        for (int i:list)
            s+=i;
        return s;
    }

    public static void main(String[] args) {
        PrintMinNumber sol = new PrintMinNumber();
        int[] array = {3,32,321};
        System.out.println(sol.PrintMinNumber(array));
    }
}

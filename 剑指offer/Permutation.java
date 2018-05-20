import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation {
    public  ArrayList<String> Permutation(String str) {
        TreeSet<String> res = new TreeSet<>();
        if (str!=null) {
            subPermutation(str.toCharArray(), 0, res);

        }
        return new ArrayList<>(res);
    }

    private  void subPermutation(char[] str, int start, TreeSet<String> res)
    {
        if (start==str.length-1){
            res.add(String.valueOf(str));
        }
        else {
                for (int i = start; i < str.length; i++) {
                    if (i!=start&&str[i]==str[start])
                        continue;
                    swap(str, start, i);
                    subPermutation(str, start+1, res);  //回溯法
                    swap(str, start,i);
                }
            }
    }
    private void swap(char[] str, int i,int j)
    {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        Permutation sol = new Permutation();
        res = sol.Permutation("abcd");
        System.out.println(res.toString());

    }
}

import java.util.LinkedHashMap;


public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str==null)
            return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0;i<str.length();i++)
        {
            if (!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i),1);
            else {
                int times = map.get(str.charAt(i));
                map.put(str.charAt(i),++times);
            }
        }
        for (int i=0;i<str.length();i++)
        {
            if (map.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar sol = new FirstNotRepeatingChar();
        System.out.println(sol.FirstNotRepeatingChar("abbcasdjhqwuad"));
    }
}

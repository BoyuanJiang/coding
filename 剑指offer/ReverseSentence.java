public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str.length()==0)
            return "";
        int begin = 0, end = str.length()-1;
        char[] tmp = str.toCharArray();
        Inverse(tmp, begin, end);
        begin=0;
        for (int i=0;i<str.length();i++)
        {
            if (tmp[i]==' ')
            {
                Inverse(tmp,begin,i-1);
                begin=i+1;
            }
        }
        Inverse(tmp,begin,end);
        return new String(tmp);
    }

    private void Inverse(char[] tmp, int begin, int end)
    {
        while (begin<end)
        {
            char t = tmp[begin];
            tmp[begin] = tmp[end];
            tmp[end] = t;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseSentence sol = new ReverseSentence();
        System.out.println(sol.ReverseSentence("I am a student."));
        System.out.println(sol.ReverseSentence("Wonderful"));
    }
}

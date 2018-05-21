public class StrToInt {
    boolean isValid = true;
    public int StrToInt(String str) {
        if (str==null||str.length()==0){
            isValid=false;
            return 0;
        }
        if (str.length()==1&&(str.charAt(0)=='+'||str.charAt(0)=='-'))
        {
            isValid=false;
            return 0;
        }
        boolean sign=true;
        int num=0;
        for (int i=0;i<str.length();i++)
        {
            if (str.charAt(i)=='+'||str.charAt(i)=='-')
            {
                if (i==0)
                    sign=str.charAt(i)=='+';
                else {
                    isValid=false;
                    return 0;
                }
            }
            else if (str.charAt(i)>='0'&&str.charAt(i)<='9')
                num=num*10+str.charAt(i)-'0';
            else {
                isValid=false;
                return 0;
            }
        }
        return sign?num:-num;
    }

    public static void main(String[] args) {
        StrToInt sol = new StrToInt();
        System.out.println(sol.StrToInt(""));
    }
}

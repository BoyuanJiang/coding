public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        int len=str.length();
        if (len==0)
            return "";
        str+=str;
        return str.substring(n%len,n%len+len);
    }

    public static void main(String[] args) {
        LeftRotateString sol = new LeftRotateString();
        System.out.println(sol.LeftRotateString("abcdef",2));
    }
}

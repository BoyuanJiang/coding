//一只青蛙一次可以跳1个台阶,也可以跳2个台阶,跳上n个台阶有几种跳法
public class JumpFloor {
    public int JumpFloor0(int target) {
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        return JumpFloor0(target-1)+JumpFloor0(target-2);
    }

    public int JumpFloor(int target) {
        int res[] = {1,2};
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        int a=1,b=2,sum=0;
        for (int i=3;i<=target;i++)
        {
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }


}

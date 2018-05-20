import java.util.Stack;

public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode0(ListNode pHead1, ListNode pHead2) {
        //使用两个辅助栈，
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        ListNode pre=null;
        while (pHead1!=null)
        {
            st1.add(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null)
        {
            st2.add(pHead2);
            pHead2=pHead2.next;
        }
        while (!st1.isEmpty()&&!st2.isEmpty()&&st1.peek()==st2.peek())
        {
            pre=st1.pop();
            st2.pop();
        }
        return pre;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //计算两个链表的长度，让长的先走一步，长度同步后再一起走
        int len1 = GetListLength(pHead1);
        int len2 = GetListLength(pHead2);

        int diffLen = Math.abs(len1-len2);
        ListNode longHead = pHead2;
        ListNode shortHead = pHead1;
        if (len1>=len2)
        {
            longHead = pHead1;
            shortHead = pHead2;
        }

        for (int i=0;i<diffLen;i++)
            longHead=longHead.next;
        while (longHead!=shortHead)
        {
            longHead=longHead.next;
            shortHead=shortHead.next;
        }
        return longHead;
    }

    private int GetListLength(ListNode pHead)
    {
        ListNode tmp = pHead;
        int lens = 0;
        while (tmp!=null)
        {
            lens++;
            tmp = tmp.next;
        }
        return lens;
    }
}

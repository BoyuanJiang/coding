public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head.next;
        while (curr!=null)
        {
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] array = {1};
        ListNode head = new ListNode(array[0]);
        ListNode tmp = head;
        for (int i=1;i<array.length;i++) {
            tmp.next = new ListNode(array[i]);
            tmp = tmp.next;
        }
        head = ReverseList(head);
        System.out.println(head.val);
    }
}

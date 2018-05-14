public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public static ListNode FindKthToTail0(ListNode head, int k) {
//            需要遍历整个链表两次
            if (head==null)
                return null;
            ListNode tmp = head;
            int len=0;
            while (tmp!=null){
                tmp=tmp.next;
                len++;
            }
            k=len-k+1;
            int count=1;
            while (count!=k&&head!=null)
            {
                head = head.next;
                count++;
            }
            if (count==k)
                return head;
            else
                return null;

        }

        public static ListNode FindKthToTail(ListNode head, int k) {
            //维护两个指针,之间相差k-1步,只需要遍历链表一次
            if (k==0||head==null)
                return null;
            ListNode head1 = head;
            ListNode head2 = head;
            int count=0;
            while (head1.next!=null)
            {
                if (count<k-1)
                {
                    head1=head1.next;
                    count++;
                }
                else {
                    head1=head1.next;
                    head2=head2.next;
                }
            }
            if (count==k-1)
                return head2;
            else
                return null;
        }

        public static void main(String[] args) {
            int[] array = {1,2,3,4,5};
            ListNode head = new ListNode(array[0]);
            ListNode tmp = head;
            for (int i=1;i<array.length;i++) {
                tmp.next = new ListNode(array[i]);
                tmp = tmp.next;
            }
            head = FindKthToTail(head,6);
            System.out.println(head.val);

        }
    }
}

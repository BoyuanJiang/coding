public class Merge {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        ListNode merged = new ListNode(0);
        ListNode mergedHead = merged;
        while (list1!=null || list2!=null)
        {
            if (list1==null)
            {
                merged.next = list2;
                merged = merged.next;
                list2 = list2.next;
            }
            else if (list2==null){
                merged.next = list1;
                merged = merged.next;
                list1 = list1.next;
            }
            else if (list1.val<list2.val)
            {
                merged.next = list1;
                merged = merged.next;
                list1=list1.next;
            }
            else if (list1.val>=list2.val){
                merged.next = list2;
                merged = merged.next;
                list2=list2.next;
            }
        }
        return mergedHead.next;
    }

    public static void main(String[] args) {
        int[] array1 = {15};
        int[] array2 = {10};
        ListNode head1 = new ListNode(array1[0]);
        ListNode head2 = new ListNode(array2[0]);
        ListNode head3 = null;
        ListNode tmp1 = head1;
        for (int i=1;i<array1.length;i++) {
            tmp1.next = new ListNode(array1[i]);
            tmp1 = tmp1.next;
        }
        ListNode tmp2 = head2;
        for (int i=1;i<array2.length;i++) {
            tmp2.next = new ListNode(array2[i]);
            tmp2 = tmp2.next;
        }

        head3 = Merge(head1,head2);
        while (head3!=null)
        {
            System.out.println(head3.val);
            head3=head3.next;
        }
    }
}

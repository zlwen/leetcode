class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        int carry = 0;
        ListNode p = head;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode(0);
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                node.val = sum - 10;
                carry = 1;
            } else {
                node.val = sum;
                carry = 0;
            }
            p.next = node;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        while (l1 != null) {
            ListNode node = new ListNode(0);
            int sum = l1.val + carry;
            if (sum >= 10) {
                node.val = sum - 10;
                carry = 1;
            } else {
                node.val = sum;
                carry = 0;
            }
            p.next = node;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            ListNode node = new ListNode(0);
            int sum = l2.val + carry;
            if (sum >= 10) {
                node.val = sum - 10;
                carry = 1;
            } else {
                node.val = sum;
                carry = 0;
            }
            p.next = node;
            l2 = l2.next;
            p = p.next;
        }
        if (carry != 0) {
            p.next = new ListNode(1);
        }
        return head.next;
    }
}

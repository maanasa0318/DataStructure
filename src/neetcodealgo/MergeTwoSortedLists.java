package neetcodealgo;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		
		
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(4);
		// time O(n log k) space o(log k)
		ListNode res = mergeTwoLists(head, head1);
		System.out.println(res);
		
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				curr.next = l1;
				l1= l1.next;
			}else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		if(l1 != null) {
			curr.next = l1;
		}
		if(l2 != null) {
			curr.next = l2;
		}
		
		return dummy.next;
	}

}

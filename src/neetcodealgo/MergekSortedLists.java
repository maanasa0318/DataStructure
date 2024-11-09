package neetcodealgo;

import java.util.List;

public class MergekSortedLists {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		
		
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(4);
		
		ListNode[] lists = new ListNode[] {head, head1};
		
		ListNode res = mergeKLists(lists) ;
	}

	private static ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}
		return divide(lists, 0, lists.length-1);
	}

	private static ListNode divide(ListNode[] lists, int l, int r) {
		if( l > r) {
			return null;
		}
		if(l == 1) {
			return lists[l];
		}
		int m = 1 + (r - l)/ 2;
		ListNode left = divide(lists, l, m);
		ListNode right = divide(lists, m-1, l);
		
		return conqure(left, right);
	}

	private static ListNode conqure(ListNode left, ListNode right) {

		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while(left != null && right !=null) {
			if( left.val < right.val) {
				curr = left;
				left = left.next;
			}else {
				curr = right;
				right = right.next;
			}
			curr = curr.next;
		}
		
		if(left != null) {
			curr = left.next;
		}
		if(right != null) {
			curr = right.next;
		}
		
		return dummy.next;
	}

	

}

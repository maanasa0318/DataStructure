package neetcodealgo;

public class ReverseLinkedList1 {

	public static void main(String[] args) {

		ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        head.next.next.next.next.next = new ListNode1(6);
        
        System.out.print("Given Linked List:");
        System.out.println(head);
		
        ListNode1 res =  reverseList(head);
        System.out.println(res);
		
	}

	private static ListNode1 reverseList(ListNode1 head) {
		ListNode1 curr = head;
		ListNode1 prev = null;
		 
		while(curr != null) {
			//swap
			ListNode1 temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			
		}
		return prev;
	}
	

}

class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1() {
	}

	ListNode1(int val) {
		this.val = val;
	}

	ListNode1(int val, ListNode1 next) {
		this.val = val;
		this.next = next;
	}
}


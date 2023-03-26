/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head; // Node immediately before the current group
		ListNode node, reverse, nodeNext, curr, prevNext = null;
		int l = 2; // The head doesn't need to be reversed since it's a group of one node, so starts with length 2
		int n = 0;
		while(prev.next != null){
			node = prev;
			n = 0;
			for (int i = 0; i < l; i ++){
				if(node.next == null)
                    break;
				n++;
				node=node.next;
			}
            
			if(n % 2 != 0) // odd length
			   prev = node; 
            
			else{
				reverse = node.next;
				curr = prev.next;
                for(int j=0; j < n;j++){
                    nodeNext = curr.next;
				    curr.next = reverse;
				    reverse = curr;
				    curr = nodeNext;
                }
                prevNext = prev.next;
				prev.next = node;
			    prev = prevNext;
			}
			l++;
		}
	    return head;
    }
}


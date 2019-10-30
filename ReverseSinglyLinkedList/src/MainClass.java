
class LinkedList {
	public Node node;

	class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	@Override
	public String toString() {
		String result = "";
		Node n = node;
		while (n != null) {
			result += n.value + " ";
			n = n.next;
		}
		return result;
	}
}

public class MainClass {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.node = linkedList.new Node(2);
		linkedList.node.next = linkedList.new Node(3);
		linkedList.node.next.next = linkedList.new Node(4);
		linkedList.node.next.next.next = linkedList.new Node(5);
		linkedList.node.next.next.next.next = linkedList.new Node(6);
		System.out.println(linkedList);
		linkedList = reverseLinkedList(linkedList);
		System.out.println(linkedList);
	}

	// steps to reverse singly linkedlist

	/*
	 * 1- current = head 2- prev = null 3- next = current.next -> next state 4-
	 * current.next = prev -> setting back-up 5- prev = current -> securing current
	 * state with prev-back-up 6- current = next -> moving current
	 */
	private static LinkedList reverseLinkedList(LinkedList linkedList) {
		LinkedList li = new LinkedList();
		LinkedList.Node current = linkedList.node;
		LinkedList.Node prev = null;
		LinkedList.Node next = null;
		while (current != null) {
			next = current.next; //next 
			current.next = prev;// back-up
			prev = current;// securing current state
			current = next;// current to next
		}
		li.node = prev;
		return li;
	}

//	private static LinkedList reverseLinkedList(LinkedList linkedList) {
//		LinkedList reverse = new LinkedList();
//		LinkedList.Node curr = linkedList.node;
//		LinkedList.Node pre = null;
//		LinkedList.Node next = null;
//		while (curr != null) {
//			next = curr.next;
//			curr.next = pre;
//			pre = curr;
//			curr = next;
//		}
//		reverse.node = pre;
//		return reverse;
//	}
}

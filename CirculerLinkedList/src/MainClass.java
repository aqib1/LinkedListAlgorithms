
class LinkedList {
	public Node node;

	class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}
}

public class MainClass {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.node = linkedList.new Node(2);
		linkedList.node.next = linkedList.new Node(3);
		linkedList.node.next.next = linkedList.new Node(4);
		linkedList.node.next.next.next = linkedList.new Node(5);
		linkedList.node.next.next.next.next = linkedList.node;

		boolean isCircular = checkCirculerList(linkedList);
		System.out.println(isCircular);
	}

	private static boolean checkCirculerList(LinkedList linkedList) {
		LinkedList.Node slow = linkedList.node;
		LinkedList.Node fast = linkedList.node;
		while (fast != null) {
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				fast = fast.next;
			}
			slow = slow.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
}

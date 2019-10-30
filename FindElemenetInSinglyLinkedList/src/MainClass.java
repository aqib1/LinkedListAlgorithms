import com.example.list.LinkedList;

public class MainClass {

	public static int findMiddleElement(LinkedList<Integer> li) {
		return li.findMiddleElementUtalizingSize();
	}

	public static void main(String[] args) {
		LinkedList<Integer> li = new LinkedList<Integer>()
				.push(1)
				.push(2)
				.push(3)
				.push(4)
				.push(5)
				.push(6);
		li.remove(5);
		System.out.println(li);
		
//		java.util.LinkedList<Integer> t = new java.util.LinkedList<>();
//		t.push(1);
//		t.push(2);
//		t.push(3);
//		t.remove(0);
//		System.out.println(t);
	}
}

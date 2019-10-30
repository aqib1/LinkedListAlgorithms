import com.example.list.LinkedList;

public class MainClass {
	
	public static int findMiddleElement(LinkedList<Integer> li) {
		return li.findMiddleElementUtalizingSize();
	}
	
	public static void main(String[] args) {
			System.out.println(
					findMiddleElement(new LinkedList<Integer>().push(1)
					.push(2)
					.push(3)
					.push(4)
					.push(5)
					.push(6)
				   ));
	}
}

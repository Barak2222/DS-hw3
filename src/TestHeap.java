
public class TestHeap {

	public static void main(String[] args) {
		test1();

	}
	
	
	public static void test1(){
		Person[] arr = {
			new Person(8978, 22),
			new Person(3333, 40),
			new Person(3333, 33),
			new Person(3333, 32),
			new Person(3333, 39),
			new Person(3333, 50),
			new Person(3333, 80),
			new Person(3333, 70),
			new Person(3333, 46),
			new Person(3333, 85),
			new Person(3333, 17),
			new Person(3333, 29),
		};
		MyHeap h1 = new MyHeap(arr, 12);
		h1.print();
		System.out.println("dani");
		System.out.println(h1.FindMax());
		h1.insert(new Person(2323, 100));
		h1.print();
		h1.insert(new Person(2323, 4));
		h1.print();
		h1.DeleteMax();
		h1.DeleteMax();
		h1.DeleteMax();
		h1.print();
	}
}

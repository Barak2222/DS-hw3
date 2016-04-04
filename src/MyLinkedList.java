public class MyLinkedList {
	private Node head;
	protected int size;
	
	public MyLinkedList() {
		head = new Node();
		size = 0;
	}

	public void insert(Person p) {
		head.next = new Node(p, head.next);
		size++;
	}

	public Person get(int n){
		if(n > size || n <= 0){ //count from 1
			throw new NullPointerException();
		}
		int i = 0;
		Node node = head;
		while(i <n){
			node = node.next;
			i++;
		}
		return node.data;
	}
	
	public Node find(Person p) { // {TODO} daniel's HW
	}

	public void delete(Person p) {
		Node prev = head;
		Node current = head.next;
		while(current != null){
			if( current.data == p){
				prev.next = current.next;
			}
		}
	}
	
		public ListElement getLast(){
		
	}

}

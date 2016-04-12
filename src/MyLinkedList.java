public class MyLinkedList {
	private Node head;
	protected int size;
	
	/***
	 * Constrctor
	 * @param p Array of people
	 * @param numPeople number of people in the array
	 */
	public MyLinkedList(Person[] p, int numPeople){
		this();
		size = numPeople;
		for (int i = 0; i < numPeople; i++) {
			insert(p[i]);
		}
	}
	
	/***
	 * Empty constructor
	 */
	public MyLinkedList() {
		head = new Node();
		size = 0;
	}

	/***
	 * Insert person to the list
	 * @param p person to insert
	 */
	public void insert(Person p) {
		head.next = new Node(p, head.next);
		size++;
	}

	/***
	 * Find the nth person of the list
	 * @param n index
	 * @return the nth person
	 */
	public Person get(int n){
		if(n > size || n <= 0){ //count from 1
			throw new NullPointerException(n + "is <= 0 or > " + size);
		}
		int i = 0;
		Node node = head;
		while(i <n){
			node = node.next;
			i++;
		}
		return node.data;
	}
	
	/***
	 * find the person who matches a given id
	 * @param id of the needed person
	 * @return the needed person
	 */
	public Person find(int id) {
		Node node = head.next;
		while(node != null && node.data.getId() != id){
			node = node.next;
		}
		if(node != null){
			return node.data;
		}
		return null;
	}

	/***
	 * Deletes a person 
	 * @param p person
	 */
	public void delete(Person p) {
		Node prev = head;
		Node current = head.next;
		while(current != null){
			if( current.data.getId() == p.getId()){
				prev.next = current.next;
				size--;
				return ;
			}
			prev = prev.next;
			current = current.next;
		}
	}
	
	/***
	 * prints the list
	 */
	public void print(){
		Node n = head.next;
		System.out.print("list: ");
		while(n!=null){
			System.out.print(n.data.getAge() + " |");
			n = n.next;
		}
		System.out.println();
	}
	
}

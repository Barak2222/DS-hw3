
public class Node {
	protected Person data;
	protected Node next;
	
	/***
	 * Constructor
	 * @param p person
	 * @param next next node
	 */
	public Node(Person p, Node next){
		this.data = p;
		this.next = next;
	}
	
	/***
	 * Empty constructor
	 */
	public Node(){
		this(null, null);
	}
	
	/***
	 * Constructor
	 * @param p person
	 */
	public Node(Person p){
		this(p, null);
	}
}

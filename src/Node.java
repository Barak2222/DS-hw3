
public class Node {
	protected Person data;
	protected Node next;
	
	public Node(Person p, Node next){
		this.data = p;
		this.next = next;
	}
	
	public Node(){
		this(null, null);
	}
	
	public Node(Person p){
		this(p, null);
	}
}


public class MyHeap2 {

	protected int size;
	protected TreeNode root;

	/***
	 * 
	 * @param p array of people
	 * @param numPeople number of people
	 */

	public MyHeap2(Person[] p, int numPeople) {
		MyHeap temp = new MyHeap(p, numPeople);
		Person[] h = temp.holder;
		size = numPeople;
		TreeNode[] arr = new TreeNode[h.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new TreeNode(h[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i].parent = (i/2 > 0) ? arr[i/2] : null;
			arr[i].left = (i*2 < arr.length) ? arr[i*2] : null;
			arr[i].right = (i*2 + 1 < arr.length) ? arr[i*2 + 1] : null;
		}
		root = arr[0];
	}


	/***
	 * Empty constructor
	 */
	public MyHeap2(){
		root = null;
		size = 0;
	}

	/***
	 * 
	 * @param p
	 *            person to add
	 * @param i
	 *            position
	 */
	private void percDown(Person p, TreeNode node) {
		if(node.isLeaf()){
			node.data = p;
		} else if (node.right == null){ // only has left child
			if( node.left.data.getAge() > node.data.getAge()){
				node.data = node.left.data;
				node.left.data = p;
			} else {
				node.data = p;
			}
		} else { // node is not a leaf
			TreeNode look = (node.left.data.getAge() > node.right.data.getAge()) ? node.left : node.right;
			if(look.data.getAge() > p.getAge()){
				node.data = look.data;
				percDown(p, look);
			} else {
				node.data = p;
			}
		}
	}

	/***
	 * 
	 * @param p
	 *            person to add
	 * @param i
	 *            position
	 */
	private void percUp(Person p, TreeNode node) {
		if (node == root) {
			node.data = p;
			return;
		}
		if (p.getAge() < node.parent.data.getAge()) {
			node.data = p;
			return;
		}
		node.data = node.parent.data;
		percUp(p, node.parent);
	}

	/***
	 * 
	 * @return The oldest person
	 */
	public Person FindMax() {
		return root.data;
	}

	/***
	 * 
	 * @param p
	 *            person to insert
	 */
	public void insert(Person p) {
		int spot = size + 1;
		TreeNode node = createLastNode(root, spot);
		size++;
		percUp(p, size);
	}
	
	private TreeNode createLastNode(TreeNode current, int spot){
		if(spot > 1){
			createLastNode(current, spot/2);
		}
		
		if(current.isLeaf()){
			return current;
		}
		if(current.left != null && current.right == null){
			return current; // found the parent of the node that needs to be added
		}		
	}
	

	/***
	 * utility function that doubles the maxSize
	 */
	private void resize() {
		maxSize = maxSize * 2;
		Person[] holder2 = new Person[maxSize];
		for (int i = 0; i < holder.length; i++) {
			holder2[i] = holder[i];
		}
		holder = holder2;
	}

	/***
	 * delete the oldest person from the heap
	 */
	public void DeleteMax() {
		if (size <= 0) {
			throw new IllegalArgumentException("heap is empty, cannot delete");
		}
		percDown(holder[size], 1);
		size--;
	}

	/***
	 * prints the heap
	 */
	public void print() {
		System.out.print("arr: [");
		for (int i = 0; i <= size; i++) {
			System.out.print(holder[i] + " |");
		}
		System.out.println("]");
	}
}

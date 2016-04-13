
public class MyHeap {

	protected int size;
	protected TreeNode root;

	/***
	 * 
	 * @param p
	 *            array of people
	 * @param numPeople
	 *            number of people
	 */

	public MyHeap(Person[] p, int numPeople) {
		MyHeap2 temp = new MyHeap2(p, numPeople);
		Person[] h = temp.holder;
		size = numPeople;
		TreeNode[] arr = new TreeNode[h.length];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = new TreeNode(h[i]);
		}

		for (int i = 1; i < arr.length; i++) {
			arr[i].parent = (i / 2 > 0) ? arr[i / 2] : null;
			arr[i].left = (i * 2 < arr.length) ? arr[i * 2] : null;
			arr[i].right = (i * 2 + 1 < arr.length) ? arr[i * 2 + 1] : null;
		}
		root = arr[0];
	}

	/***
	 * Empty constructor
	 */
	public MyHeap() {
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
		if (node.isLeaf()) {
			node.data = p;
		} else if (node.right == null) { // only has left child
			if (node.left.data.getAge() > node.data.getAge()) {
				node.data = node.left.data;
				node.left.data = p;
			} else {
				node.data = p;
			}
		} else { // node is not a leaf
			TreeNode look = (node.left.data.getAge() > node.right.data.getAge()) ? node.left : node.right;
			if (look.data.getAge() > p.getAge()) {
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
		if (size == 0) {
			insertFirst(p);
			return ;
		}
		size++;
		TreeNode parent = get(root, size/2);// parent of the new node that needs to be added
		TreeNode newNode = new TreeNode(p, parent);
		if (parent.left == null) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}

		percUp(p, newNode);
	}

	private TreeNode get(TreeNode current, int spot) {
		if (spot > 3) {
			current = get(current, spot / 2);
		}
		if (current.left == null || current.right == null) {
			return current;
		}
		if (spot % 2 == 0) {
			return current.left;
		}
		return current.right;
	}

	/**
	 * private TreeNode parentOfNewNode(){ int[] indexArr = new int[size]; int i
	 * = 0; int spot = size + 1; while(spot > 1){ indexArr[i] = spot/2; i++;
	 * spot/=2; }
	 * 
	 * TreeNode current = root;
	 * 
	 * 
	 * 
	 * if(spot > 1){ spot = spot/2 createLastNode(current, spot); }
	 * 
	 * if(current.isLeaf()){ return current; } if(current.left != null &&
	 * current.right == null){ return current; // found the parent of the node
	 * that needs to be added } }
	 */

	private void insertFirst(Person p) {
		root = new TreeNode(p);
		size = 1;
	}

	/***
	 * delete the oldest person from the heap
	 */
	public void DeleteMax() {
		if (size <= 0) {
			throw new IllegalArgumentException("heap is empty, cannot delete");
		}
		Person p;
		TreeNode parentOfLast = get(root, size/2);
		if(parentOfLast.right != null && parentOfLast.left != null){
			p = parentOfLast.right.data;
			parentOfLast.right = null;
		} else {
			p = parentOfLast.left.data;
			parentOfLast.left = null;
		}
		size--;
		percDown(p, root);
	}

	/***
	 * prints the heap
	 */
	public void print() {
		for(int i = 1; i <= size; i++){
			System.out.print("[" + i + "-" + get(root, i).data.getAge() + "] ");
		}
	}
}


public class TreeNode {
	protected TreeNode left;
	protected TreeNode right;
	protected TreeNode parent;
	protected Person data;
	
	public TreeNode(){
		left = null;
		right = null;
		parent = null;
		data = null;
	}
	
	public TreeNode(Person p){
		this();
		this.data = p;
	}
	
	public TreeNode(Person p, TreeNode parent){
		this(p);
		this.parent = parent;
	}
	
	public TreeNode(Person p, TreeNode parent, TreeNode r, TreeNode l){
		this(p, parent);
		this.right = r;
		this.left = l;
	}
	
	public boolean isLeaf(){
		return right == null && left == null;
	}
}
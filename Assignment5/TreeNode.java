/**
 * 
 * @author sairam
 *
 * @param <T>
 */
public class TreeNode<T> {

	private T dataNode;
	private TreeNode right;
	private TreeNode left;

	/**
	 * constructor calling parent class and initializing data-node
	 * @param dataNode
	 */
	public TreeNode(T dataNode) 
	{
		super();
		this.dataNode = dataNode;
	}
	
	/**
	 * constructor for all nodes
	 * @param dataNode
	 */
	public TreeNode(TreeNode<T> dataNode) {
		super();
		this.dataNode = (T) dataNode;
		this.left = dataNode.left;
		this.right = dataNode.right;
		
	}
	/**
	 * sets the data
	 * @param data
	 */
	public void setData(T data)
	{
		this.dataNode = data;
	}
	
	/**
	 * 
	 * @returns the data-node
	 */
	public T getData() {
		return dataNode;
		}
	
	/**
	 * sets the left node to the current node
	 * @param present
	 */
	public void setLeft(TreeNode<String> present) {
		this.left = present;
		
	}
	
	/**
	 * 
	 * @returns left node
	 */
	public TreeNode<String> getLeft() {
		return left;
	}
	
	/**
	 * sets the right node to the current node
	 * @param present
	 */
	public void setRight(TreeNode<String> present) {
		this.right = present;
		
	}

	/**
	 * 
	 * @return right node
	 */
	public TreeNode<String> getRight() {
		return right;
	}
	
	/**
	 * returns toString
	 */
	public String toString()
	{
		return "Data: " + dataNode + " Left: " + left + " Right: " + right;
	}
}

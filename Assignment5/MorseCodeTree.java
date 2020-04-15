
import java.util.ArrayList;
/**
 * 
 * @author sairam
 *
 * @param <T>
 */
public class MorseCodeTree<T> implements LinkedConverterTreeInterface<String>{

	TreeNode<String> rootNode;
	
	/**
	 * constructor that calls the buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	
	/**
	 * @returns rootNode
	 */
	@Override
	public TreeNode<String> getRoot() {
		
		return this.rootNode;
	} 
	
	/**
	 * @param newNode
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {

		rootNode = newNode;
		
	}

	/**
	 * @param code, outcome
	 */
	@Override
	public MorseCodeTree<String> insert(String code, String outcome) {

		if(rootNode==null)
		{
			setRoot(new TreeNode<String>(outcome));
		}
		else
		{
			addNode(rootNode, code, outcome);
		}
			
		return (MorseCodeTree<String>) this;
	}
	
	/**
	 * @param rootNode, code, letter
	 * method to add node to the tree
	 */
	@Override
	public void addNode(TreeNode<String> rootNode, String code, String letter) {
		TreeNode<String> root2 = rootNode;
		TreeNode<String> present = rootNode;
		
		String code2 = null;
		
		if(code.toString().length() == 1)
		{
			if(code.toString().contains("."))
			{
				present = new TreeNode<String> (letter);
				root2.setLeft(present);
			}
			if(code.toString().contains("-"))
			{
				present = new TreeNode<String> (letter);
				root2.setRight(present);
			}
			return;
			
		}
		else {
			if(code.toString().charAt(0) == '.')
			{
				root2 = present.getLeft();
			}
			
			if(code.toString().charAt(0) == '-')
			{
				root2 = present.getRight();
			}
			code2 = code.toString().substring(1);
		}
		addNode(root2, code2, letter);
	}

	/**
	 * @returns the result of fetchNode
	 */
	@Override
	public String fetch(String code) {
		
			return fetchNode(rootNode, code);
	}
	
	/**
	 * method for fetching the node
	 * 
	 */
	@Override
	public String fetchNode(TreeNode<String> rootNode, String code) {

		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				return rootNode.getLeft().getData().toString();
			}
			else
			{
				return rootNode.getRight().getData().toString();
			}
		}
		else
		{
			if(code.charAt(0) == '.')
			{
				return fetchNode(rootNode.getLeft(), code.substring(1));
			}
			else
			{
				return fetchNode(rootNode.getRight(), code.substring(1));
			}
		}
	}
	
	/**
	 * this operation is not supported in the MorseCodeTree
	 */
	@Override
	public MorseCodeTree<String> delete(String element) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * this operation is not supported in the MorseCodeTree
	 */
	@Override
	public MorseCodeTree<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * method to build the tree
	 */
	@Override
	public void buildTree() {
		
		// root level 
		rootNode = new TreeNode<String>("");
		
		//first level
		insert(".", "e");
		insert("-", "t");
		
		//second level
		
		insert(". .", "i");
		insert(".-", "a");
		insert("-.", "n"); 
		insert("--", "m");
		
		//third level
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//fourth level
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	
	/**
	 * @returns the tree display
	 */
	@Override
	public ArrayList<String> toArrayList() {
		
		ArrayList<String> displayTree = new ArrayList<String>();
		
		LNRoutputTraversal(rootNode, displayTree);

		return displayTree;
	}

	/**
	 * method that traverses the left and right output
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> rootNode, ArrayList<String> traversalList) {
		if(rootNode != null)
		{
			LNRoutputTraversal(rootNode.getLeft(), traversalList);
			traversalList.add(rootNode.getData());
			LNRoutputTraversal(rootNode.getRight(), traversalList);
		}
		
	}
	
}

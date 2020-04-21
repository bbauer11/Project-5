import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;
	
	public MorseCodeTree() {
		buildTree();
 	}

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
			if (code.charAt(0) == '.')
				root.setLeft(new TreeNode<String>(letter));
			else if (code.charAt(0) == '-') 
				root.setRight(new TreeNode<String>(letter));
			return;
		} else {
			if (code.charAt(0) == '.') 
				addNode(root.getLeft(), code.substring(1), letter);
			else if (code.charAt(0) == '-')
				addNode(root.getRight(), code.substring(1), letter);
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	
	/**
	 * If code is not a letter in morse code, returns null;
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				if (root.getLeft() != null)
					return root.getLeft().getData();
				else 
					return null;
					
			} else if (code.charAt(0) == '-') {
				if (root.getRight() != null)
					return root.getRight().getData();
				else
					return null;
			}
		} else {
			if (code.charAt(0) == '.') 
				return fetchNode(root.getLeft(), code.substring(1));
			else if (code.charAt(0) == '-')
				return fetchNode(root.getRight(), code.substring(1));
		}
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		root = new TreeNode<String>("");
		// lvl 1
		insert(".", "e");
		insert("-", "t");
		// lvl 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		// lvl 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		// lvl 4
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
		// end
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> toReturn = new ArrayList<String>();
		this.LNRoutputTraversal(root, toReturn);
		return toReturn;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root.getLeft() != null)
			this.LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		if (root.getRight() != null) 
			LNRoutputTraversal(root.getRight(), list);
	}
	
	
	
}


public class TreeNode<T> {

	private TreeNode<T> left, right;
	private T data;
	
	 public TreeNode(T data) {
		 this.data = data;
		 left = null;
		 right = null;
	 }
	  
	 public TreeNode(TreeNode<T> node) {  //deep copy
		 this.data = node.data;
		 left = new TreeNode<T>(node.left);
		 right = new TreeNode<T>(node.right);
	 }
	 
	 public T getData() {
		 return data;
	 }
	
	 public TreeNode<T> getLeft() {
		 return left;
	 }
	 
	 public TreeNode<T> getRight() {
		 return right;
	 }
	 
	 public void setLeft(TreeNode<T> node) {
		 this.left = node;
	 }
	 
	 public void setRight(TreeNode<T> node) {
		 this.right = node;
	 }
}

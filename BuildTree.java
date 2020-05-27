import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

	public static TreeNode buildTree(Queue<Integer> queue) {
		Queue<TreeNode> node = new LinkedList<>();
		TreeNode root = new TreeNode(queue.poll());
		node.add(root);
		while (!node.isEmpty()&&!queue.isEmpty()) {
			TreeNode curr = node.poll();
			if(curr.left==null&&!queue.isEmpty()){
				int l = queue.poll();
				curr.left = new TreeNode(l);
				node.add(curr.left);
			}
			if(curr.right==null&&!queue.isEmpty()){
				int r = queue.poll();
				curr.right = new TreeNode(r);
				node.add(curr.right);
			}
			
			
		}
		
		return root;

	}

	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<7;i++){
			queue.add(i);
		}
		TreeNode root =buildTree(queue);	 	
		System.out.println(treeTraversal.inOrderTraversal(root));
		
	}
}

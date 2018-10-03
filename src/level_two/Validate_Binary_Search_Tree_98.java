package level_two;

import java.util.ArrayList;
import java.util.List;

public class Validate_Binary_Search_Tree_98 {
	public static void main(String[] args) {
		/**
		 * Given a binary tree, determine if it is a valid binary search tree (BST).
		 *
		 * Assume a BST is defined as follows:
		 *
		 * The left subtree of a node contains only nodes with keys less than the node's key.
		 * The right subtree of a node contains only nodes with keys greater than the node's key.
		 * Both the left and right subtrees must also be binary search trees.
		 *
		 *     5
		 *    / \
		 *   1   4
		 *      / \
		 *     3   6
		 * Output: false
		 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
		 *              is 5 but its right child's value is 4.
		 */
	}

	List<Integer> list = new ArrayList<Integer>();

	public boolean isValidBST(TreeNode root) {
		/**
		 * 何为二分查找树？1) 左子树的值都比根节点小；2) 右子树的值都比根节点大；3) 左右子树也必须满足上面两个条件。
		 * 需要注意的是，
		 * 左子树的所有节点都要比根节点小，而非只是其左孩子比其小，右子树同样。
		 * 这是很容易出错的一点是，很多人往往只考虑了每个根节点比其左孩子大比其右孩子小。
		 *
		 * ---------------------
		 *
		 */

		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		inOrderTraversal(root);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	public void inOrderTraversal(TreeNode root) {
		if (root == null) return;

		inOrderTraversal(root.left);
		list.add(root.val);
		inOrderTraversal(root.right);
	}


	public class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
	}

}

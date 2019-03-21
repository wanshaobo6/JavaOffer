package com.example2.p48_hasSubstrr;
/**
 *  面试题26: 树的子结构
 *  	题目: 输入两棵二叉树A和B,判断B是不是A的子结构 
 *  
 *   当A有一个节点与B的根节点值相同时，则需要从A的那个节点开始严格匹配，对应于下面的tree1HasTree2FromRoot函数。
 * 如果匹配不成功，则返回到开始匹配的那个节点，对它的左右子树继续判断是否与B的根节点值相同，重复上述过程。
 * 应注意，必须先比较root2的节点是否为空
 * @author 万少波
 *
 */
public class TreeHasSubtree {
	static class TreeNode<T> {
		T val;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}

	
	static boolean hasSubtree(TreeNode<Integer> pRoot1 , TreeNode<Integer> pRoot2){
		if(pRoot1 == null || pRoot2 == null)
			return false;
		boolean result = false;
		System.out.println(pRoot1.val);
		if(pRoot1.val == pRoot2.val)
			result = tree1HasTree2FromRoot(pRoot1,pRoot2);
		if(result)
			return result; 
		return hasSubtree(pRoot1.left,pRoot2) || hasSubtree(pRoot1.right,pRoot2);
	}
	
	static boolean tree1HasTree2FromRoot(TreeNode<Integer> pRoot1 , TreeNode<Integer> pRoot2){
		if(pRoot2 == null)
			return true;
		if(pRoot1 == null)
			return false;
		if(pRoot1.val == pRoot2.val)
			return tree1HasTree2FromRoot(pRoot1.left,pRoot2.left)&&tree1HasTree2FromRoot(pRoot1.right,pRoot2.right);
		return false;
	}
	
	
	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<Integer>(8);
		root1.left = new TreeNode<Integer>(8);
		root1.right = new TreeNode<Integer>(7);
		root1.left.left = new TreeNode<Integer>(9);
		root1.left.right = new TreeNode<Integer>(2);
		root1.left.right.left = new TreeNode<Integer>(4);
		root1.left.right.right = new TreeNode<Integer>(7);
		TreeNode<Integer> root2 = new TreeNode<Integer>(8);
		root2.left = new TreeNode<Integer>(9);
		root2.right = new TreeNode<Integer>(2);
		TreeNode<Integer> root3 = new TreeNode<Integer>(2);
		root3.left = new TreeNode<Integer>(4);
		root3.right = new TreeNode<Integer>(3);
		System.out.println(hasSubtree(root1, root2));
		System.out.println(hasSubtree(root1, root3));
	}
}

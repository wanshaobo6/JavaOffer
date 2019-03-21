package com.example2.p59_SymmetrixBinaryTreeNode;


/**
 * 面试题29:对称的二叉树
 * 		请实现一个函数，用来判断一棵二叉树是不是对称的，如果一棵二叉树和它的镜像一样，那么他是对称的
 *   思路:受前一题的影响 , 刚开始我用于这道题的方法过于死板  生成一棵对称树 然后判断两棵树是不是完全一样 
 *      但是没想到 根左右 和根右左 两种遍历方式同步进行  在这次遍历中两个节点都相等的话就是对称的二叉树
 * @author 万少波
 *
 */
public class SymmetrixBinaryTreeNode {
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
	
	static boolean isSymmetrix(TreeNode treeNode){
		return isSymmetrix(treeNode, treeNode);
	}
	
	static boolean isSymmetrix(TreeNode treeNode1 , TreeNode treeNode2){
		if(treeNode1 == null && treeNode2 == null)
			return true;
		if(treeNode1 == null || treeNode2 == null)
			return false;
		if(treeNode1.val != treeNode2.val)
			return false;
		return isSymmetrix(treeNode1.left,treeNode2.right) && isSymmetrix(treeNode1.right,treeNode2.left);
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<Integer>(8);
		root1.left = new TreeNode<Integer>(8);
		root1.right = new TreeNode<Integer>(7);
		root1.left.left = new TreeNode<Integer>(9);
		root1.left.right = new TreeNode<Integer>(2);
		root1.left.right.left = new TreeNode<Integer>(4);
		root1.left.right.right = new TreeNode<Integer>(7);
		TreeNode<Integer> root2 = new TreeNode<Integer>(9);
		root2.left = new TreeNode<Integer>(8);
		root2.right = new TreeNode<Integer>(8);
		root2.left.left = new TreeNode<Integer>(6);
		root2.left.right = new TreeNode<Integer>(4);
		root2.right.left = new TreeNode<Integer>(4);
		root2.right.right = new TreeNode<Integer>(6);
		System.out.println(isSymmetrix(root1));
		System.out.println(isSymmetrix(root2));
	}
}

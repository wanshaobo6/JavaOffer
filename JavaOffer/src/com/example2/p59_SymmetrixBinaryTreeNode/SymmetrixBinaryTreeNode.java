package com.example2.p59_SymmetrixBinaryTreeNode;


/**
 * ������29:�ԳƵĶ�����
 * 		��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵģ����һ�ö����������ľ���һ������ô���ǶԳƵ�
 *   ˼·:��ǰһ���Ӱ�� , �տ�ʼ�����������ķ�����������  ����һ�öԳ��� Ȼ���ж��������ǲ�����ȫһ�� 
 *      ����û�뵽 ������ �͸����� ���ֱ�����ʽͬ������  ����α����������ڵ㶼��ȵĻ����ǶԳƵĶ�����
 * @author ���ٲ�
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

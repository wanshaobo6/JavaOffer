package com.example3.p71_theDepthOfBinaryTree;

/**
 * 面试题55: 二叉树的深度
 * 	题目一:输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点一次经过的节点（含根、叶节点）形成树的一条路径，
 * 		最长路径的长度为树的深度。
 * @author 万少波
 *
 */
public class TheDepthOfBinaryTree {
	public static void main(String[] args) {
		BinaryTreeNode pRoot = new BinaryTreeNode(1);
		BinaryTreeNode node1 = new BinaryTreeNode(2);
		BinaryTreeNode node2 = new BinaryTreeNode(3);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		pRoot.m_pLeft = node1;
		pRoot.m_pLeft.m_pLeft = node2;
		pRoot.m_pLeft.m_pLeft.m_pLeft = node3;
		System.out.println(treeDepth(pRoot));
	}
	
	/**
	 * 方式1:如果一个节点没有只有左子树，那么深度为左子树深度+1，如果只有右子树，深度为右子树+1
	 * 		左右子树都存在则节点深度为左右子树的最大值+1
	 * @param pRoot
	 * @return
	 */
	public static int treeDepth(BinaryTreeNode pRoot){
		if(pRoot == null)
			return 0;
		int left = treeDepth(pRoot.m_pLeft);
		int right = treeDepth(pRoot.m_pRight);
		return left>right?left+1:right+1;
	}
	
	static class BinaryTreeNode{
		int m_nValue;
		BinaryTreeNode m_pLeft;
		BinaryTreeNode m_pRight;
		
		public BinaryTreeNode(int m_nValue) {
			this.m_nValue = m_nValue;
		}
		
	}
}

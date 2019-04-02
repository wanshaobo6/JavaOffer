package com.example3.p69_KthNodeInBinaryTree;

import java.util.Stack;

import com.example.p63_constructBinaryTree.BinaryTreeNode;

/**
 * 面试题54: 二叉搜索树的第K大节点
 * 		给定一颗二叉搜索树，请找出其中第 k 大的节点?
 * 考点: 二叉搜索树的中序遍历递增
 * @author 万少波
 *
 */
public class KthNodeInBinaryTree {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
        root.m_pLeft = new BinaryTreeNode(3);
        root.m_pLeft.m_pLeft = new BinaryTreeNode(2);
        root.m_pLeft.m_pRight = new BinaryTreeNode(4);
        root.m_pRight = new BinaryTreeNode(7);
        root.m_pRight.m_pLeft = new BinaryTreeNode(6);
        root.m_pRight.m_pRight = new BinaryTreeNode(8);
        System.out.println(kthNode(root,3).m_nValue);//4
        System.out.println(kthNode(root,6).m_nValue);//7
        System.out.println(kthNode(root,8));//null
	}
	/**
	 *	方式1:运用堆栈
	 * @param tNode
	 * @param k
	 * @return
	 */
	static BinaryTreeNode kthNode(BinaryTreeNode tNode , int k){
		if(tNode == null || k <= 0)
			return null;
		Stack<BinaryTreeNode> myStack = new Stack();
		kthNodeCore(tNode, myStack);
		BinaryTreeNode tempNode = null;
		while(k > 0 ){
			if(!myStack.isEmpty())
				tempNode = myStack.pop();
			else
				tempNode = null;
			k--;
		}
		return tempNode;
	}
	static void kthNodeCore(BinaryTreeNode tNode , Stack<BinaryTreeNode> myStack){
		if(tNode.m_pLeft != null){
			kthNodeCore(tNode.m_pLeft, myStack);
		}
		myStack.push(tNode);
		
		if(tNode.m_pRight != null){
			kthNodeCore(tNode.m_pRight, myStack);
		}
	}
	
	
	
	static class BinaryTreeNode{
		private int m_nValue;
		BinaryTreeNode m_pLeft;
		BinaryTreeNode m_pRight;
		
		
		public BinaryTreeNode(int m_nValue) {
			super();
			this.m_nValue = m_nValue;
		}
		
		public int getM_nValue() {
			return m_nValue;
		}
		public void setM_nValue(int m_nValue) {
			this.m_nValue = m_nValue;
		}
		
	}
}
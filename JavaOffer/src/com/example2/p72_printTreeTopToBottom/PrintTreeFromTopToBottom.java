package com.example2.p72_printTreeTopToBottom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *  面试题32: 从上到下打印二叉树
 *  题目一: 不分行从上到下打印二叉树
 *  
 *  思路:  8             打印8下一个确定打印6和10  打印6以后确定打印的10 5 7  打印10确定打印的 5 7 9 11
 *  	6    10   
 *    5  7   9 11
 * @author 万少波
 *
 */
public class PrintTreeFromTopToBottom {
	
	/**
	 * 使用队列实现  Perfect
	 * @param pTreeNode
	 */
	static void printFromTopToBottom(TreeNode<Integer> pTreeNode){
		if(pTreeNode == null)
			return ;
		Queue<TreeNode<Integer>> queue = new LinkedList();
		queue.offer(pTreeNode);
		while(queue.size() != 0){
			TreeNode<Integer> treeNode = queue.poll();
			System.out.println(treeNode.val+" ");
			if(treeNode.left != null)
				queue.offer(treeNode.left);
			if(treeNode.right != null)
				queue.offer(treeNode.right);	
		}
	}

	/**
	 * 蛮力法:不推荐  garbage
	 * @param pTreeNode
	 */
	static void printTreeFromTopToBottom(TreeNode<Integer> pTreeNode){
		if(pTreeNode == null)
			return ;
		List<TreeNode<Integer>> childrens = new ArrayList();
		System.out.println(pTreeNode.val+" ");
		if(pTreeNode.left != null)
			childrens.add(pTreeNode.left);
		if(pTreeNode.right != null)
			childrens.add(pTreeNode.right);	
		printTreeFromTopToBottom(childrens);
	}
	
	static void printTreeFromTopToBottom(List<TreeNode<Integer>> childList){
		if(childList == null || childList .isEmpty())
			return;
		List<TreeNode<Integer>> childrens = new ArrayList();
		for (TreeNode<Integer> treeNode : childList) {
			System.out.println(treeNode.val+" ");
			if(treeNode.left != null)
				childrens.add(treeNode.left);
			if(treeNode.right != null)
				childrens.add(treeNode.right);	
		}
		printTreeFromTopToBottom(childrens);
	}
	
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
	
	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<Integer>(8);
		root1.left = new TreeNode<Integer>(8);
		root1.right = new TreeNode<Integer>(7);
		root1.left.left = new TreeNode<Integer>(9);
		root1.left.right = new TreeNode<Integer>(2);
		root1.left.right.left = new TreeNode<Integer>(4);
		root1.left.right.right = new TreeNode<Integer>(7);
		//printTreeFromTopToBottom(root1);
		printFromTopToBottom(root1);
	}
}

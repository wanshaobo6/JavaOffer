package com.example2.p72_printTreeTopToBottom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *  ������32: ���ϵ��´�ӡ������
 *  ��Ŀһ: �����д��ϵ��´�ӡ������
 *  
 *  ˼·:  8             ��ӡ8��һ��ȷ����ӡ6��10  ��ӡ6�Ժ�ȷ����ӡ��10 5 7  ��ӡ10ȷ����ӡ�� 5 7 9 11
 *  	6    10   
 *    5  7   9 11
 * @author ���ٲ�
 *
 */
public class PrintTreeFromTopToBottom {
	
	/**
	 * ʹ�ö���ʵ��  Perfect
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
	 * ������:���Ƽ�  garbage
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

package com.example2.p72_printTreeTopToBottom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 *  ������32: ���ϵ��´�ӡ������
 *  
 *  
 *  ˼·:  8             ��ӡ8��һ��ȷ����ӡ6��10  ��ӡ6�Ժ�ȷ����ӡ��10 5 7  ��ӡ10ȷ����ӡ�� 5 7 9 11
 *  	6    10   
 *    5  7   9 11
 * @author ���ٲ�
 *
 */
public class PrintTreeFromTopToBottom {
	
	/**  ��Ŀһ:   �����д��ϵ��´�ӡ������
	 *      ��һ����:�����ǹ�����ȱ���һ������ͼ����һ����  ��Ҫ�õ����� 
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
			System.out.print(treeNode.val+" ");
			if(treeNode.left != null)
				queue.offer(treeNode.left);
			if(treeNode.right != null)
				queue.offer(treeNode.right);	
		}
	}
	
	/**
	 * ��Ŀ��: ���д��ϵ��´�ӡ������
	 * ˼·����һ��һ��  ��ʱ����Ҫ��������  һ����ʾ��ǰ�ڵ㻹û��ӡ�ĸ���  һ������һ��ڵ������
	 * @param pTreeNode
	 */
	static void printLnFromTopToBottom(TreeNode<Integer> pTreeNode){
		if(pTreeNode == null)
			return ;
		Queue<TreeNode<Integer>> queue = new LinkedList();
		queue.offer(pTreeNode);
		int curLevel = 1; //��ǰ�ڵ㻹û��ӡ�ĸ���
		int nextLevel = 0;   //��һ��ڵ������
		while(queue.size() != 0){
			TreeNode<Integer> treeNode = queue.poll();
			System.out.print(treeNode.val+" ");
			curLevel -- ;
			if(treeNode.left != null){
				nextLevel ++;
				queue.offer(treeNode.left);
			}
			if(treeNode.right != null){
				nextLevel ++;
				queue.offer(treeNode.right);	
			}
			if(curLevel == 0){
				System.out.println();
				curLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}
	
	/**
	 * ��Ŀ��: ֮���δ�ӡ������
	 * ���� :       1                | 1               |null
	 * 	     2          3
	 * 	  4    5     6     7       | null            | 2 3
	 * 	 8 9 10 11 12 13 14 15     |7 6 5 4          |null
	 * @param pTreeNode		    	|null	         |8 9 10 ....
	 */
	static void printByOppositeDirect(TreeNode<Integer> pTreeNode){
		if(pTreeNode == null)
			return ;
		int current = 0;
		int next = 1;
		//����ֻ�������˵�ַ����û��Ϊ�����ռ�  
		Stack<TreeNode<Integer>>[] levels = new Stack[2];
		for (int i = 0; i < levels.length; i++) {
			levels[i] = new Stack();
		}
		levels[current].push(pTreeNode); 
		while(!levels[current].isEmpty() || !levels[next].isEmpty()){
			TreeNode<Integer> currNode = levels[current].pop();
			System.out.print(currNode.val + " ");
			if(next == 0) {
				//��������
				if(currNode.right != null) {
					levels[next].push(currNode.right);
				}
				if(currNode.left != null) {
					levels[next].push(currNode.left);
				}
			}else {
				//��������
				if(currNode.left != null) {
					levels[next].push(currNode.left);
				}
				if(currNode.right != null) {
					levels[next].push(currNode.right);
				}
			}
			if(levels[current].isEmpty()) {
				System.out.println();
				current = 1 -current;
				next = 1- next;
			}
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
			System.out.print(treeNode.val+" ");
			if(treeNode.left != null)
				childrens.add(treeNode.left);
			if(treeNode.right != null)
				childrens.add(treeNode.right);	
		}
		System.out.println();
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
		printTreeFromTopToBottom(root1);
		printFromTopToBottom(root1);
		System.out.println();
		printLnFromTopToBottom(root1);
	}
}

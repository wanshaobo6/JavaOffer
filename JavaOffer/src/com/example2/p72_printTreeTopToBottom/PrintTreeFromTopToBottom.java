package com.example2.p72_printTreeTopToBottom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 *  面试题32: 从上到下打印二叉树
 *  
 *  
 *  思路:  8             打印8下一个确定打印6和10  打印6以后确定打印的10 5 7  打印10确定打印的 5 7 9 11
 *  	6    10   
 *    5  7   9 11
 * @author 万少波
 *
 */
public class PrintTreeFromTopToBottom {
	
	/**  题目一:   不分行从上到下打印二叉树
	 *      举一反三:不管是广度优先遍历一幅有向图还是一棵树  都要用到队列 
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
			System.out.print(treeNode.val+" ");
			if(treeNode.left != null)
				queue.offer(treeNode.left);
			if(treeNode.right != null)
				queue.offer(treeNode.right);	
		}
	}
	
	/**
	 * 题目二: 分行从上到下打印二叉树
	 * 思路和上一题一样  当时还需要两个变量  一个表示当前节点还没打印的个数  一个是下一层节点的数量
	 * @param pTreeNode
	 */
	static void printLnFromTopToBottom(TreeNode<Integer> pTreeNode){
		if(pTreeNode == null)
			return ;
		Queue<TreeNode<Integer>> queue = new LinkedList();
		queue.offer(pTreeNode);
		int curLevel = 1; //当前节点还没打印的个数
		int nextLevel = 0;   //下一层节点的数量
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
	 * 题目三: 之字形打印二叉树
	 * 解析 :       1                | 1               |null
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
		//这样只是声明了地址但是没有为其分配空间  
		Stack<TreeNode<Integer>>[] levels = new Stack[2];
		for (int i = 0; i < levels.length; i++) {
			levels[i] = new Stack();
		}
		levels[current].push(pTreeNode); 
		while(!levels[current].isEmpty() || !levels[next].isEmpty()){
			TreeNode<Integer> currNode = levels[current].pop();
			System.out.print(currNode.val + " ");
			if(next == 0) {
				//从右往左
				if(currNode.right != null) {
					levels[next].push(currNode.right);
				}
				if(currNode.left != null) {
					levels[next].push(currNode.left);
				}
			}else {
				//从左往右
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

package com.example2.p82_FindPathInBinaryTree;

import java.util.Queue;


/**
 * 面试题34:二叉树中和为某一值得路径
 * 		题目:  给定一棵二叉树 和 一个整数，打印出二叉树中结点值的和为给定的整数的所有路径。
 * 			注意：路径是指：从二叉树的根结点开始的，往下一直到叶子结点过程中 所经过的结点
 * 			(包括根结点(起点)和叶子结点(终点))。
 * @author 万少波
 *
 */
public class FindPathInBinaryTree {
	static void findPath(TreeNode<Integer> pTreeNode , final int findNum){
	}
	static void findPath(TreeNode<Integer> pTreeNode , Queue<Integer> queue ,int sum , final int findNum){
		//保存记录
		queue.offer(pTreeNode.val);
		sum = sum+pTreeNode.val;
		if(pTreeNode.left != null){
			findPath(pTreeNode.left,queue , sum , findNum);
		}
		if(pTreeNode.right != null){
			findPath(pTreeNode.right,queue, sum , findNum);
		}
		//左右节点均为空
		if(pTreeNode.left == null && pTreeNode.right == null){
			if(sum == findNum){
				//打印队列
				for (int qint : queue) {
					
				}
				System.out.println();
			}
		}
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
}

package com.example2.p82_FindPathInBinaryTree;

import java.util.Queue;
import java.util.Stack;


/**
 * 面试题34:二叉树中和为某一值得路径
 * 		题目:  给定一棵二叉树 和 一个整数，打印出二叉树中结点值的和为给定的整数的所有路径。
 * 			注意：路径是指：从二叉树的根结点开始的，往下一直到叶子结点过程中 所经过的结点
 * 			(包括根结点(起点)和叶子结点(终点))。
 * 
 * 思路:   当用前序遍历的方式访问到某一节点时，我们把该结点添加到路径上，并累加该结点的值。如果
 * 		该结点为叶结点并且路径中结点值的和刚好为输入的整数，则当前的路径符合要求，我们把它打印出来。
 *      如果当前的结点不是叶结点，则继续访问它的子节点。当前结点访问结束后，递归函数将自动回到它的父节点
 *      。因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父节点时路径刚好是从
 *      根节点到父节点的路径。我们不难看出保存路径的数据结构实际上是一个栈，因此路径要与递归调用状态一致，
 *      而递归调用的本质上是一个压栈和出栈的过程。
 * @author 万少波
 *
 */
public class FindPathInBinaryTree {
	public static void main(String[] args) {
		TreeNode<Integer> pRoot = new TreeNode(10);
		TreeNode<Integer> treeNode1 = new TreeNode(5);
		TreeNode<Integer> treeNode2 = new TreeNode(12);
		TreeNode<Integer> treeNode3 = new TreeNode(4);
		TreeNode<Integer> treeNode4 = new TreeNode(7);
		pRoot.left = treeNode1;
		pRoot.right = treeNode2;
		pRoot.left.left = treeNode3;
		pRoot.left.right = treeNode4;
		findPath(pRoot, 10);
	}
	static void findPath(TreeNode<Integer> pTreeNode , final int findNum){
		if(pTreeNode == null){
			return ;
		}
		Stack<Integer> stack  = new Stack();
		findPath(pTreeNode , stack ,0 , findNum);
	}
	static void findPath(TreeNode<Integer> pTreeNode , Stack<Integer> stack ,int sum , final int findNum){
		//保存记录
		stack.push(pTreeNode.val);
		sum = sum+pTreeNode.val;
		if(pTreeNode.left != null){
			findPath(pTreeNode.left,stack , sum , findNum);
		}
		if(pTreeNode.right != null){
			findPath(pTreeNode.right,stack, sum , findNum);
		}
		//左右节点均为空
		if(pTreeNode.left == null && pTreeNode.right == null){
			if(sum == findNum){
				//打印堆栈
				Stack<Integer> tempStack = new Stack();
				//装入stack中数据装入tempStack
				while(!stack.isEmpty()){
					tempStack.push(stack.pop());
				}
				//打印stack中数据同时还原stack数据
				while(!tempStack.isEmpty()){
					System.out.print(tempStack.peek() + " ");
					stack.push(tempStack.pop());
				}
				System.out.println();
			}
		}
		stack.pop();
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

package com.example2.p82_FindPathInBinaryTree;

import java.util.Queue;
import java.util.Stack;


/**
 * ������34:�������к�Ϊĳһֵ��·��
 * 		��Ŀ:  ����һ�ö����� �� һ����������ӡ���������н��ֵ�ĺ�Ϊ����������������·����
 * 			ע�⣺·����ָ���Ӷ������ĸ���㿪ʼ�ģ�����һֱ��Ҷ�ӽ������� �������Ľ��
 * 			(���������(���)��Ҷ�ӽ��(�յ�))��
 * 
 * ˼·:   ����ǰ������ķ�ʽ���ʵ�ĳһ�ڵ�ʱ�����ǰѸý����ӵ�·���ϣ����ۼӸý���ֵ�����
 * 		�ý��ΪҶ��㲢��·���н��ֵ�ĺ͸պ�Ϊ�������������ǰ��·������Ҫ�����ǰ�����ӡ������
 *      �����ǰ�Ľ�㲻��Ҷ��㣬��������������ӽڵ㡣��ǰ�����ʽ����󣬵ݹ麯�����Զ��ص����ĸ��ڵ�
 *      ����������ں����˳�֮ǰҪ��·����ɾ����ǰ��㲢��ȥ��ǰ����ֵ����ȷ�����ظ��ڵ�ʱ·���պ��Ǵ�
 *      ���ڵ㵽���ڵ��·�������ǲ��ѿ�������·�������ݽṹʵ������һ��ջ�����·��Ҫ��ݹ����״̬һ�£�
 *      ���ݹ���õı�������һ��ѹջ�ͳ�ջ�Ĺ��̡�
 * @author ���ٲ�
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
		//�����¼
		stack.push(pTreeNode.val);
		sum = sum+pTreeNode.val;
		if(pTreeNode.left != null){
			findPath(pTreeNode.left,stack , sum , findNum);
		}
		if(pTreeNode.right != null){
			findPath(pTreeNode.right,stack, sum , findNum);
		}
		//���ҽڵ��Ϊ��
		if(pTreeNode.left == null && pTreeNode.right == null){
			if(sum == findNum){
				//��ӡ��ջ
				Stack<Integer> tempStack = new Stack();
				//װ��stack������װ��tempStack
				while(!stack.isEmpty()){
					tempStack.push(stack.pop());
				}
				//��ӡstack������ͬʱ��ԭstack����
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

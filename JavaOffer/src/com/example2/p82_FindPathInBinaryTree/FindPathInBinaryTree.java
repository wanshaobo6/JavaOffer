package com.example2.p82_FindPathInBinaryTree;

import java.util.Queue;


/**
 * ������34:�������к�Ϊĳһֵ��·��
 * 		��Ŀ:  ����һ�ö����� �� һ����������ӡ���������н��ֵ�ĺ�Ϊ����������������·����
 * 			ע�⣺·����ָ���Ӷ������ĸ���㿪ʼ�ģ�����һֱ��Ҷ�ӽ������� �������Ľ��
 * 			(���������(���)��Ҷ�ӽ��(�յ�))��
 * @author ���ٲ�
 *
 */
public class FindPathInBinaryTree {
	static void findPath(TreeNode<Integer> pTreeNode , final int findNum){
	}
	static void findPath(TreeNode<Integer> pTreeNode , Queue<Integer> queue ,int sum , final int findNum){
		//�����¼
		queue.offer(pTreeNode.val);
		sum = sum+pTreeNode.val;
		if(pTreeNode.left != null){
			findPath(pTreeNode.left,queue , sum , findNum);
		}
		if(pTreeNode.right != null){
			findPath(pTreeNode.right,queue, sum , findNum);
		}
		//���ҽڵ��Ϊ��
		if(pTreeNode.left == null && pTreeNode.right == null){
			if(sum == findNum){
				//��ӡ����
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

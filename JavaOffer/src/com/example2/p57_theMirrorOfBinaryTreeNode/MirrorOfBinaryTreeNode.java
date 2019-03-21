package com.example2.p57_theMirrorOfBinaryTreeNode;

/**
 * ������27: �������ľ���
 * 		���һ������ �� ����һ�ö����� �� �ú���������ľ���
 *    ˼·��������ö����� �������ҽڵ㼴��
 * 
 * @author ���ٲ�
 *
 */
public class MirrorOfBinaryTreeNode {
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
	
	static TreeNode getTheMirrorOfBinaryTreeNode(TreeNode<Integer> pRoot){
		if(pRoot == null)
			return null;
		//���������ӽڵ�
		TreeNode<Integer> tempNode = pRoot.left;
		pRoot.left = pRoot.right;
		pRoot.right = tempNode;
		getTheMirrorOfBinaryTreeNode(pRoot.left);
		getTheMirrorOfBinaryTreeNode(pRoot.right);
		return pRoot;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<Integer>(8);
		root1.left = new TreeNode<Integer>(8);
		root1.right = new TreeNode<Integer>(7);
		root1.left.left = new TreeNode<Integer>(9);
		root1.left.right = new TreeNode<Integer>(2);
		root1.left.right.left = new TreeNode<Integer>(4);
		root1.left.right.right = new TreeNode<Integer>(7);
		System.out.println();
		getTheMirrorOfBinaryTreeNode(root1);
		System.out.println();
	}

}

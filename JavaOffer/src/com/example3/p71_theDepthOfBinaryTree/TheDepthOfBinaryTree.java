package com.example3.p71_theDepthOfBinaryTree;

/**
 * ������55: �����������
 * 	��Ŀһ:����һ�ö������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ�һ�ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·����
 * 		�·���ĳ���Ϊ������ȡ�
 * @author ���ٲ�
 *
 */
public class TheDepthOfBinaryTree {
	public static void main(String[] args) {
		BinaryTreeNode pRoot = new BinaryTreeNode(1);
		BinaryTreeNode node1 = new BinaryTreeNode(2);
		BinaryTreeNode node2 = new BinaryTreeNode(3);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		pRoot.m_pLeft = node1;
		pRoot.m_pLeft.m_pLeft = node2;
		pRoot.m_pLeft.m_pLeft.m_pLeft = node3;
		System.out.println(treeDepth(pRoot));
	}
	
	/**
	 * ��ʽ1:���һ���ڵ�û��ֻ������������ô���Ϊ���������+1�����ֻ�������������Ϊ������+1
	 * 		����������������ڵ����Ϊ�������������ֵ+1
	 * @param pRoot
	 * @return
	 */
	public static int treeDepth(BinaryTreeNode pRoot){
		if(pRoot == null)
			return 0;
		int left = treeDepth(pRoot.m_pLeft);
		int right = treeDepth(pRoot.m_pRight);
		return left>right?left+1:right+1;
	}
	
	static class BinaryTreeNode{
		int m_nValue;
		BinaryTreeNode m_pLeft;
		BinaryTreeNode m_pRight;
		
		public BinaryTreeNode(int m_nValue) {
			this.m_nValue = m_nValue;
		}
		
	}
}

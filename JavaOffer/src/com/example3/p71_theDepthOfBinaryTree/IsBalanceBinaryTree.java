package com.example3.p71_theDepthOfBinaryTree;

import com.example3.p71_theDepthOfBinaryTree.TheDepthOfBinaryTree.BinaryTreeNode;

/**
 * ��Ŀ��:ƽ�������
 * 		����һ�ö������ĸ��ڵ㣬�жϸ����ǲ���ƽ��Ķ����������ĳ����������������������������������1����ô������һ��ƽ���������
 * @author ���ٲ�
 *
 */
public class IsBalanceBinaryTree {
	public static void main(String[] args) {
		BinaryTreeNode pRoot = new BinaryTreeNode(1);
		BinaryTreeNode node1 = new BinaryTreeNode(2);
		BinaryTreeNode node2 = new BinaryTreeNode(3);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		pRoot.m_pLeft = node1;
		pRoot.m_pRight = node2;
		pRoot.m_pRight.m_pLeft = node3;
		System.out.println(isBalanced1(pRoot));
		System.out.println(isBalanced2(pRoot));
	}
	
	/**
	 * ��ʽ1:��Ҫ�ظ������ڵ��εĽⷨ ʱ�临�Ӷȹ���,Ӱ�����ܲ��Ƽ�
	 * @param pRoot
	 * @return
	 */
	static boolean isBalanced1(BinaryTreeNode pRoot){
		//���㵱ǰ�ڵ�������ӽڵ����
		if(pRoot == null)
			return true;
		int leftDep = TheDepthOfBinaryTree.treeDepth(pRoot.m_pLeft);
		int rightDep = TheDepthOfBinaryTree.treeDepth(pRoot.m_pRight);
		int diff = leftDep - rightDep;
		if(diff<-1 || diff>1){
			return false;
		}
		//���㵱ǰ�ڵ������ӽڵ�������ӽڵ����
		return isBalanced1(pRoot.m_pLeft) && isBalanced1(pRoot.m_pRight);
	}
	
	//------------------------------------------------------------------------------
	/**
	 * ��ʽ2���������,ÿ���ڵ�ֻ����һ�� �� ��Ч�㷨
	 * 		��������ʱ���¼����ȣ��Ϳ���һ�߱���һ���ܰ���ÿ���ڵ��ǲ���ƽ���
	 */
	 static boolean isBalanced2(BinaryTreeNode pRoot){
		 IntegerPoint depth = new IntegerPoint();
		 return isBalancedCore(pRoot,depth);
	 }
	static boolean isBalancedCore(BinaryTreeNode pRoot,IntegerPoint depth){
		if(pRoot == null){
			depth.num = 0;
			return true;
		}
		IntegerPoint leftDep = new IntegerPoint();
		IntegerPoint rightDep = new IntegerPoint();
		if(isBalancedCore(pRoot.m_pLeft,leftDep) && isBalancedCore(pRoot.m_pRight,rightDep)){
			int diff = leftDep.num - rightDep.num;
			if(diff>=-1 && diff<=1){
				depth.num = leftDep.num > rightDep.num ? leftDep.num+1:rightDep.num+1;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ģ��c�е�intָ��
	 * @author hp
	 *
	 */
	static class IntegerPoint{
		int num ;

		public IntegerPoint(int num) {
			super();
			this.num = num;
		}

		public IntegerPoint() {
		}

		@Override
		public String toString() {
			return num+"";
		} 
		
	}
}

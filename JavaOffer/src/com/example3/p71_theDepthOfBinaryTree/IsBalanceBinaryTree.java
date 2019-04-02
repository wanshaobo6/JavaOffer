package com.example3.p71_theDepthOfBinaryTree;

import com.example3.p71_theDepthOfBinaryTree.TheDepthOfBinaryTree.BinaryTreeNode;

/**
 * 题目二:平衡二叉树
 * 		输入一棵二叉树的根节点，判断该树是不是平衡的二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @author 万少波
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
	 * 方式1:需要重复遍历节点多次的解法 时间复杂度过高,影响性能不推荐
	 * @param pRoot
	 * @return
	 */
	static boolean isBalanced1(BinaryTreeNode pRoot){
		//计算当前节点的左右子节点深度
		if(pRoot == null)
			return true;
		int leftDep = TheDepthOfBinaryTree.treeDepth(pRoot.m_pLeft);
		int rightDep = TheDepthOfBinaryTree.treeDepth(pRoot.m_pRight);
		int diff = leftDep - rightDep;
		if(diff<-1 || diff>1){
			return false;
		}
		//计算当前节点左右子节点的左右子节点深度
		return isBalanced1(pRoot.m_pLeft) && isBalanced1(pRoot.m_pRight);
	}
	
	//------------------------------------------------------------------------------
	/**
	 * 方式2：后序遍历,每个节点只遍历一次 ， 高效算法
	 * 		遍历树的时候记录其深度，就可以一边遍历一边跑按断每个节点是不是平衡的
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
	 * 模拟c中的int指针
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

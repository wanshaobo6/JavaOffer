package com.example.p65_GetNextInInorder;

import com.example.p63_constructBinaryTree.ConstructBinaryTree;

/**
 * 问题:给顶定一棵二叉树和其中一个结点，如何找出中序遍历序列的下一个结点? 树中的结点除了有两个
 *      分别指向左右结点的指针，还有一个指向父节点的指针
 * 将问题分成若干种情况1.若一个结点有右子树下一个结点就是他的右子树中的最左子节点
 * 					  2.一个结点没有右子树 2.1: 如果结点是他父节点的左子节点 下一个结点就是父节点
 * 										  2.2: 结点是他父节点的右子结点 找到该结点的祖先节点并且该祖先结点为其父节点的子结点
 *												该祖先结点的父节点为下一个结点
 * @author 万少波
 *   
 */
public class GetNextInInorder {
	public static void main(String[] args) {
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		GetNextInInorder getNextInInorder = new GetNextInInorder();
		BinaryTreeNode node = getNextInInorder.construct(preorder,inorder);
		BinaryTreeNode node1 = getNextInInorder.getNext(node.m_pLeft.m_pLeft);
		BinaryTreeNode node2 = getNextInInorder.getNext(node1);
		BinaryTreeNode node3 = getNextInInorder.getNext(node2);
		BinaryTreeNode node4 = getNextInInorder.getNext(node3);
		BinaryTreeNode node5= getNextInInorder.getNext(node4);
		BinaryTreeNode node6 = getNextInInorder.getNext(node5);
		System.out.println(node1.getM_nValue());
		System.out.println(node2.getM_nValue());
		System.out.println(node3.getM_nValue());
		System.out.println(node4.getM_nValue());
		System.out.println(node5.getM_nValue());
		System.out.println(node6.getM_nValue());
	}
	public BinaryTreeNode getNext(BinaryTreeNode node){
		//参数条件判断
		if(node == null){
			return null;
		}
		BinaryTreeNode nextNode = null;
		//右结点不为空情况
		BinaryTreeNode rightNode = node.m_pRight;
		if(rightNode != null){
			nextNode = rightNode;
			while(nextNode.m_pLeft != null){
				nextNode = nextNode.m_pLeft;
			}
		}else if(node.m_parent != null ){
			//右结点不存在情况下
			 //该节点是父节点的右边子结点 该节点是父节点的左边子结点 通用
			BinaryTreeNode pCurrent = node;
			BinaryTreeNode parentNode = node.m_parent;
			while(parentNode.m_parent!=null && parentNode.m_pRight == pCurrent ){
				pCurrent = parentNode;
				parentNode = parentNode.m_parent;
			}
			nextNode = parentNode;
			
		}
		return nextNode;
	}
	
	
	//=======================P_63例子改编  构建树中的结点除了有两个分别指向左右结点的指针，还有一个指向父节点的指针==============================
	BinaryTreeNode construct(int[] preorder , int[] inorder){
		//对参数进行正确性校验
		if(preorder == null || inorder == null || preorder.length != inorder.length){
			return null;
		}
		return constructCoreWithParentPoint(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1);
	}
	
	private BinaryTreeNode constructCoreWithParentPoint(int[] preorder, int preorderS, int preorderE, int[] inorder, int inorderS, int inorderE) {
		// TODO Auto-generated method stub
		int rootValue = preorder[preorderS];
		BinaryTreeNode root = new BinaryTreeNode(rootValue);
		root.m_pLeft = root.m_pRight = null;
		//如果是叶子结点
		if(preorderS == preorderE){
			if(inorderS == inorderE && preorder[preorderS] == inorder[inorderS]){
				return root;
			}else{
				throw new RuntimeException("输入有误");
			}
		}
		//非叶子结点
		 //找出跟结点在前驱遍历数组中的序号
		int rootInInOrder ;
		for (rootInInOrder = inorderS ; rootInInOrder <=inorderE 
			&& inorder[rootInInOrder] != rootValue; rootInInOrder++) {}
		if(rootInInOrder == inorderE && inorder[rootInInOrder] != rootValue){
			throw new RuntimeException("输入有误");
		}
		if(rootInInOrder-inorderS > 0){
			root.m_pLeft = constructCoreWithParentPoint(preorder , preorderS+1 , preorderS+rootInInOrder-inorderS,inorder , inorderS , rootInInOrder-1);
			root.m_pLeft.m_parent = root;
		}
		if(inorderE-rootInInOrder>0){
			root.m_pRight = constructCoreWithParentPoint(preorder , preorderS+rootInInOrder-inorderS+1 , preorderE,inorder , rootInInOrder+1 , inorderE);
			root.m_pRight.m_parent = root;
		}
		return root;
	}
}
class BinaryTreeNode{
	private int m_nValue;
	
	BinaryTreeNode m_parent;
	BinaryTreeNode m_pLeft;
	BinaryTreeNode m_pRight;
	
	
	public BinaryTreeNode(int m_nValue) {
		super();
		this.m_nValue = m_nValue;
	}
	
	public int getM_nValue() {
		return m_nValue;
	}
	public void setM_nValue(int m_nValue) {
		this.m_nValue = m_nValue;
	}
	
}

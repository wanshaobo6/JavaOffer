package com.example.p65_GetNextInInorder;

import com.example.p63_constructBinaryTree.ConstructBinaryTree;

/**
 * ����:������һ�ö�����������һ����㣬����ҳ�����������е���һ�����? ���еĽ�����������
 *      �ֱ�ָ�����ҽ���ָ�룬����һ��ָ�򸸽ڵ��ָ��
 * ������ֳ����������1.��һ���������������һ�������������������е������ӽڵ�
 * 					  2.һ�����û�������� 2.1: �������������ڵ�����ӽڵ� ��һ�������Ǹ��ڵ�
 * 										  2.2: ����������ڵ�����ӽ�� �ҵ��ý������Ƚڵ㲢�Ҹ����Ƚ��Ϊ�丸�ڵ���ӽ��
 *												�����Ƚ��ĸ��ڵ�Ϊ��һ�����
 * @author ���ٲ�
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
		//���������ж�
		if(node == null){
			return null;
		}
		BinaryTreeNode nextNode = null;
		//�ҽ�㲻Ϊ�����
		BinaryTreeNode rightNode = node.m_pRight;
		if(rightNode != null){
			nextNode = rightNode;
			while(nextNode.m_pLeft != null){
				nextNode = nextNode.m_pLeft;
			}
		}else if(node.m_parent != null ){
			//�ҽ�㲻���������
			 //�ýڵ��Ǹ��ڵ���ұ��ӽ�� �ýڵ��Ǹ��ڵ������ӽ�� ͨ��
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
	
	
	//=======================P_63���Ӹı�  �������еĽ������������ֱ�ָ�����ҽ���ָ�룬����һ��ָ�򸸽ڵ��ָ��==============================
	BinaryTreeNode construct(int[] preorder , int[] inorder){
		//�Բ���������ȷ��У��
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
		//�����Ҷ�ӽ��
		if(preorderS == preorderE){
			if(inorderS == inorderE && preorder[preorderS] == inorder[inorderS]){
				return root;
			}else{
				throw new RuntimeException("��������");
			}
		}
		//��Ҷ�ӽ��
		 //�ҳ��������ǰ�����������е����
		int rootInInOrder ;
		for (rootInInOrder = inorderS ; rootInInOrder <=inorderE 
			&& inorder[rootInInOrder] != rootValue; rootInInOrder++) {}
		if(rootInInOrder == inorderE && inorder[rootInInOrder] != rootValue){
			throw new RuntimeException("��������");
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

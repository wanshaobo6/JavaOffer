package com.example.p63_constructBinaryTree;

/**
 * �ؽ���������ĳ�����������ǰ���������������Ľ�������ؽ��ö�����(�����ǫ���������������������ظ�������)
 * @author ���ٲ�
 *
 */
public class ConstructBinaryTree {

	BinaryTreeNode construct(int[] preorder , int[] inorder){
		//�Բ���������ȷ��У��
		if(preorder == null || inorder == null || preorder.length != inorder.length){
			return null;
		}
		return constructCore(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1);
	}
	
	private BinaryTreeNode constructCore(int[] preorder, int preorderS, int preorderE, int[] inorder, int inorderS, int inorderE) {
		// TODO Auto-generated method stub
		int rootValue = preorder[preorderS];
		BinaryTreeNode root = new BinaryTreeNode(rootValue);
		root.m_pLeft = root.m_pRight = null;
		//�����Ҷ�ӽ��
		if(preorderS == preorderE){
			if(inorderS == inorderE && preorder[preorderS] == inorder[inorderS]){
				return root;
			}else{
				throw new RuntimeException("��������1");
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
			root.m_pLeft = constructCore(preorder , preorderS+1 , preorderS+rootInInOrder-inorderS,inorder , inorderS , rootInInOrder-1);
		}
		if(inorderE-rootInInOrder>0){
			root.m_pRight = constructCore(preorder , preorderS+rootInInOrder-inorderS+1 , preorderE,inorder , rootInInOrder+1 , inorderE);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
		BinaryTreeNode node = constructBinaryTree.construct(preorder,inorder);
		System.out.println(node);
	}
	 
}


package com.example.p63_constructBinaryTree;

/**
 * 重建二叉树：某输入二叉树的前序遍历和中序遍历的结果，请重建该二叉树(输入的谦虚遍历和中序遍历都不含重复的数字)
 * @author 万少波
 *
 */
public class ConstructBinaryTree {

	BinaryTreeNode construct(int[] preorder , int[] inorder){
		//对参数进行正确性校验
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
		//如果是叶子结点
		if(preorderS == preorderE){
			if(inorderS == inorderE && preorder[preorderS] == inorder[inorderS]){
				return root;
			}else{
				throw new RuntimeException("输入有误1");
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


package com.example2.p79_BinarySearchTree;


/**
 * 面试题33: 二叉搜索树的后序遍历序列
 *    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *    举例：序列{5,7,6,9,11,10,8}是二叉搜索树的后序遍历结果。
 * @author 万少波
 *
 */
public class BinarySearchTreeVerifySeqOfBST {
	static boolean verifyTreeSequenceOfBST(int[] treeSeq){
		if(treeSeq == null || treeSeq.length == 0)
			return false;
		return verifyTreeSequenceOfBST(treeSeq ,0,treeSeq.length-1);
	}
	static boolean verifyTreeSequenceOfBST(int[] treeSeq , int start , int end){
		int pRoot = treeSeq[end];
		int i ;
		//找出第一个右子树下标
		for( i = start; i< end ;i++){
			if(treeSeq[i] > pRoot)
				break;
		}
		//若后面节点存在小于根节点则表明不是搜索树
		for( int j = i; j < end ; j++){
			if(treeSeq[j] < pRoot)
				return false;
		}
		//递归判断子树是不是搜索树
		boolean left = true;
		if(i-start > 1)
			left = verifyTreeSequenceOfBST(treeSeq , start , i-1);
		boolean right = true;
		if(end-1-i > 1)
			right = verifyTreeSequenceOfBST(treeSeq , i , end-1);
		return left&&right;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,7,6,9,11,10,8};
		int[] errNums = {7,4,6,5};
		int[] num2 ={1,2,3,4,5};
		System.out.println(verifyTreeSequenceOfBST(nums));
		System.out.println(verifyTreeSequenceOfBST(errNums));
		System.out.println(verifyTreeSequenceOfBST(num2));
	}
}

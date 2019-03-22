package com.example2.p79_BinarySearchTree;


/**
 * ������33: �����������ĺ����������
 *    ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 *
 *    ����������{5,7,6,9,11,10,8}�Ƕ����������ĺ�����������
 * @author ���ٲ�
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
		//�ҳ���һ���������±�
		for( i = start; i< end ;i++){
			if(treeSeq[i] > pRoot)
				break;
		}
		//������ڵ����С�ڸ��ڵ����������������
		for( int j = i; j < end ; j++){
			if(treeSeq[j] < pRoot)
				return false;
		}
		//�ݹ��ж������ǲ���������
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

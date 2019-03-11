package com.example.twoDimensionalArray;

/**
 *  ��һ����ά�����У�ÿһ�а��մ����ҵ�����˳�����У�ÿһ�а��մ��ϵ��µ�����˳�����У�����һ����ά������������ж��������Ƿ��и�����
 *  
 * @author ���ٲ�
 *
 */
public class findInTwoDimensionalArray {
	
	public static void main(String[] args) {
		int[][] array =
		{
				{1, 2,  8,  9, 10},
				{2, 4,  9, 12, 16},
				{4, 7, 10, 13, 17},
				{6, 8, 11, 15, 18}
		};
		System.out.println(findDuplication(array, 15));
		System.out.println(findDuplication(array, 5));
	}
	
	public static boolean findDuplication(int[][] matrix , int num){
		boolean found = false;
		//�ж������Ƿ�Ϊ��
		if(matrix == null ){
			return found;
		}
		//��ȡ��ά���������  ��ά���鱾����һά���飬����=������.length,����=������[0].length
		int rows = matrix.length;
		int columns = matrix[0].length;
		//�жϲ�������ȷ��
		if(rows>0 && columns>0){
			int row = 0;
			int column = columns-1;
			while(row<rows && column>=0){
				if(matrix[row][column] == num){
					found = true;
					break;
				}else if(matrix[row][column] > num){
					column -- ;
				}else{
					row ++ ;
				}
			}
		}
		return found;
	}

}

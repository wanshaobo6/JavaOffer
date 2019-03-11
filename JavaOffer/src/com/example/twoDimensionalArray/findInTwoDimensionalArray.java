package com.example.twoDimensionalArray;

/**
 *  在一个二维数组中，每一行按照从左到右递增的顺序排列，每一列按照从上到下递增的顺序排列，输入一个二维数组和整数，判断数组中是否含有该整数
 *  
 * @author 万少波
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
		//判断数组是否为空
		if(matrix == null ){
			return found;
		}
		//获取二维数组的行列  二维数组本质是一维数组，行数=数组名.length,列数=数组名[0].length
		int rows = matrix.length;
		int columns = matrix[0].length;
		//判断参数的正确性
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

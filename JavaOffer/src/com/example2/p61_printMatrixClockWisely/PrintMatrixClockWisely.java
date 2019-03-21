package com.example2.p61_printMatrixClockWisely;

/**
 * 面试题29： 顺时针打印矩阵
 * 		题目:输入一个矩阵，按照从里到外以顺时针的顺序一次打印出每一个数字
 * @author 万少波
 * 
 */
public class PrintMatrixClockWisely {
	public static void main(String[] args) {
		int[][] matrix={ {1,2,3,4}
						,{5,6,7,8}
						,{7,10,11,12}
						,{13,14,15,16},
						{17,18,19,20}};
		doPrintMatrixClockWisely(matrix);
	}
	
	static void doPrintMatrixClockWisely(int[][] matrix){
		if(matrix == null){
			return ;
		}
		int sRow = 0;
		int eRow = matrix.length-1;
		int sCol = 0;
		int eCol = matrix[0].length-1;
		int time = 0;
		//书中跳出条件  colums>startxX*2  rows>startY*2   startX和startY为当前坐标
		while(eRow-sRow-2*time>0 && eCol-sCol-2*time>0){
			printCircle(matrix,sRow+time,eRow -time , sCol+time ,eCol-time);
			time ++;
		}
	}
	
	static void printCircle(int[][] matrix,int sRow , int eRow , int sCol , int eCol){
		boolean flag = true;
		if(sRow == eRow && sCol == eCol){
			System.out.print(matrix[sRow][sCol]+" ");
			return ;
		}
		if(sRow == eRow)
		{
			eCol ++ ;
			flag = false;
		}
		if(sCol == eCol)
		{
			eRow ++ ;
			flag = false;
		}
		//上
		for(int i =sCol ; i<eCol ; i++)
			System.out.print(matrix[sRow][i]+" ");
		//右
		for(int j = sRow; j<eRow ; j++){
			System.out.print(matrix[j][eCol]+" ");
		}
		if(flag){
			//下
			for(int k = eCol; k>sCol ; k--){
				System.out.print(matrix[eRow][k]+" ");
			}
			//左
			for(int l = eRow; l>sRow ; l--){
				System.out.print(matrix[l][sCol]+" ");
			}
		}
	}
}

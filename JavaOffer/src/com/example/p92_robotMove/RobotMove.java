package com.example.p92_robotMove;

import com.example.p89_StringPathInMatrix.StringPathInMatrix;

/**
* 题目：机器人的运动范围
* 地上有一个m行n列的方格，一个机器人从坐标(0,0)的各自开始移动，它每次可以向上下左右移动一格，但不能进入横纵坐标数位之和大于k的格子。
* 例如，当k等于18时，机器人能进入(35,37)，因为3+5+3+7=18；但却不能进入(35,38)，因为3+5+3+8=19>18。
* 请问该机器人能够到达多少个格子。
* <p>
* 思路：
* 每前进一步后，可选移动项为上下左右四个；
* 为了判断某一个格子是否可以进入从而进行计数，不仅需要考虑边界值，计算各位数字之和，更要判断该格子是否已经被访问过。
* 所以需要一个布尔矩阵，用来记录各格子是否已被访问。
* 
* 
*/
public class RobotMove {
	public static void main(String[] args) {
		System.out.println(movingCount(0, 3, 4));
		System.out.println(movingCount(1, 3, 4));
		System.out.println(movingCount(9, 2, 20));
	}
	
	public static int movingCount(int threshold , int rows , int cols){
		if(threshold < 0 || rows <= 0 || cols <= 0)
			return 0;
		boolean[][] visitedFlag = new boolean[rows][cols];
		int count =  movingCountCore(threshold,rows,cols,0,0,visitedFlag);
		StringPathInMatrix.showBooleanMatrix(visitedFlag);
		return count;
	}

	private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visitedFlag) {
		// TODO Auto-generated method stub
		int count = 0;
		if(check(threshold,rows,cols,row,col,visitedFlag)){
			visitedFlag[row][col] = true;
			return count = 1 + movingCountCore(threshold,rows,cols,row+1,col,visitedFlag)+movingCountCore(threshold,rows,cols,row-1,col,visitedFlag)
						+movingCountCore(threshold,rows,cols,row,col+1,visitedFlag)+movingCountCore(threshold,rows,cols,row,col-1,visitedFlag);
		}
		return count;
	}
	
	
	private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visitedFlag) {
		// TODO Auto-generated method stub
		if(row >=0 && col >= 0 && row < rows && col < cols && !visitedFlag[row][col] && getDigSum(row)+getDigSum(col) <= threshold){
			return true;
		}
		return false;
	}
	
	private static int getDigSum(int num) {
		// TODO Auto-generated method stub
		int sum = 0;
		while(num > 0){
			sum += num%10;
			num = num / 10 ;
		}
		return sum;
	}
}

package com.example3.p33_theMaxValueOfGift;

/**
 *  面试题47:礼物的最大价值
 *  	题目:在一个m * n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。从左上角开始拿礼物，每次向右或向下移动一格，
 *  			直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * 		1    10   3    8
 * 		12   2    9    6
 * 		5    7    4    11
 * 		3    7    16   5
 * 		
 *	
 * 		礼物的最大价值为1+12+5+7+7+16+5=53。
 *  
 * @author 万少波
 *	
 */
public class TheMaxValueOfGift {
	public static void main(String[] args) {
		int[][] allGifts = {{1,10,3,8},
							{12,2,9,6},
							{5,7,4,11},
							{3,7,16,5}};
		System.out.println(getTheMaxValueOfGift(allGifts));
	}
	
	/**
	 *  解法: 列出递推方程式
	 *  				max{ (f(i,j-1)+p(i,j)) , (f(i-1,j)+p(i,j))}    i>0且j>(0)
	 *  	f(i,j) = 	f(i,j-1)+p(i,j)                         i = 0
	 *  				f(i-1,j)+p(i,j)                         j=0
	 *  				allGift[0][0]                           i=j=0       
	 * @param allGifts
	 * @return
	 */
	static int getTheMaxValueOfGift(int[][] allGifts){
		if(allGifts == null || allGifts.length == 0 || allGifts[0].length == 0)
			return 0;
		int rows = allGifts.length;
		int cols = allGifts[0].length;
		int[][] maxValue = new int[rows][cols];  
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int left = 0;
				int top = 0;
				if(row > 0)
					left = maxValue[row-1][col];
				
				if(col > 0)
					top = maxValue[row][col-1];
				
				maxValue[row][col] = getMax(left,top)+allGifts[row][col];
			}
		}
		return maxValue[rows-1][cols-1];
	}

	private static int getMax(int i, int j) {
		// TODO Auto-generated method stub
		return i>j?i:j;
	}
}

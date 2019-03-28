package com.example3.p33_theMaxValueOfGift;

/**
 *  ������47:���������ֵ
 *  	��Ŀ:��һ��m * n�����̵�ÿһ���񶼷���һ�����ÿ�����ﶼ��һ����ֵ������0���������Ͻǿ�ʼ�����ÿ�����һ������ƶ�һ��
 *  			ֱ�����½ǽ���������һ�����̣����õ����������ֵ�����磬������������
 * 		1    10   3    8
 * 		12   2    9    6
 * 		5    7    4    11
 * 		3    7    16   5
 * 		
 *	
 * 		���������ֵΪ1+12+5+7+7+16+5=53��
 *  
 * @author ���ٲ�
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
	 *  �ⷨ: �г����Ʒ���ʽ
	 *  				max{ (f(i,j-1)+p(i,j)) , (f(i-1,j)+p(i,j))}    i>0��j>(0)
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

package com.example3.p00_example1;

/**
 * 题目:输入一个含有8个数字的数组,判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和相等。
 * @author 万少波
 *
 */
public class example_cube {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		int[] result = check(nums, 0);
		System.out.println();
	}
	
	//查看是否符合条件
	static int[] checkPossible(int[] sideLen){
		if(sideLen.length != 8)
			return null;
		if((sideLen[0]+sideLen[1]+sideLen[2]+sideLen[3]) == (sideLen[4]+sideLen[5]+sideLen[6]+sideLen[7]) &&
			(sideLen[0]+sideLen[2]+sideLen[4]+sideLen[6]) == (sideLen[1]+sideLen[3]+sideLen[5]+sideLen[7]) && 
			(sideLen[0]+sideLen[1]+sideLen[4]+sideLen[5]) == (sideLen[2]+sideLen[3]+sideLen[6]+sideLen[7])  
			)
			return sideLen;
		return null;
	}

	//求出数组的全排列  并判断是否符合条件
	static int[] check(int[] sides , int start){
		if(start >= sides.length){
			return checkPossible(sides);
		}
		for (int i = start; i < sides.length; i++) {
			swap(start,i,sides);
			int[] returnSides = check(sides,start+1);
			if(returnSides != null){
				return returnSides;
			}
			swap(start,i,sides);
		}
		return null;
	}
	//交换数据
	private static void swap(int start, int i, int[] sides) {
		// TODO Auto-generated method stub
		int swap = sides[start];
		sides[start] = sides[i];
		sides[i] = swap;
	}
}

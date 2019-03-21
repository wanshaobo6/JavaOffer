package com.example2.p29_reOrderArray;

/**
 * 
 * @author hp
 *
 */
public class ReOrderArray {
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,7,9};
		reOrderOddEvent(nums);
		for (int i : nums) {
			System.out.print(i+" ");
		}
	}
	
	//快速排序思想
	static void reOrderOddEvent(int[] pData){
		if(pData == null || pData.length == 0)
			return ;
		int sIndex = 0;
		int eIndex = pData.length-1;
		while(sIndex < eIndex){
			//向后移动直到指向偶数
			while(sIndex < eIndex && (pData[sIndex] & 0x1) != 0){
				sIndex++;
			}
			//向前移动直到指向奇数
			while(sIndex < eIndex && (pData[eIndex] & 0x1) == 0){
				eIndex--;
			}
			if(sIndex < eIndex){
				//交换数值
				int swap = pData[sIndex];
				pData[sIndex] = pData[eIndex];
				pData[eIndex] = swap;
			}
		}
	}
}

package com.example.p81_agesort;

import java.util.Arrays;

/**
 * 对公司所有员工的年龄进行排序，公司总共有几万名员工，要求时间复杂度为O（n）,可使用的空间复杂度为常量大小，不得超过O(n)
 *	 
 * @author 万少波
 *
 */
public class AgeSort {
	
	public static void main(String[] args) {
		int[] a = {51, 1, 6, 8, 9, 5, 7, 8, 9, 4, 5, 6, 1, 4, 7, 51, 48, 47, 46, 99};
		try {
			System.out.println("ageSort(a) = " + Arrays.toString(ageSort(a)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int[] ageSort(int[] array) throws Exception{
		if(array == null || array.length <= 0){
			return null;
		}
		int maxAge = 99;
		int[] ageCountArray = new int[maxAge+1];
		//计算出各个年龄的数量
		for (int i : array) {
			if(i<1 || i>maxAge){
				throw new Exception("年龄越界");
			}
			ageCountArray[i-1]++;
		}
		
		int arrLen = array.length;
		int[] newArray = new int[arrLen];
		int curIndex = 0;
		
		for(int i=0 ; i<ageCountArray.length; i++){
			for(int j=0; j< ageCountArray[i] ; j++){
				newArray[curIndex++] = i+1;
			}
		}
		return newArray;
	}
}

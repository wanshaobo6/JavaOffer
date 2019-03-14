package com.example.p81_agesort;

import java.util.Arrays;

/**
 * �Թ�˾����Ա��������������򣬹�˾�ܹ��м�����Ա����Ҫ��ʱ�临�Ӷ�ΪO��n��,��ʹ�õĿռ临�Ӷ�Ϊ������С�����ó���O(n)
 *	 
 * @author ���ٲ�
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
		//������������������
		for (int i : array) {
			if(i<1 || i>maxAge){
				throw new Exception("����Խ��");
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

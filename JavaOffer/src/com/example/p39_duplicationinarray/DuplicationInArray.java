package com.example.p39_duplicationinarray;

import com.example.utils.SortUtils;

/**
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字的重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如输入长度为七的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出重复数字为数字2或数字3
 *
**/
public class DuplicationInArray { 
	public static void main(String[] args) {
		int[] array = {6,8,3,4,5,4,2,1,5,4,7,4};
		int duplication1 = getDuplication1(array);
		System.out.println("duplication1:"+duplication1);
		int duplication2 = getDuplication2(array);
		System.out.println("duplication2:"+duplication2);
		int duplication3 = getDuplication3(array);
		System.out.println("duplication3:"+duplication3);
		int duplication4 = getDuplication4(array);
		System.out.println("duplication4:"+duplication4);
	}
	


	/**
	 * 方法1：暴力破解
	 * 时间复杂度O(n2) 空间复杂度O(1)
	 * @param array
	 * @return
	 */
	static int getDuplication1(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i] == array[j]){
					return array[i];
				}
			} 
		}
		return -1;
	}
	
	/**
	 * 方法2: 将数组排序后遍历
	 * 时间复杂度为排序的时间复杂度O(nlogn) 空间复杂度O(1)
	 */
	static int getDuplication2(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		//冒泡排序 时间复杂度O(n2) 不推荐
		/*	for(int i =0;i<array.length-1;i++){
				for(int j=i+1 ; j<array.length;j++){
					if(array[j-1]>array[j]){
						int swap = array[j-1];
						array[j-1] = array[j];
						array[j] = swap;
					}
				}
			}*/
		//快速排序 时间复杂度O(nlogn) 推荐
		SortUtils.QuickSort(array ,0 ,array.length-1);
		//遍历数组时间复杂度O(n)
		for(int i=0;i<array.length-1;i++){
			if(array[i]==array[i+1]){
				return array[i];
			}
		}
		return -1;
	}
	
	/**
	 * 利用hash表 从头到尾扫描这个数字 每扫描到一个时候就用O(1)的时间复杂度判断Hash表中是否已经包含了这个元素
	 * 时间复杂度O(n) 空间复杂度O(n) 
	 * @param array
	 * @return
	 */
	static int getDuplication3(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		int[] hashTable = new int[array.length];
		for(int num : array){
			if(hashTable[num] == 1){
				return num;
			}
			hashTable[num] = 1;
		}
		return -1;
	}
	
/**
 * 对号入座
 * 从头到尾扫描这个数组的每一个数字，扫描到数组为i的值时，首先比较这个数字是不是等于i。
 * 如果是，继续扫描
 * 如果不是，则再拿它和地m个数字比较，如果值一样，则找到重复数字，如果值不相等，就交换数组地i个和地m个数字，
 * 继续重复这个比较
 * 时间复杂度： O(n) 空间复杂度 O(1)
 */
	static int getDuplication4(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		for(int i = 0;i<array.length;i++){
			//如果其中一个数字不在0~n-1 退出
			if(array[i]<0 || array[i]>array.length-1)
				return -1;
		}
		for(int i = 0;i<array.length;i++){
			//当前遍历的数字等于下标继续遍历下一个
			while(array[i] != i){
				//对号入座 值i 对应 array[i]位置
				if(array[i] == array[array[i]]){
					return array[i];
				}else{
					int temp = array[array[i]];
					array[array[i]] = array[i];
					array[i] =temp;
				}
			}
		}

		return -1;
	}
	
}

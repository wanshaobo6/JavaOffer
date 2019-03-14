package com.example.p83_minNumberInRotatedArray;

import javax.sound.midi.Soundbank;

/**
* 旋转数组的最小数字
* <p>
* 题目要求：
* 把一个数组最开始的若干个元素搬到末尾成为数组的旋转，如1,2,3,4,5=>3,4,5,1,2；0,1,1,1,1=>1,1,1,0,1；0,1,1,1,1=>1,0,1,1,1。
* 求一个原本递增的数组旋转后的最小数字。
*/
public class MinNumberInRotatedArray {
	public static void main(String[] args) {
		MinNumberInRotatedArray array = new MinNumberInRotatedArray();
		int[] data1 = {3, 4, 1, 1, 2};
		int[] data2 = {1, 0, 1, 1, 1};
		int[] data3 = {1, 1, 1, 0, 1};
		int[] data4 = {0, 1, 1, 1, 1};
		int[] data5 = {6, 2, 3, 4, 5};
		System.out.println(array.min(data1));
		System.out.println(array.min(data2));
		System.out.println(array.min(data3));
		System.out.println(array.min(data4));
		System.out.println(array.min(data5));
		System.out.println("---------------------------");
	}
	
	/**
	 * 解法一：旋转数组中包含两个递增排序的子数组，把begin指向数组第一个数字，eng指向数组最后一个数字
	 * 如果minIndex比begin大，所以最小数一定在midIndex后面，反之，最小数可能就是midIndex或在midIndex前面
	 * 就这样一直循环，直到两个指针距离为一，表示第一个指针已经指向了第一个递增子数列的末尾，第二个子数组的第一个数字就是最小数字
	 * 此时，第二个指针指向的就是这个数字即结果
	 * 还有一些特殊情况，比如把排序数组的前0个元素搬到最后面，及排序数组本身，所以我们把midIndex初始值设置为begin
	 * 还有的特殊情况就是0,1,1,1,1=>1,1,1,0,1;0,1,1,1,1=>1,0,1,1,1这样的，遇到这样的情况就要进行顺序遍历
	 */
	private int min(int[] array) {
		if(array == null || array.length <=0){
			return -1;
		}
		int leftPoint = 0;
		int rightPoint = array.length-1;
		int midPoint = leftPoint;
		while( rightPoint - leftPoint  != 1 ){
			if(array[leftPoint]<array[rightPoint]){
				return array[leftPoint];
			}
			midPoint = (leftPoint+rightPoint)/2;
			int midValue = array[midPoint];
			
			// 如果下标为begin，end，minIndex的值不一样，则只能顺序遍历查找
			if (array[leftPoint] == array[rightPoint] && array[leftPoint] == array[midPoint]) {
				return minInOrder(array, leftPoint, rightPoint);
			}
			if(midValue >= array[leftPoint]){
				leftPoint = midPoint;
			}else if(midValue <= array[rightPoint]){
				rightPoint = midPoint;
			}
		}
		return array[rightPoint];
	}
	
	private int minInOrder(int[] array, int begin, int end) {
		int min = array[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}
}

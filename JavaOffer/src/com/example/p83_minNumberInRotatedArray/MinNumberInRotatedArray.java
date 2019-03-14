package com.example.p83_minNumberInRotatedArray;

import javax.sound.midi.Soundbank;

/**
* ��ת�������С����
* <p>
* ��ĿҪ��
* ��һ�������ʼ�����ɸ�Ԫ�ذᵽĩβ��Ϊ�������ת����1,2,3,4,5=>3,4,5,1,2��0,1,1,1,1=>1,1,1,0,1��0,1,1,1,1=>1,0,1,1,1��
* ��һ��ԭ��������������ת�����С���֡�
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
	 * �ⷨһ����ת�����а���������������������飬��beginָ�������һ�����֣�engָ���������һ������
	 * ���minIndex��begin��������С��һ����midIndex���棬��֮����С�����ܾ���midIndex����midIndexǰ��
	 * ������һֱѭ����ֱ������ָ�����Ϊһ����ʾ��һ��ָ���Ѿ�ָ���˵�һ�����������е�ĩβ���ڶ���������ĵ�һ�����־�����С����
	 * ��ʱ���ڶ���ָ��ָ��ľ���������ּ����
	 * ����һЩ�����������������������ǰ0��Ԫ�ذᵽ����棬���������鱾���������ǰ�midIndex��ʼֵ����Ϊbegin
	 * ���е������������0,1,1,1,1=>1,1,1,0,1;0,1,1,1,1=>1,0,1,1,1�����ģ����������������Ҫ����˳�����
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
			
			// ����±�Ϊbegin��end��minIndex��ֵ��һ������ֻ��˳���������
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

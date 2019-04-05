package com.example4.p04_maxDiff;

/**
 * ������63:��Ʊ���������
 * 	��Ŀ:��������Ʊһ���ܻ�õ�����������磬����{9��11��8��5��7��12��16��14}��5��ʱ�����룬16��ʱ�����������ܻ���������11��
 * @author ���ٲ�
 *
 */
public class MaxDiff {
	public static void main(String[] args) {
		int[] numArr = {9,11,8,5,7,12,16,14};
		System.out.println(maxDiff(numArr));
	}
	
	/**
	 * ʱ�临�Ӷ�o(n) �����۹̶�ʱ�������Խ�ͻ�õ�����Խ��Ҳ����˵ɨ�赽�����е�i������ʱ��
	 * 				ֻҪ�����ܹ���ס֮ǰ��������󡣾������������������
	 * @param numArr
	 * @return
	 */
	static int maxDiff(int[] numArr){
		if(numArr == null || numArr.length < 2)
			return -1;
		int min = numArr[0];
		int maxDiff = numArr[1] - min;
		for (int i = 2; i < numArr.length; i++) {
			if(numArr[i-1] < min)
				min = numArr[i-1];
			int curDiff = numArr[i] - min;
			if(curDiff > maxDiff)
				maxDiff = curDiff;
			
		}
		return maxDiff;
	}
}

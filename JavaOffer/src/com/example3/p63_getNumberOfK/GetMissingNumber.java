package com.example3.p63_getNumberOfK;

/**
 * ��Ŀ��:0~n-1�ж�ʧ������
 *  	һ������Ϊn-1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0~n-1֮�ڡ�
 *   �ڷ�Χ0~n-1�ڵ�n������������ֻ��һ�����ֲ��ٸ������У����ҳ�������֡�
 * 
 * 
 * @author ���ٲ�
 *
 */
public class GetMissingNumber {
	public static void main(String[] args) {
		int[] n = {0,2,3,4,5};
		int[] n1 = {1,2,3,4,5};
		int[] n2 = {0,1,2,3,4,5,6};
		System.out.println(getMissingNumber2(n));
	}
	
	/**
	 * ��ʽ1:���ڶ��ֲ��ҵݹ��㷨
	 * @param numArr
	 * @return
	 */
	static int getMissingNumber1(int[] numArr){
		if(numArr == null || numArr.length<0)
			return -1;
		return getMissingNumber(numArr, 0, numArr.length-1);
	}
	static int getMissingNumber(int[] numArr , int start , int end){
		if(start > end)
			return -1;
		int middleIndex = (start+end) >> 1;
		int middleData = numArr[middleIndex];
		if(middleData != middleIndex){
			if(middleIndex == 0 || numArr[middleIndex]-numArr[middleIndex-1]!=1  )
				return middleIndex;
			end = middleIndex-1;
		}
		else{
			start = middleIndex+1;
		}
		if(start == numArr.length)
			return numArr.length;
		return getMissingNumber(numArr,start,end);
	}
	
	/**
	 * ��ʽ2:���ڶ��ֲ���ѭ���㷨
	 * @param numArr
	 * @return
	 */
	static int getMissingNumber2(int[] numArr){
		if(numArr == null || numArr.length<0)
			return -1;
		int left = 0;
		int right = numArr.length-1;
		while(left <= right){
			int middle = (left+right) >> 1;
			if(middle != numArr[middle]){
				if(middle == 0 || numArr[middle-1] == middle-1)
					return middle;
				right = middle-1;
			}else
				left = middle+1;
		}
		if(left == numArr.length)
			return numArr.length;
		return -1;
	}
}

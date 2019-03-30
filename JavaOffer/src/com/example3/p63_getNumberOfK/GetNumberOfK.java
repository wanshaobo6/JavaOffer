package com.example3.p63_getNumberOfK;

/**
 * ������53:�����������в�������
 * 		��Ŀһ:ͳ��һ�����������������г��ֵĴ��������磬������������{1,2,3,3,3,3,4,5}������3������3����������г�����4�Σ�������4.
 * ˼��:��������ŵ������н��в��ң����ȵ��뵽���ֲ��ң��ò���Ϊ�����������,���Ƕ��ֲ��ҵ����ֵ���Ŀ�����־�ֹͣ�ˣ�����������Ҫ��������һЩ�ı䣬
 * 	 ��ʱ������������ܹ��õ���һ���������һ�����±�ͺ���
 * @author ���ٲ�
 *
 */
public class GetNumberOfK {
	public static void main(String[] args) {
		int[] num = {1,1,2,3,3,3,3,4,5};
		System.out.println(getNumberOfK(num,5));
	}
	/**
	 * ʱ�临�Ӷ�o(logn)+o(logn) = o(logn)
	 * @param numArr
	 * @param targetNum
	 * @return
	 */
	static int getNumberOfK(int[] numArr , int targetNum){
		if(numArr == null || numArr.length == 0)
			return 0;
		int firstK = getFirstK(numArr, 0, numArr.length-1, targetNum);
		if(firstK == -1)
			return 0;
		int lastK = getLastK(numArr, 0, numArr.length-1, targetNum);
		return  lastK-firstK+1;
	}
	
	static int getFirstK(int[] numArr ,int start , int end ,  int targetNum){
		if(start > end)
			return -1;
		int middleIndex = (start+end)/2;
		int middleData = numArr[middleIndex];
		if(targetNum < numArr[middleIndex]){
			middleIndex = getFirstK(numArr ,start,middleIndex-1,targetNum);
		}else if(targetNum > numArr[middleIndex]){
			middleIndex = getFirstK(numArr ,middleIndex+1,end,targetNum);
		}else if(targetNum == numArr[middleIndex]){
			if((middleIndex > 0 && numArr[middleIndex-1] != targetNum) 
					|| middleIndex==0)
				return middleIndex;
			else
				middleIndex = getFirstK(numArr ,start,middleIndex-1,targetNum);
		}
		return middleIndex;
	}
	static int getLastK(int[] numArr ,int start , int end ,  int targetNum){
		if(start > end)
			return -1;
		int middleIndex = (start+end)/2;
		int middleData = numArr[middleIndex];
		if(targetNum < numArr[middleIndex]){
			middleIndex = getLastK(numArr ,start,middleIndex-1,targetNum);
		}else if(targetNum > numArr[middleIndex]){
			middleIndex = getLastK(numArr ,middleIndex+1,end,targetNum);
		}else if(targetNum == numArr[middleIndex]){
			if((middleIndex < end && numArr[middleIndex+1] != targetNum) 
					|| middleIndex==end)
				return middleIndex;
			else
				middleIndex = getLastK(numArr,middleIndex+1,end,targetNum);
		}
		return middleIndex;
	}
}

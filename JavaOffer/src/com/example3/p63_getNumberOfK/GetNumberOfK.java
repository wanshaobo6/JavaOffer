package com.example3.p63_getNumberOfK;

/**
 * 面试题53:在排序数组中查找数字
 * 		题目一:统计一个数字在排序数组中出现的次数，例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4.
 * 思考:若在排序号的数组中进行查找，首先得想到二分查找，该查找为排序数组而生,但是二分查找当数字等于目标数字就停止了，所以我们需要对它进行一些改变，
 * 	 这时候我们想如果能够得到第一个数和最后一个数下标就好了
 * @author 万少波
 *
 */
public class GetNumberOfK {
	public static void main(String[] args) {
		int[] num = {1,1,2,3,3,3,3,4,5};
		System.out.println(getNumberOfK(num,5));
	}
	/**
	 * 时间复杂度o(logn)+o(logn) = o(logn)
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

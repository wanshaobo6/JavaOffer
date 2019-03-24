package com.example3.p05_findTheNumExceedHalfInArray;

/**
 * 面试题39; 数组中出现次数超过一半的数字
 * 	题目：数组中一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为 9 的数组
 * 		{1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2.
 * 
 * 
 * @author 万少波
 *
 */
public class FindTheNumExceedHalfInArray {
	public static void main(String[] args) {
		int[] nums = {2,1};
		System.out.println(partition(nums, 0, nums.length-1));
		/*try {
			System.out.println(moreThanHalfNum1(nums));
			System.out.println(moreThanHalfNum2(nums));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	/**
	 *方式1 : 基于partition函数的时间复杂度为o(n)的算法  T(n) = T(n/2) + n
	 *			关于中位数的时间复杂度为o(n)：https://blog.csdn.net/q503267755/article/details/52016847?utm_source=blogkpcl2
	 *			
	 * 思想:基于快速排序,求出数组中出现次数超过一半的数字,排序后中位数就是超过一半的数字,但是如果按照平常的冒泡，归并排序却排出了整个数或者排一半消耗的都是o(n2)的
	 * 		时间复杂度, 受快速排序的启发，我们随机选出一位数，然后调整数组中数字的顺序，使得选中的数左边的数字小于该数，右边的大于该数。如果恰好选出下表为n/2，就是
	 * 		中位数否则重新制定顺序重排 递归
	 * @param numArr
	 * @return
	 * @throws Exception 
	 */
	static int moreThanHalfNum1(int[] numArr) throws Exception{
		checkInvalidArray(numArr); //检查数组的有效性
		int start = 0;
		int end = numArr.length-1;
		int middle = end >> 1;
		int index = partition(numArr , start , end);
		while(index != middle){
			if(index>middle){
				end = index -1;
				index = partition(numArr , start , end);
			}else{
				start = index + 1;
				index = partition(numArr , start , end);
			}
		}
		
		checkMoreThanHalf(numArr,numArr[index]);//检验输入的是不是超过一半的
		return numArr[index];
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 方式2:根据数组特点   时间复杂度o(n)
	 * 		思想:就算数组中其他所有数字和超过一半的这个数字的数量抵消 最后剩下的还是超过一半的这个数
	 * 	 实现:我们在遍历数组的时候保存两个值:一个是数组中的一个数字，一个是出现的次数,遍历到下一个数字的时候，若和前一个相同则次数+1,若不同次数减一,
	 * 			次数为0时，保存下一个狮子，并把次数设为1
	 * @param numArr
	 * @return
	 * @throws Exception 
	 */
	static int moreThanHalfNum2(int[] numArr) throws Exception{
		checkInvalidArray(numArr); //检查数组的有效性
		int result = numArr[0];
		int times = 1;
		for (int i = 0; i < numArr.length; i++) {
			if(times == 0){
				result = numArr[i];
				times = 1;
			}else if(result == numArr[i]){
				times++;
			}else
				times --;
		}
		checkMoreThanHalf(numArr,result);//检验输入的是不是超过一半的
		return result;
	}
	
	  private static void checkMoreThanHalf(int[] numArr, int num) throws Exception {
		// TODO Auto-generated method stub
		int times = 0;
		for (int j = 0; j < numArr.length; j++) {
			if(numArr[j] == num)
				times++;
		}
		if(times*2 <= num){
			throw new Exception("无效的输入 无超过一半的输入");
		}
	}

	static int partition(int[] numArr, int start, int end) {
		// TODO Auto-generated method stub
		if(start >= end  || numArr == null  ||  numArr.length<2 )
			return end;
		int stdPoint = start;
		int std = numArr[start];
		start += 1;
		while( start<end ){
			//找到第一个小于等于哨兵的元素
			while(start<end && numArr[end]>=std)
				end -- ;
			//找到第一个大于等于哨兵的元素
			while(start<end && std>numArr[start])
				start ++ ;
			if(start<end){
				//交换数据
				int swap = numArr[start];
				numArr[start] = numArr[end];
				numArr[end] = swap;
			}
		}
		if(std > numArr[start]){
			numArr[stdPoint] = numArr[start];
			numArr[start] = std;
		}
		if(stdPoint+1 == start && numArr.length!=2)
			return stdPoint;
		return start;
	}

	static void checkInvalidArray(int[] numArr) throws Exception {
		// TODO Auto-generated method stub
		if(numArr == null || numArr.length <= 0)
			throw new Exception("无效的输入");
	}
	
}

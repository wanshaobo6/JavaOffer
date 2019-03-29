package com.example3.p51_inversePairs;

import com.example.utils.SortUtils;

/**
 * 面试题51: 数组中的逆序对
 * 	在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 * 输入一个数组，求出这个数组中的逆序对的总数
 * 例如，在数组 {7，5，6，4} 中，一共存在 5 个逆序对，分别是 (7，6)，(7，5)，(7，4)，(6，4)，(5，4)
 * 
 *    归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。java中Arrays.sort()
 * 采用了一种名为TimSort的排序算法，就是归并排序的优化版本。从上文的图中可看出，每次合并操作的平均时间复杂度为O(n)，
 * 而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 * 
 * 	思路:主要考察对归并排序的掌握程度 , 应该注意到归并排序交换时若前面的数大于后面的数,就存在逆序数，右边比该数小的数都可以和该数组合成逆序数
 * @author 万少波
 *
 */
public class InversePairs {
	public static void main(String[] args) {
		 int []arr =  {7,5,6,4};
		 int[] arr2 = {6,202,100,301,38,8,1};
		 System.out.println(inversePairs(arr2));
		 SortUtils.showArray(arr2);
	}
	
	/**
	 * 方式1:
	 * 时间复杂度o(nlogn)  但是需要一个长度为n的辅助空间
	 * @param numArr
	 * @return
	 */
	static int inversePairs(int[] numArr){
		if(numArr == null || numArr.length ==0)
			return -1;
		int[] temp = new int[numArr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		return inversePairsSort(numArr,0,numArr.length-1, temp);
	}

	private static int inversePairsSort(int[] numArr, int left, int right, int[] temp) {
		// TODO Auto-generated method stub
		int total = 0;
		if(left < right){
			int middle = (left+right)/2;
			total += inversePairsSort(numArr, left, middle, temp);
			total += inversePairsSort(numArr, middle+1, right, temp);
			total += inversePairsMerge(numArr, left, middle,  right, temp); 
		}
		return total;
	}

	private static int inversePairsMerge(int[] numArr, int left,int middle , int right, int[] temp) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = left;	//左序列指针
		int j = middle+1;	//右序列指针
		int t = 0; //临时数组指针
		while (i<=middle && j <=right){
			if(numArr[i] >= numArr[j]){
				sum += right - j+1;
				temp[t++] = numArr[i++];
			}else{
				temp[t++] = numArr[j++];
			}
		}
		//若左边有剩余
		while(i <= middle){
			temp[t++] = numArr[i++];
		}
		//右边有小的剩余无所谓
		while(j <= right){
			 temp[t++] = numArr[j++];
		}
		   t = 0;
	        //将temp中的元素全部拷贝到原数组中
	        while(left <= right){
	        	numArr[left++] = temp[t++];
	        }
	    return sum;
	}
}

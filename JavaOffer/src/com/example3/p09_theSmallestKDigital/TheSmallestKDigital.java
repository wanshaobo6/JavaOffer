package com.example3.p09_theSmallestKDigital;

import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 面试题40: 最小的k个数
 *    题目:输入n个整数,找出其中最小的k个数字,例如，输入4,5,1,6,2,7,3,8这8个数字,则最小的4个数字是1,2,3,4
 *    
 * @author 万少波
 *
 */
public class TheSmallestKDigital {
	public static void main(String[] args) {
		int[] numArr = {4,5,1,6,2,7,3,8};
		int[] arr = getTheSmallestKDigital1(numArr,4);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(numArr[i]);
		}
		System.out.println();
		TreeSet dig = getTheSmallestKDigital2(numArr,4);
		System.out.println(dig);
	}
	
	/**
	 * 解法1:时间复杂度o(n)  只有当我们可以修改输入的数组时可用
	 * @param numArr
	 * @return
	 */
	static int[] getTheSmallestKDigital1(int[] numArr , int k){
		if(numArr == null || numArr.length == 0 || k <= 0|| k > numArr.length )
			return null;
		int start = 0;
		int end = numArr.length-1;
		int index = partition(numArr,start,end);
		while(index != k){
			if(index < k){
				start = start+1;
				index = partition(numArr,start,end);
			}else{
				end = end -1;
				index = partition(numArr,start,end);
			}
		}
		return Arrays.copyOf(numArr, k);
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
	
	/**
	 * 	解法2：时间复杂度o(nlogk)的算法,特别适合处理海量数据 , 用TreeSet方法不允许数据重复
	 * 
	 * TreeSet原理：TreeSet在存储对象的时候，可以排序，但是需要制定排序的算法。
	 * 			其中的Integer和String都能实现默认的排序顺序。在使用TreeSet存储
	 * 			对象的时候，add（）方法内部就会自动调用compareTo（）方法进行比较
	 * 			，根据比较结果使用二叉树的形式进行存储。
	 *	TreeSet是一个有序集合，TreeSet中的元素将按照升序排列，缺省是按照自然排序进
	 *			行排列，意味着TreeSet中的元素要实现Comparable接口。或者有一个自定义的比较器。
	 *我们可以在构造TreeSet对象时，传递实现Comparator接口的比较器对象。                                                                                                          
	 */
	static TreeSet getTheSmallestKDigital2(int[] numArr, int k){
		if(numArr == null || numArr.length == 0 || k<=0 || k > numArr.length)
			return null;
		TreeSet<Integer> leastNumbers  = new TreeSet();
		for (int num :numArr) {
			if(leastNumbers.size() < k){
				leastNumbers.add(num);
			}else{
				int curMax = leastNumbers.last();
				if(curMax > num){
					leastNumbers.pollLast();
					leastNumbers.add(num);
				}
			}
		}
		return leastNumbers;
	}
}

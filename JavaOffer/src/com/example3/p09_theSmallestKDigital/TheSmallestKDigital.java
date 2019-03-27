package com.example3.p09_theSmallestKDigital;

import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * ������40: ��С��k����
 *    ��Ŀ:����n������,�ҳ�������С��k������,���磬����4,5,1,6,2,7,3,8��8������,����С��4��������1,2,3,4
 *    
 * @author ���ٲ�
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
	 * �ⷨ1:ʱ�临�Ӷ�o(n)  ֻ�е����ǿ����޸����������ʱ����
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
			//�ҵ���һ��С�ڵ����ڱ���Ԫ��
			while(start<end && numArr[end]>=std)
				end -- ;
			//�ҵ���һ�����ڵ����ڱ���Ԫ��
			while(start<end && std>numArr[start])
				start ++ ;
			if(start<end){
				//��������
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
	 * 	�ⷨ2��ʱ�临�Ӷ�o(nlogk)���㷨,�ر��ʺϴ��������� , ��TreeSet���������������ظ�
	 * 
	 * TreeSetԭ��TreeSet�ڴ洢�����ʱ�򣬿������򣬵�����Ҫ�ƶ�������㷨��
	 * 			���е�Integer��String����ʵ��Ĭ�ϵ�����˳����ʹ��TreeSet�洢
	 * 			�����ʱ��add���������ڲ��ͻ��Զ�����compareTo�����������бȽ�
	 * 			�����ݱȽϽ��ʹ�ö���������ʽ���д洢��
	 *	TreeSet��һ�����򼯺ϣ�TreeSet�е�Ԫ�ؽ������������У�ȱʡ�ǰ�����Ȼ�����
	 *			�����У���ζ��TreeSet�е�Ԫ��Ҫʵ��Comparable�ӿڡ�������һ���Զ���ıȽ�����
	 *���ǿ����ڹ���TreeSet����ʱ������ʵ��Comparator�ӿڵıȽ�������                                                                                                          
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

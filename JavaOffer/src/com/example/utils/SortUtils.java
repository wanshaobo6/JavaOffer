package com.example.utils;

public class SortUtils {
	
	public static void main(String[] args) {
		int[] nums = {2,1,3,4,5};
		QuickSort(nums , 0 , nums.length-1);
	}
	/**
	 * 冒泡排序
	 * @param array
	 */
	public static void bubbleSort(int[] array){
		for(int i =0;i<array.length-1;i++){
			for(int j=i+1 ; j<array.length;j++){
				if(array[j-1]>array[j]){
					int swap = array[j-1];
					array[j-1] = array[j];
					array[j] = swap;
				}
			}
		}
	}
	
	/**
	 * 快速排序
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void QuickSort(int[] array, int left, int right) {
		//判断输入条件
		if(array == null || array.length<2 || left>=right){
			return;
		}
		int temp = array[left];
		int i = left+1;
		int j = right;
		while(i != j){
			//右哨兵移动
			while(array[j]>=temp && i<j){
				j--;
			}
			//左哨兵移动
			while(array[i]<temp  && i<j){
				i++;
			}
			if(i<j){
				//交换数据
				int swap = array[i];
				array[i] = array[j];
				array[j] = swap;
			}
		}
		
		//交换基准数 
			if(temp>array[i]){
			array[left] = array[i];
			array[i] = temp;
			}
		//递归处理左边数据
		QuickSort(array,left,i-1);
		//递归处理右边边数据
		QuickSort(array,i+1,right);
	}
	
	/**
	 * 遍历显示数组
	 * @param array
	 */
	public static void showArray(int[] array) {
		// TODO Auto-generated method stub
		if(array==null){return;}
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

}

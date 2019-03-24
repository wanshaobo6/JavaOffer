package com.example.utils;

public class SortUtils {
	
	public static void main(String[] args) {
		int[] nums = {2,1,3,4,5};
		QuickSort(nums , 0 , nums.length-1);
	}
	/**
	 * ð������
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
	 * ��������
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void QuickSort(int[] array, int left, int right) {
		//�ж���������
		if(array == null || array.length<2 || left>=right){
			return;
		}
		int temp = array[left];
		int i = left+1;
		int j = right;
		while(i != j){
			//���ڱ��ƶ�
			while(array[j]>=temp && i<j){
				j--;
			}
			//���ڱ��ƶ�
			while(array[i]<temp  && i<j){
				i++;
			}
			if(i<j){
				//��������
				int swap = array[i];
				array[i] = array[j];
				array[j] = swap;
			}
		}
		
		//������׼�� 
			if(temp>array[i]){
			array[left] = array[i];
			array[i] = temp;
			}
		//�ݹ鴦���������
		QuickSort(array,left,i-1);
		//�ݹ鴦���ұ߱�����
		QuickSort(array,i+1,right);
	}
	
	/**
	 * ������ʾ����
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

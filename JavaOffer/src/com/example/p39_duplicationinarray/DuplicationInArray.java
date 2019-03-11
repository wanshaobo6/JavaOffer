package com.example.p39_duplicationinarray;

import com.example.utils.SortUtils;

/**
 * ��һ������Ϊn����������������ֶ���0~n-1�ķ�Χ�ڡ�������ĳЩ���ֵ��ظ��ģ�����֪���м��������ظ��ˣ�
 * Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡��������볤��Ϊ�ߵ�����{2,3,1,0,2,5,3}��
 * ��ô��Ӧ������ظ�����Ϊ����2������3
 *
**/
public class DuplicationInArray { 
	public static void main(String[] args) {
		int[] array = {6,8,3,4,5,4,2,1,5,4,7,4};
		int duplication1 = getDuplication1(array);
		System.out.println("duplication1:"+duplication1);
		int duplication2 = getDuplication2(array);
		System.out.println("duplication2:"+duplication2);
		int duplication3 = getDuplication3(array);
		System.out.println("duplication3:"+duplication3);
		int duplication4 = getDuplication4(array);
		System.out.println("duplication4:"+duplication4);
	}
	


	/**
	 * ����1�������ƽ�
	 * ʱ�临�Ӷ�O(n2) �ռ临�Ӷ�O(1)
	 * @param array
	 * @return
	 */
	static int getDuplication1(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i] == array[j]){
					return array[i];
				}
			} 
		}
		return -1;
	}
	
	/**
	 * ����2: ��������������
	 * ʱ�临�Ӷ�Ϊ�����ʱ�临�Ӷ�O(nlogn) �ռ临�Ӷ�O(1)
	 */
	static int getDuplication2(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		//ð������ ʱ�临�Ӷ�O(n2) ���Ƽ�
		/*	for(int i =0;i<array.length-1;i++){
				for(int j=i+1 ; j<array.length;j++){
					if(array[j-1]>array[j]){
						int swap = array[j-1];
						array[j-1] = array[j];
						array[j] = swap;
					}
				}
			}*/
		//�������� ʱ�临�Ӷ�O(nlogn) �Ƽ�
		SortUtils.QuickSort(array ,0 ,array.length-1);
		//��������ʱ�临�Ӷ�O(n)
		for(int i=0;i<array.length-1;i++){
			if(array[i]==array[i+1]){
				return array[i];
			}
		}
		return -1;
	}
	
	/**
	 * ����hash�� ��ͷ��βɨ��������� ÿɨ�赽һ��ʱ�����O(1)��ʱ�临�Ӷ��ж�Hash�����Ƿ��Ѿ����������Ԫ��
	 * ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n) 
	 * @param array
	 * @return
	 */
	static int getDuplication3(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		int[] hashTable = new int[array.length];
		for(int num : array){
			if(hashTable[num] == 1){
				return num;
			}
			hashTable[num] = 1;
		}
		return -1;
	}
	
/**
 * �Ժ�����
 * ��ͷ��βɨ����������ÿһ�����֣�ɨ�赽����Ϊi��ֵʱ�����ȱȽ���������ǲ��ǵ���i��
 * ����ǣ�����ɨ��
 * ������ǣ����������͵�m�����ֱȽϣ����ֵһ�������ҵ��ظ����֣����ֵ����ȣ��ͽ��������i���͵�m�����֣�
 * �����ظ�����Ƚ�
 * ʱ�临�Ӷȣ� O(n) �ռ临�Ӷ� O(1)
 */
	static int getDuplication4(int[] array){
		if(array == null || array.length<2){
			return -1;
		}
		for(int i = 0;i<array.length;i++){
			//�������һ�����ֲ���0~n-1 �˳�
			if(array[i]<0 || array[i]>array.length-1)
				return -1;
		}
		for(int i = 0;i<array.length;i++){
			//��ǰ���������ֵ����±����������һ��
			while(array[i] != i){
				//�Ժ����� ֵi ��Ӧ array[i]λ��
				if(array[i] == array[array[i]]){
					return array[i];
				}else{
					int temp = array[array[i]];
					array[array[i]] = array[i];
					array[i] =temp;
				}
			}
		}

		return -1;
	}
	
}

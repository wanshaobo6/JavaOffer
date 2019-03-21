package com.example2.p65_stackWithMin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ������30: ����min������ջ
 *  ��Ŀ: ����ջ�����ݽṹ  , ���ڸ�������ʵ��igen�ܹ��õ�ջ����СԪ�ص�min����,�ڸ�ջ��,����min.push��pop��ʱ�临�Ӷȶ���o(1)
 *  
 *  
 * @author ���ٲ�
 *
 */
public class StackWithMin<E extends Comparable> {
	//��������
	private Object[] elementData;
	
	//����ָ��ͷ
	private int top ; 
	
	//��ʼ��Ԫ�����ݳ�
	private static final int initElementDataLen = 10;
	
	//�����洢
	private Object[] auxiliaryData;
	
	//����ָ��ͷ
	private int auxiliaryTop;
	
	//��ʼ���������ݳ�
	private static final int initAuxiliartDataLen = 10;
	
	//Ԫ�����ݵ�����
	private static final int arrayIncrement = 10;

	/**
	 * ��ʼ������
	 */
	public StackWithMin() {
		elementData = new Object[initElementDataLen];
		top = 0;
		auxiliaryData = new Object[initAuxiliartDataLen];
		auxiliaryTop = 0;
	}
	
	/**
	 * ��ȡ��Сֵ
	 * @return
	 */
	public E min(){
		return auxiliaryPeek();
	}
	
	/**
	 * ����ջ��Ԫ��  ������ջ
	 * @return
	 */
	public E peek(){
		if(top<1){
			return null;
		}
		return (E) elementData[top-1];
	}
	
	/**
	 * ����ջ������Ԫ��  ������ջ
	 * @return
	 */
	private E auxiliaryPeek(){
		if(auxiliaryTop<1){
			return null;
		}
		return (E) auxiliaryData[auxiliaryTop-1];
	}
	
	/**
	 * ��ջ
	 * @return
	 */
	public E pop(){
		E item = peek();
		if(item==null)
			return null;
		if(item.compareTo(auxiliaryPeek()) == 0){
			auxiliaryData[auxiliaryTop-1] = null;
			auxiliaryTop --;
		}
		elementData[top-1] = null;
		top--;
		return item;
	}
	
	/**
	 * ѹջ
	 * @param item
	 */
	public  void push(E item){
		if(item == null)
			return ;
		ensurCapacity(top,auxiliaryTop);
		E auxiliaryItem =  auxiliaryPeek();
		if(auxiliaryItem == null || item.compareTo(auxiliaryItem) <= 0 ){
			//��ӵ������ռ�
			auxiliaryData[auxiliaryTop] = item;
			auxiliaryTop ++ ;
		}
		elementData[top] = item;
		top ++;
	}

	/**
	 * ȷ�������㹻
	 * @param top
	 * @param auxiliaryTop
	 */
	private  void ensurCapacity(int top, int auxiliaryTop) {
		// TODO Auto-generated method stub
		int nowEleCapacity = elementData.length;
		int nowAuxCapacity = auxiliaryData.length;
		if(top >= nowEleCapacity){
			nowEleCapacity += arrayIncrement;
			elementData = Arrays.copyOf(elementData, nowEleCapacity);
		}
		if(auxiliaryTop >= nowAuxCapacity){
			nowAuxCapacity += arrayIncrement;
			auxiliaryData = Arrays.copyOf(elementData, nowAuxCapacity);
		}
	}
}

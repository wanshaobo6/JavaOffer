package com.example2.p65_stackWithMin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 面试题30: 包含min函数的栈
 *  题目: 定义栈的数据结构  , 请在该类型中实现igen能够得到栈的最小元素的min函数,在该栈中,调用min.push及pop的时间复杂度都是o(1)
 *  
 *  
 * @author 万少波
 *
 */
public class StackWithMin<E extends Comparable> {
	//储存数据
	private Object[] elementData;
	
	//数据指针头
	private int top ; 
	
	//初始化元素数据长
	private static final int initElementDataLen = 10;
	
	//辅助存储
	private Object[] auxiliaryData;
	
	//辅助指针头
	private int auxiliaryTop;
	
	//初始化辅助数据长
	private static final int initAuxiliartDataLen = 10;
	
	//元素扩容的增量
	private static final int arrayIncrement = 10;

	/**
	 * 初始化变量
	 */
	public StackWithMin() {
		elementData = new Object[initElementDataLen];
		top = 0;
		auxiliaryData = new Object[initAuxiliartDataLen];
		auxiliaryTop = 0;
	}
	
	/**
	 * 获取最小值
	 * @return
	 */
	public E min(){
		return auxiliaryPeek();
	}
	
	/**
	 * 返回栈顶元素  但不退栈
	 * @return
	 */
	public E peek(){
		if(top<1){
			return null;
		}
		return (E) elementData[top-1];
	}
	
	/**
	 * 返回栈顶辅助元素  但不退栈
	 * @return
	 */
	private E auxiliaryPeek(){
		if(auxiliaryTop<1){
			return null;
		}
		return (E) auxiliaryData[auxiliaryTop-1];
	}
	
	/**
	 * 退栈
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
	 * 压栈
	 * @param item
	 */
	public  void push(E item){
		if(item == null)
			return ;
		ensurCapacity(top,auxiliaryTop);
		E auxiliaryItem =  auxiliaryPeek();
		if(auxiliaryItem == null || item.compareTo(auxiliaryItem) <= 0 ){
			//添加到辅助空间
			auxiliaryData[auxiliaryTop] = item;
			auxiliaryTop ++ ;
		}
		elementData[top] = item;
		top ++;
	}

	/**
	 * 确保容量足够
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

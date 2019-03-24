package com.example3.p00_example2;

/**
 *   题目:八皇后问题：
 *      如何能够在 8×8的国际象棋棋盘上放置八个皇后，使得任何一个皇后都无法直接吃掉其他的皇后？为了达到此目的，任两个皇后都不能处于同一条横行、纵行或斜线上。
 *	编程实现八皇后问题算法，演示算法结果（多个不同的摆法）。
 * @author 万少波
 *
 */
public class example_eightQueue {
		public static void main(String[] args) {
			int[] columnsIndex = {0,1,2,3,4,5,6,7};
			int time = caculate(columnsIndex);
			System.out.println(time);
		}
		
		private static int caculate(int[] columnsIndex) {
			// TODO Auto-generated method stub
			if(columnsIndex==null || columnsIndex.length!=8)
				return -1;
			Timer timer = new Timer();
			 check(columnsIndex,0 ,timer);
			 return timer.time;
		}

		//求出数组的全排列  并判断是否符合条件
		static void check(int[] columnsIndex , int start , Timer timer){
			if(start >= columnsIndex.length){
				boolean b = checkFeasible(columnsIndex);
				if(b)
					timer.incr();
				return ;
			}
			for (int i = start; i < columnsIndex.length; i++) {
				swap(start,i,columnsIndex);
				 check(columnsIndex,start+1,timer);
				swap(start,i,columnsIndex);
			}
		}
		/**
		 * 数组的定义已经排除了皇后在一行或一列的可能性  任意两个棋子只要不再同一对角线上即满足条件 
		 * j-i == columnsIndex[i]-columnsIndex[j] || i-j == columnsIndex[i]-columnsIndex[j]
		 * @param columnsIndex
		 * @return
		 */
		private static boolean checkFeasible(int[] columnsIndex) {
			// TODO Auto-generated method stub
			for (int i = 0; i < columnsIndex.length; i++) {
				for (int j = i+1; j < columnsIndex.length; j++) {
					if(j-i == columnsIndex[i]-columnsIndex[j] || i-j == columnsIndex[i]-columnsIndex[j]){
						return false;
					}
				}
			}
			return true;
		}

		//交换数据
		private static void swap(int start, int i, int[] columnsIndex) {
			// TODO Auto-generated method stub
			int swap = columnsIndex[start];
			columnsIndex[start] = columnsIndex[i];
			columnsIndex[i] = swap;
		}
		
		//模拟c中的指针变量
		static class Timer{
			int time;
			void incr(){
				time++;
			}
		}
}

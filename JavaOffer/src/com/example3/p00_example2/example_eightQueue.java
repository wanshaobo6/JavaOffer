package com.example3.p00_example2;

/**
 *   ��Ŀ:�˻ʺ����⣺
 *      ����ܹ��� 8��8�Ĺ������������Ϸ��ð˸��ʺ�ʹ���κ�һ���ʺ��޷�ֱ�ӳԵ������Ļʺ�Ϊ�˴ﵽ��Ŀ�ģ��������ʺ󶼲��ܴ���ͬһ�����С����л�б���ϡ�
 *	���ʵ�ְ˻ʺ������㷨����ʾ�㷨����������ͬ�İڷ�����
 * @author ���ٲ�
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

		//��������ȫ����  ���ж��Ƿ��������
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
		 * ����Ķ����Ѿ��ų��˻ʺ���һ�л�һ�еĿ�����  ������������ֻҪ����ͬһ�Խ����ϼ��������� 
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

		//��������
		private static void swap(int start, int i, int[] columnsIndex) {
			// TODO Auto-generated method stub
			int swap = columnsIndex[start];
			columnsIndex[start] = columnsIndex[i];
			columnsIndex[i] = swap;
		}
		
		//ģ��c�е�ָ�����
		static class Timer{
			int time;
			void incr(){
				time++;
			}
		}
}

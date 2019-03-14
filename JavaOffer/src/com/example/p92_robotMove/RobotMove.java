package com.example.p92_robotMove;

import com.example.p89_StringPathInMatrix.StringPathInMatrix;

/**
* ��Ŀ�������˵��˶���Χ
* ������һ��m��n�еķ���һ�������˴�����(0,0)�ĸ��Կ�ʼ�ƶ�����ÿ�ο��������������ƶ�һ�񣬵����ܽ������������λ֮�ʹ���k�ĸ��ӡ�
* ���磬��k����18ʱ���������ܽ���(35,37)����Ϊ3+5+3+7=18����ȴ���ܽ���(35,38)����Ϊ3+5+3+8=19>18��
* ���ʸû������ܹ�������ٸ����ӡ�
* <p>
* ˼·��
* ÿǰ��һ���󣬿�ѡ�ƶ���Ϊ���������ĸ���
* Ϊ���ж�ĳһ�������Ƿ���Խ���Ӷ����м�����������Ҫ���Ǳ߽�ֵ�������λ����֮�ͣ���Ҫ�жϸø����Ƿ��Ѿ������ʹ���
* ������Ҫһ����������������¼�������Ƿ��ѱ����ʡ�
* 
* 
*/
public class RobotMove {
	public static void main(String[] args) {
		System.out.println(movingCount(0, 3, 4));
		System.out.println(movingCount(1, 3, 4));
		System.out.println(movingCount(9, 2, 20));
	}
	
	public static int movingCount(int threshold , int rows , int cols){
		if(threshold < 0 || rows <= 0 || cols <= 0)
			return 0;
		boolean[][] visitedFlag = new boolean[rows][cols];
		int count =  movingCountCore(threshold,rows,cols,0,0,visitedFlag);
		StringPathInMatrix.showBooleanMatrix(visitedFlag);
		return count;
	}

	private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visitedFlag) {
		// TODO Auto-generated method stub
		int count = 0;
		if(check(threshold,rows,cols,row,col,visitedFlag)){
			visitedFlag[row][col] = true;
			return count = 1 + movingCountCore(threshold,rows,cols,row+1,col,visitedFlag)+movingCountCore(threshold,rows,cols,row-1,col,visitedFlag)
						+movingCountCore(threshold,rows,cols,row,col+1,visitedFlag)+movingCountCore(threshold,rows,cols,row,col-1,visitedFlag);
		}
		return count;
	}
	
	
	private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visitedFlag) {
		// TODO Auto-generated method stub
		if(row >=0 && col >= 0 && row < rows && col < cols && !visitedFlag[row][col] && getDigSum(row)+getDigSum(col) <= threshold){
			return true;
		}
		return false;
	}
	
	private static int getDigSum(int num) {
		// TODO Auto-generated method stub
		int sum = 0;
		while(num > 0){
			sum += num%10;
			num = num / 10 ;
		}
		return sum;
	}
}

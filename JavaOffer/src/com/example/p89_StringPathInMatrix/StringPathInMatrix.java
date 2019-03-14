package com.example.p89_StringPathInMatrix;
/**
 * 题目：矩阵中的路径
 * 设计一个函数，用来判断一个矩阵中是否存在一条包含某字符串的路径。
 * （1）起点随意；（2）路径的移动只能是上下左右；
 * （3）访问过的位置不能再访问。以下图矩阵为例，包含“bfce”，但是不包含“abfb”。
 * a      b      t      g
 * c      f      c      s
 * j      d      e      h
 * <p>
 * 解题思路：
 * 本题考察回溯法。
 * 回溯法适合解决由多个步骤组成的问题，且每个步骤都有多个选项。当在某一步选择了其中一个选项，就进入下一步，然后面临新的选项。
 * 如果当前的选项已经确定没有正确答案，就回溯到上一步，在上一步选择另一选项，重复进行。
 * 回溯法的求解过程一般都可以用树状结构表示出来。实现代码很适合用递归完成。
 *
 * @author 万少波
 */
public class StringPathInMatrix {
	public static void main(String[] args) {
		char[][] data = {
				{'a', 'b', 't', 'g'},
				{'c', 'f', 'c', 's'},
				{'j', 'd', 'e', 'h'}};
		System.out.println(hasPath(data, "bfce"));
		System.out.println(hasPath(data, "abfb"));
	}

	private static boolean hasPath(char[][] data, String str) {
		if(data == null || data.length ==0 || str ==null || str.length() ==0)
			return false;
		int rows = data.length;
		int columns = data[0].length;
		boolean[][] visitFlag = new boolean[rows][columns];
		//遍历数组寻找入口
		for(int row =0 ; row<rows ; row++){
			for(int column =0; column<columns ;column++){
				if(hashPathCore(data,row,column,visitFlag,str,0))
					return true;
			}
		}
		return false;
	}

	private static boolean hashPathCore(char[][] data, int row, int col, boolean[][] visitFlag, String str, int strIndex) {
		//判断是否查询完毕
		if(strIndex >= str.length())
			return true;
		//判断当前条件是否允许继续查询
		if(row >= data.length || row < 0 || col >=data[0].length || col < 0)
			return false;
		//递归查询
		if(!visitFlag[row][col] && data[row][col] == str.charAt(strIndex)){
			//将当前置为已访问
			visitFlag[row][col] = true;
			boolean result = hashPathCore(data,row+1,col,visitFlag,str,strIndex+1) || hashPathCore(data,row-1,col,visitFlag,str,strIndex+1)
								||hashPathCore(data,row,col+1,visitFlag,str,strIndex+1) || hashPathCore(data,row,col-1,visitFlag,str,strIndex+1);
			
			//有一条路径通的
			if(result){
				return true;
			}else{
				// 当前路线递归失败，要把这条路径上的标记去掉
				// 因为其他起点的路径依然可以访问北门路径节点
				visitFlag[row][col] = true;
				return false;
			}
		}
		return false;
	}
}


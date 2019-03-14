package com.example.p89_StringPathInMatrix;
/**
 * ��Ŀ�������е�·��
 * ���һ�������������ж�һ���������Ƿ����һ������ĳ�ַ�����·����
 * ��1��������⣻��2��·�����ƶ�ֻ�����������ң�
 * ��3�����ʹ���λ�ò����ٷ��ʡ�����ͼ����Ϊ����������bfce�������ǲ�������abfb����
 * a      b      t      g
 * c      f      c      s
 * j      d      e      h
 * <p>
 * ����˼·��
 * ���⿼����ݷ���
 * ���ݷ��ʺϽ���ɶ��������ɵ����⣬��ÿ�����趼�ж��ѡ�����ĳһ��ѡ��������һ��ѡ��ͽ�����һ����Ȼ�������µ�ѡ�
 * �����ǰ��ѡ���Ѿ�ȷ��û����ȷ�𰸣��ͻ��ݵ���һ��������һ��ѡ����һѡ��ظ����С�
 * ���ݷ���������һ�㶼��������״�ṹ��ʾ������ʵ�ִ�����ʺ��õݹ���ɡ�
 *
 * @author ���ٲ�
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
		//��������Ѱ�����
		for(int row =0 ; row<rows ; row++){
			for(int column =0; column<columns ;column++){
				if(hashPathCore(data,row,column,visitFlag,str,0))
					return true;
			}
		}
		return false;
	}

	private static boolean hashPathCore(char[][] data, int row, int col, boolean[][] visitFlag, String str, int strIndex) {
		//�ж��Ƿ��ѯ���
		if(strIndex >= str.length())
			return true;
		//�жϵ�ǰ�����Ƿ����������ѯ
		if(row >= data.length || row < 0 || col >=data[0].length || col < 0)
			return false;
		//�ݹ��ѯ
		if(!visitFlag[row][col] && data[row][col] == str.charAt(strIndex)){
			//����ǰ��Ϊ�ѷ���
			visitFlag[row][col] = true;
			boolean result = hashPathCore(data,row+1,col,visitFlag,str,strIndex+1) || hashPathCore(data,row-1,col,visitFlag,str,strIndex+1)
								||hashPathCore(data,row,col+1,visitFlag,str,strIndex+1) || hashPathCore(data,row,col-1,visitFlag,str,strIndex+1);
			
			//��һ��·��ͨ��
			if(result){
				return true;
			}else{
				// ��ǰ·�ߵݹ�ʧ�ܣ�Ҫ������·���ϵı��ȥ��
				// ��Ϊ��������·����Ȼ���Է��ʱ���·���ڵ�
				visitFlag[row][col] = true;
				return false;
			}
		}
		return false;
	}
}


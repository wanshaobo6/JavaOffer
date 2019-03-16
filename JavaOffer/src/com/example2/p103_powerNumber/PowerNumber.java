package com.example2.p103_powerNumber;

public class PowerNumber {
	public static void main(String[] args) {
		System.out.println(powNumber(0));
		System.out.println(powNumber(4));
		System.out.println(powNumber(5));
		System.out.println(powNumber(16));
		System.out.println(changeNumber(10,13));
	}
	/**
	 * �ж�һ�������ǲ���2�������η���
	 * @param num
	 * @return
	 */
	public static boolean powNumber(int num){
		if(num==1)
			return true;
		return (num & (num-1)) ==  0 ? true : false;
	}
	
	/**
	 * orgin�Ķ�������Ҫ�������ٴα任�õ�end
	 * 1 ��origin��end���
	 * 2 ��������ֵ��1�ĸ���
	 * @param origin
	 * @param end
	 * @return
	 */
	public static int changeNumber(int origin ,int end){
		int num = origin ^ end;
		int count = 0;
		while(num!=0){
			count++;
			num = num & (num-1);
		}
		return count;
	}
}

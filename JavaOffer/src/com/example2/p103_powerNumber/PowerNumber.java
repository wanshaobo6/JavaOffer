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
	 * 判断一个数是是不是2的整数次方数
	 * @param num
	 * @return
	 */
	public static boolean powNumber(int num){
		if(num==1)
			return true;
		return (num & (num-1)) ==  0 ? true : false;
	}
	
	/**
	 * orgin的二进制需要经过多少次变换得到end
	 * 1 将origin和end异或
	 * 2 计算异或后值的1的个数
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

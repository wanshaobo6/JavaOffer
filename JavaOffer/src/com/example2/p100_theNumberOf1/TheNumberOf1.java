package com.example2.p100_theNumberOf1;


public class TheNumberOf1 {
	public static void main(String[] args) {
		System.out.println(numberOf1_1(9));
		System.out.println(numberOf1_2(-9));
	}
	
	/**
	 * 遇到负数无法解决
	 * @param n
	 * @return
	 */
	public static int numberOf1_1(int n){
		int count = 0;
		while(n!=0){
			if((n&1) == 1){
				count++;
			}
			//乘除比位运算效率低很多，所以这里可以用/2但是不推荐
			n = n>>1;
		}
		return count;
	}
	
	/**
	 * 改进版本不移动n 改为移动flag
	 * @param n
	 * @return
	 */
	public static int numberOf1_2(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n&flag) != 0){
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	public static int numberOf1_3(int n){
		return 0;
	}

}

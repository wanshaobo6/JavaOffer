package com.example2.p100_theNumberOf1;


public class TheNumberOf1 {
	public static void main(String[] args) {
		System.out.println(numberOf1_1(9));
		System.out.println(numberOf1_2(-9));
	}
	
	/**
	 * ���������޷����
	 * @param n
	 * @return
	 */
	public static int numberOf1_1(int n){
		int count = 0;
		while(n!=0){
			if((n&1) == 1){
				count++;
			}
			//�˳���λ����Ч�ʵͺܶ࣬�������������/2���ǲ��Ƽ�
			n = n>>1;
		}
		return count;
	}
	
	/**
	 * �Ľ��汾���ƶ�n ��Ϊ�ƶ�flag
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

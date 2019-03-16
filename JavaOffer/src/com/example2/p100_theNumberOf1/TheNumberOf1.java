package com.example2.p100_theNumberOf1;

  /**
	*ʵ��һ������������һ��int������������������ڼ�����ж����Ʊ�ʾ��ʽ��1�ĸ�����
	* ����9->1001,���2��-3->11111111111111111111111111111101,���31��
	* <p>
	* ˼·���������Ҫ��������ƺ�λ���㣬����˼·�������ж϶��������ֵ����һλ�ǲ���1�����Ž�������������һλ���������ж�
	* ���������Ļ�����һ�������ǣ���������Ǹ�������һֱ������ѭ��
	* Ϊ�˱�����ѭ�������ǿ��Բ���������n�����Ȱ�n��1�������㣬�ж����λ�ǲ���1��Ȼ���1����һλ���ٺ�n�������㣬�����ж�n�Ĵε�λ�ǲ���1
 	* �����Ļ���ѭ�������������������Ƶ�λ����32λ��������Ҫѭ��32�Σ�������㷨�У������������м���1��ֻ��Ҫѭ������ 
    */
public class TheNumberOf1 {
	public static void main(String[] args) {
		System.out.println(numberOf1_1(9));
		System.out.println(numberOf1_2(9));
		System.out.println(numberOf1_2(9));
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
	 * �Ľ��汾 ���ƶ�n ��Ϊ�ƶ�flag
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
	
	/**
	 *   ��һ��������ȥ1���ٺ�ԭ������������ ���ͻ�Ѹ��������ұߵ�1���0.��ôһ������
	 * ��ôһ�������Ķ������ж��ٸ�1�Ϳ��Խ��д�����������
	 * @param n
	 * @return
	 */
	public static int numberOf1_3(int n){
		int count = 0;
		while(n != 0){
			count++;
			n = (n-1)&n;
		}
		return count;
	}

}

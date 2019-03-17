package com.example2.p14_printToMaxOfNDigit;

/**
 * ��ӡ��1������nλ��
 * <p>
 *������չ:8bit���ַ�����ܹ���ʶ256���ַ�����ʮ��������ֻ��0~9��10�����֣����char��û�кú������ڴ棬��һЩ�˷ѣ���û�и���Ч�ķ�ʽ
 * @author ���ٲ�
 */
public class PrintToMaxOfNDigit {
	public static void main(String[] args) {
		//PrintToMaxOfNDigit_1(100);
		printToMaxOfDigits(2);
	}
	
	/**
	 *
	 * ������2����ӡ1,2......98,99
	 * ע�⣺������Ҫ���Ǵ������⣬���ַ������������������õĽ������֮һ
	 * ���ַ�����ʾ���ֵ�ʱ����ֱ�۵ķ��������ַ�����ÿ���ַ����ǡ�0������9��֮���ĳһ���ַ���������ʾ�����е�һλ����Ϊ������nλ�ģ�
	 * ���������Ҫһ������Ϊn+1���ַ������ַ��������һ���ǽ������š�\0������ʵ�����ֲ���nλ��ʱ�����ַ�����ǰ�벿�ֲ�0����
	 * <p>
	 * �������ǰ��ַ����е�ÿһ�����ֶ���ʼ��Ϊ��0����Ȼ��ÿһ��Ϊ�ַ�����ʾ�����ּ�1���ٴ�ӡ������
	 * ������ֻ��Ҫ�������£�һ�����ַ������������ģ��ӷ������ǰ��ַ����������ִ�ӡ������
	 * <p>
	 * ���ַ������������ģ��ӷ����������������Ƿ������ʶ���Ƿ��λ��ʶ���Լ�ȡ���ַ����鳤�ȣ���������ַ����飬��ĩβ����+1������
	 * ���ĩβ�ַ���+1���Ϊ��С��10�����֣����ǽ�ĩβ��ȥ10���ϡ�0���ַ���ֵΪĩλ����λ��ʶ����Ϊ1����ѭ����λʱ+1��
	 * Ȼ�����ж��Ƿ�Ϊ��С��10���ǵĻ��ظ�����Ĳ��衣
	 * ֱ���жϸ�λ�ǲ��ǲ�С��10���ǵĻ��ַ����������
	 * ���ĩβ�ַ���+1����С��10�����֣�ֱ�Ӽ��ϡ�0����ֵ��ĩβ��������ǰѭ��������û�������
	 * <p> 
	 */
	static void PrintToMaxOfNDigit_1(int n){
		if(n<=0)
			return;
		char[] number = new char[n];
		initNumber(number,'0');
		while(increment(number)){
			printNumber(number);
		}
	}

	/**
	  * ���ַ����������ִ�ӡ��������ʱ��û��ʲô�ر�ֱ������forѭ����������ַ����飬
	  * ����Ҫ�Ӹ�λ��һ������0�Ŀ�ʼ�����
	 * @param number
	 */
	private static void printNumber(char[] number) {
		// TODO Auto-generated method stub
		if(number == null)
			return;
		boolean sFlag = false;
		for(int i=0 ; i< number.length ;i++){
			if(number[i] != '0')
				sFlag = true;
			if(sFlag){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}

	private static boolean increment(char[] number) {
		// TODO Auto-generated method stub
		if(number == null)
			return false;
		boolean overFlowFlag = false;  //�����ʶ
		int nTakeOver = 0; //��λ��ʶ
		int nLength = number.length;
		for(int i = nLength-1 ; i>=0 ;i--){
			int nSum  = number[i] - '0' + nTakeOver;
			if(i == nLength-1)
				nSum++;
			if(nSum>=10){
				//λ���
				if(i==0){
					//��λ���
					return false;
				}else{
					//����λ���
					nSum -=10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			}else{
				//û���
				number[i] = (char) ('0'+nSum);
				break;
			}
		}
		return true;
	}
	
	private static void initNumber(char[] number, char c) {
		// TODO Auto-generated method stub
		if(number == null)
			return ;
		for(int i=0;i<number.length ;i++){
			number[i] = c;
		}
	}
	
	/**
	 * 
	 * <p>
	 * ͬʱ������ת��Ϊ�������еĽⷨ��ʹ�õݹ����ʹ���������ˡ�
	 * ������������е�����ǰ�油0�Ļ����ͻᷢ��nλ���е�ʮ��������ʵ����n����0��9��ȫ���С�
	 * Ҳ����˵�����ǰ����ֵ�ÿһλ����0��9����һ�飬�͵õ������е�ʮ���������ڴ�ӡʱ����������ǰ���0����ӡ��
	 * <p>
	 * ȫ���еݹ�ʵ�������ס����ֵ�ÿһλ��������0��9��һ������Ȼ��������һλ���ݹ�������������������Ѿ����������ֵ����һλ��
	 * @param n
	 */
	static void printToMaxOfDigits(int n){
		if(n<=0)
			return ;
		char[] number = new char[n];
		print1ToMaxOfNDigitsRecursively(number,n,0);
	}
	
	static void print1ToMaxOfNDigitsRecursively(char[] number , int length , int index){
		if(index == length){
			printNumber(number);
			return;
		}
		for(int i=0; i<=9 ;i++){
			number[index] = (char) ('0'+i);
			print1ToMaxOfNDigitsRecursively(number, length, index+1);
		}
	}
}

package com.example2.p10_power;

/**
 /**
 * ��ֵ�������η�
 * <p>
 * ʵ�ֺ���double power��double base��int exponent������base��exponent�η�������ʹ�ÿ⺯��������Ҫ���Ǵ������⡣
 * �������ǵĵ�һ�뷨��Զ������ѭ��������ֵ�����Ҫ���ǵ�0�͸��������Խ�ָ���������ֵ��Ȼ����������ȡ������
 * ��ȻҪ���������Ǻ���Ȼ���뵽����û�п��ܶ�0ȡ����
 * ͬʱ��Ҫ˵����0����η���û������ģ�����0����1������
 * �����Ļ� ���ǿ�����Ҫѭ��ָ��-1��
 * <p>
 * ��������ָ����32.��ô��Ҫѭ��31�Σ����ǻ�һ��˼·��
 * ���ǵ�Ŀ������һ�����ֵ�32�η����������֪������16�η�����ôֻҪ��16�η��Ļ�������ƽ���Ϳ�����
 * ��16��8�η���ƽ�����Դ����ƣ���32�η�ֻ��Ҫ��5�γ˷�
 * ��������������ٶ���һ�γ˷�
 * @author ���ٲ�
 *
 */
public class Power {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(pow1(5,-555555555));
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(powerWithExponent(5,-555555555));
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * �ݹ��һ���� ʱ�临�Ӷ�o(2��logn�η�) �ռ临�Ӷ�o(logn)   Ч�ʽϲ�
	 * @param base
	 * @param exponent
	 * @return
	 */
	static double pow1(double base,int exponent){
		if(base == 0)
			return 0;
		if(exponent == 0)
			return 1;
		boolean negativeFlag = exponent < 0 ? true : false;
		if(negativeFlag){
			exponent = - exponent;
		}
		double result ;
		if(exponent % 2 == 0){
			//ż��
			result =  pow1(base,exponent>>1) * pow1(base,exponent>>1);
		}else{
			//����
			result =  pow1(base,(exponent-1)/2) * pow1(base,(exponent-1)/2)*base;
		}
		return negativeFlag ? 1/result : result;
	}
	
	/**
	 * ʱ�临�Ӷ�o(logn) �ռ临�Ӷ�o(logn) 
	 * @param base
	 * @param exponent
	 * @return
	 */
	static double powerWithExponent(double base,int exponent){
		if(base == 0)
			return 0;
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		
		boolean negativeFlag = exponent < 0 ? true : false;
		if(negativeFlag){
			exponent = - exponent;
		}
		
		double result = powerWithExponent(base,exponent>>1);
		result *= result;
		if((exponent & 0x1) == 1){
			result *=base;
		}
		
		return negativeFlag ? 1/result : result;
	}
}

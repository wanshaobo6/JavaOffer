package com.example2.p91_convertSearchTreeToDoubleList;


/**
 * ������36:������������˫������
 * 	   ��Ŀ������һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬
 * 		ֻ�ܵ������н��ָ���ָ�򡣱���������ͼ����ߵĶ����������������ת��֮�������˫������
 *    ˼·:������Ϊ������ ���ڵ�,������,������ �� Ȼ����������е����ڵ㣬���ڵ㣬����������С�ڵ����������������������������������Ľڵ����ӵ�������
 *       ��ԭ�������ʵ����һ���� �� ��˿��Եݹ���
 * @author ���ٲ�
 *
 */
public class ConvertSearchTreeToDoubleList {
	public static void main(String[] args) {
		BinaryTreeNode pRoot = new BinaryTreeNode(10);
		BinaryTreeNode node1 = new BinaryTreeNode(6);
		BinaryTreeNode node2 = new BinaryTreeNode(14);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		BinaryTreeNode node4 = new BinaryTreeNode(8);
		BinaryTreeNode node5 = new BinaryTreeNode(12);
		BinaryTreeNode node6 = new BinaryTreeNode(16);
		pRoot.m_pLeft = node1;
		pRoot.m_nRight = node2;
		pRoot.m_pLeft.m_pLeft = node3;
		pRoot.m_pLeft.m_nRight = node4;
		pRoot.m_nRight.m_pLeft = node5;
		pRoot.m_nRight.m_nRight = node6;
		BinaryTreeNode convert = convert(pRoot);
		System.out.println();
	}
	
	static BinaryTreeNode convert(BinaryTreeNode pTreeNode){
		if(pTreeNode == null)
			return null;
		convertDoubleNode(pTreeNode , null);
		while(pTreeNode.m_pLeft !=null)
			pTreeNode = pTreeNode.m_pLeft;
		return pTreeNode;
			
	}
	/**
	������������ڣ���ôת�����������ݹ���ȥ���ݹ鷵��֮��˵���ҵ�������ĵ�һ���ڵ㣬Ҳ����4�Ǹ��ڵ㣬��4��ǰ��ڵ���Ϊnull����ʱcurrentΪ4�Ǹ��ڵ㣬���ʱ������6��4����������ѱ������ˣ�������Ҫ���ϲ㷵�أ�����֮ǰ��Ҫ��current��ֵ��lastNode��˵��4��������������һ���ڵ����4

	�������Ϸ�����һ�㣬��ʱ��current�Ѿ���6�ˣ���6����ڵ㸳ֵΪ֮ǰ���ص�4���ж�֮ǰ���ص�lastNode�Ƿ�Ϊnull����Ϊ��˵����Ҫ�Ѹ��ڵ��lastNode����������ʵlastNodeΪnull�������ֻ�е�һ���ڵ����֣�������ʱ�򶼲�����֡��������ź���İ���6���������Լ�6�����ˣ����Դ�ʱ��lastNodeΪ6

   

	6��4��˫�����Ӿ�����ˣ�����6�����������ڣ��ֻ�ݹ鵽�ұ�����ȥ������8�����������������ݹ���ȥһ��֮��current����8����ڵ㣬����������Ϊ�գ����Բ�����ߵݹ���ȥ����8����������֮ǰ��lastNode��������������˫�����ӵ�һ�����ӣ�Ȼ������lastNode��Ϊ�գ������ְ�lastNode����������8��������������˫�����ӽ�������ʱlastNodeΪ8

   

	����468�����ź��򣬴�ʱlastNodeΪ8�����ص���һ�㣬Ҳ���Ǹ��ڵ�10�ˣ�����һ��currentΪ10����current����������lastNode�������������lastNode���ڣ���lastNode����������10����һ���Դ˽���˫�����ӡ����˾ͽ����ڵ�������������������ˣ�Ȼ�����ȥת�������������ڵ�lastNodeΪ10��currentΪ14��14�����ӣ�������Ҫ�ݹ鵽��һ�㣬��һ���currentΪ12��12û�����ӣ����Բ��������ݹ飬����12��12�������ת����˫�����������ߵĽڵ㣬��lastNode��12���ӣ�Ҳ����10��12���ӣ���ʱ��lastNode�ͱ����12���ٽ�12���������ݹ飬����û��������������ֱ�ӷ��ص���һ�㣬��һ���current��14,14�����ź����lastNode���ӣ�Ҳ����12��14���ӣ�Ȼ��lastNode��Ϊ14���ݹ鵽14����������Ҳ��current��Ϊ16��16�ٵݹ���������������������16��14���ӣ���ʱ��lastNode��Ϊ16���ݹ����������������������������ݹ鹤�����
	 * @param pTreeNode
	 * @param lastNode
	 * @return
	 */
	
	private static BinaryTreeNode convertDoubleNode(BinaryTreeNode pTreeNode , BinaryTreeNode lastNode) {
		// TODO Auto-generated method stub
		if(pTreeNode.m_pLeft != null){
			lastNode = convertDoubleNode(pTreeNode.m_pLeft , lastNode);
		}
		BinaryTreeNode currNode = pTreeNode;
		currNode.m_pLeft = lastNode;
		if(lastNode != null){
			lastNode.m_nRight = currNode;
		}
		lastNode = currNode;
		if(pTreeNode.m_nRight != null){
			lastNode = convertDoubleNode(pTreeNode.m_nRight , lastNode);
		}
		return lastNode;
	}

	static class BinaryTreeNode{
		int m_nValue;
		BinaryTreeNode m_pLeft;
		BinaryTreeNode m_nRight;

		public BinaryTreeNode(int m_nValue) {
			super();
			this.m_nValue = m_nValue;
		}
		
		
	}
}

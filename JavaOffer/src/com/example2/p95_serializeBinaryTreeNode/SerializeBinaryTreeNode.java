package com.example2.p95_serializeBinaryTreeNode;


/**
 * ������37: ���л�������
 *    ��Ŀ:��ʵ�������������ֱ��������л��ͷ����л�������
 * @author ���ٲ�
 *
 */
public class SerializeBinaryTreeNode {
	
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
		StringBuffer buffer = new StringBuffer();
		serialize(pRoot,buffer);
		System.out.println(buffer.toString());
		BinaryTreeNode Root = deSerialize(buffer.toString().split(","));
		System.out.println();
	}
	/**
	 * �����������л�
	 * @param pTreeNode
	 * @param buffer
	 */
	static void serialize(BinaryTreeNode pTreeNode , StringBuffer buffer){
		if(pTreeNode == null){
			buffer.append("$,");
			return ;
		}
		buffer.append(pTreeNode.m_nValue+",");
		serialize(pTreeNode.m_pLeft , buffer);
		serialize(pTreeNode.m_nRight , buffer);
	}
	
	//��Ϊ��Java���ò��˳���ָ��  ���������ģ��
	private static int index = 0;
	/**
	 * �������ķ����л�
	 * @param array
	 * @param index
	 * @return
	 */
	static BinaryTreeNode deSerialize(String[] array){
		if(index>=array.length|| array[index].equals("$") || array[index].equals(" "))
			return null;
		BinaryTreeNode pRoot = new BinaryTreeNode(Integer.parseInt(array[index]));
		index++;
		pRoot.m_pLeft = deSerialize(array);
		index++;
		pRoot.m_nRight = deSerialize(array);
		return pRoot;
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

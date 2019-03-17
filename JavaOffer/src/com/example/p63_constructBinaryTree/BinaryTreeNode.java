package com.example.p63_constructBinaryTree;
public class BinaryTreeNode{
	private int m_nValue;
	BinaryTreeNode m_pLeft;
	BinaryTreeNode m_pRight;
	
	
	public BinaryTreeNode(int m_nValue) {
		super();
		this.m_nValue = m_nValue;
	}
	
	public int getM_nValue() {
		return m_nValue;
	}
	public void setM_nValue(int m_nValue) {
		this.m_nValue = m_nValue;
	}
	
}
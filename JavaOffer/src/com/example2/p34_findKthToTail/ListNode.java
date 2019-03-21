package com.example2.p34_findKthToTail;

public class ListNode {
	public int m_nValue ;
	public ListNode m_pNext;
	
	public ListNode(int m_nValue) {
		super();
		this.m_nValue = m_nValue;
	}

	@Override
	public String toString() {
		return (String) (m_nValue + " "+ (m_pNext!=null?m_pNext:""));
	}
	
	
}

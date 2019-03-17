package com.example2.p20operationForListNode;

public class ListNode<E> {
	 E m_nValue;
	ListNode<E> m_pNext;
	/**
	 * @param m_nValue
	 */
	public ListNode(E m_nValue) {
		super();
		this.m_nValue = m_nValue;
	}
	@Override
	public String toString() {
		return 	m_nValue + " " + (m_pNext != null ? m_pNext.toString() : "");
	}
	
	
}

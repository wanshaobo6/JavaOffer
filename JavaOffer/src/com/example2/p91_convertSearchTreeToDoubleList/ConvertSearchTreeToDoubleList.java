package com.example2.p91_convertSearchTreeToDoubleList;


/**
 * 面试题36:二叉搜索树和双向链表
 * 	   题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 * 		只能调整树中结点指针的指向。比如输入下图中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *    思路:把树分为三部分 根节点,左子树,右子树 ， 然后吧左子树中的最大节点，根节点，右子树中最小节点连接起来，致于如歌吧左子树和右子树的节点连接到成链表
 *       和原来问题的实质是一样的 ， 因此可以递归解决
 * @author 万少波
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
	如果左子树存在，那么转换左子树，递归下去，递归返回之后，说明找到了链表的第一个节点，也就是4那个节点，将4的前面节点置为null，此时current为4那个节点，这个时候由于6的4这个左子树已遍历完了，所以需要往上层返回，返回之前需要将current赋值给lastNode，说明4这个左子树的最后一个节点就是4

	由于往上返回了一层，此时的current已经是6了，将6的左节点赋值为之前返回的4，判断之前返回的lastNode是否为null，不为空说明需要把根节点和lastNode连起来，其实lastNode为null的情况就只有第一个节点会出现，其他的时候都不会出现。现在已排好序的包括6的左子树以及6本身了，所以此时的lastNode为6

   

	6和4的双向连接就完成了，由于6的右子树存在，又会递归到右边子树去，由于8不存在左右子树，递归下去一层之后current就是8这个节点，但它的左孩子为空，所以不会左边递归下去，将8的左连接与之前的lastNode连接起来，建立双向连接的一条连接，然后由于lastNode不为空，所以又把lastNode的右连接与8连接起来，至此双向连接建立，此时lastNode为8

   

	所以468都已排好序，此时lastNode为8，返回到上一层，也就是根节点10了，在这一层current为10，将current的左连接与lastNode连接起来，如果lastNode存在，将lastNode的右连接与10连接一起，以此建立双向连接。至此就将根节点和左子树都连接起来了，然后就是去转换右子树，现在的lastNode为10，current为14，14有左孩子，所以需要递归到下一层，下一层的current为12，12没有左孩子，所以不用在坐递归，所以12是12这棵子树转换成双向链表的最左边的节点，将lastNode与12连接，也就是10与12连接，此时的lastNode就变成了12，再将12的右子树递归，由于没有右子树，所以直接返回到上一层，上一层的current是14,14与已排好序的lastNode连接，也就是12与14连接，然后lastNode变为14，递归到14的右子树，也就current变为16，16再递归左子树，无左子树，将16与14连接，此时的lastNode变为16，递归右子树，无右子树，所以整个递归工作完成
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

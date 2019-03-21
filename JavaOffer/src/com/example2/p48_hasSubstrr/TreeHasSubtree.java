package com.example2.p48_hasSubstrr;
/**
 *  ������26: �����ӽṹ
 *  	��Ŀ: �������ö�����A��B,�ж�B�ǲ���A���ӽṹ 
 *  
 *   ��A��һ���ڵ���B�ĸ��ڵ�ֵ��ͬʱ������Ҫ��A���Ǹ��ڵ㿪ʼ�ϸ�ƥ�䣬��Ӧ�������tree1HasTree2FromRoot������
 * ���ƥ�䲻�ɹ����򷵻ص���ʼƥ����Ǹ��ڵ㣬�������������������ж��Ƿ���B�ĸ��ڵ�ֵ��ͬ���ظ��������̡�
 * Ӧע�⣬�����ȱȽ�root2�Ľڵ��Ƿ�Ϊ��
 * @author ���ٲ�
 *
 */
public class TreeHasSubtree {
	static class TreeNode<T> {
		T val;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}

	
	static boolean hasSubtree(TreeNode<Integer> pRoot1 , TreeNode<Integer> pRoot2){
		if(pRoot1 == null || pRoot2 == null)
			return false;
		boolean result = false;
		System.out.println(pRoot1.val);
		if(pRoot1.val == pRoot2.val)
			result = tree1HasTree2FromRoot(pRoot1,pRoot2);
		if(result)
			return result; 
		return hasSubtree(pRoot1.left,pRoot2) || hasSubtree(pRoot1.right,pRoot2);
	}
	
	static boolean tree1HasTree2FromRoot(TreeNode<Integer> pRoot1 , TreeNode<Integer> pRoot2){
		if(pRoot2 == null)
			return true;
		if(pRoot1 == null)
			return false;
		if(pRoot1.val == pRoot2.val)
			return tree1HasTree2FromRoot(pRoot1.left,pRoot2.left)&&tree1HasTree2FromRoot(pRoot1.right,pRoot2.right);
		return false;
	}
	
	
	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<Integer>(8);
		root1.left = new TreeNode<Integer>(8);
		root1.right = new TreeNode<Integer>(7);
		root1.left.left = new TreeNode<Integer>(9);
		root1.left.right = new TreeNode<Integer>(2);
		root1.left.right.left = new TreeNode<Integer>(4);
		root1.left.right.right = new TreeNode<Integer>(7);
		TreeNode<Integer> root2 = new TreeNode<Integer>(8);
		root2.left = new TreeNode<Integer>(9);
		root2.right = new TreeNode<Integer>(2);
		TreeNode<Integer> root3 = new TreeNode<Integer>(2);
		root3.left = new TreeNode<Integer>(4);
		root3.right = new TreeNode<Integer>(3);
		System.out.println(hasSubtree(root1, root2));
		System.out.println(hasSubtree(root1, root3));
	}
}

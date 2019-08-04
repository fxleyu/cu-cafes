package fx.leyu.algorithm;

import java.util.Stack;
public class BiTree {
	private BiTree leftTree;// ������
	private BiTree rightTree;// ������
	private Object data;// �ڵ�����
	private boolean flag = false;
	public final static int MAX = 40;
	BiTree[] elements = new BiTree[MAX];// ��α���ʱ��������ڵ�
	int front;// ��α���ʱ����
	int rear;// ��α���ʱ��β
	// ���캯��
	public BiTree() {
		// TODO Auto-generated constructor stub
	}
	public BiTree(Object data) {
		this.data = data;
	}
	public BiTree(Object data, BiTree lefTree, BiTree righTree) {
		this.data = data;
		this.leftTree = lefTree;
		this.rightTree = righTree;
	}
	// �ݹ�ǰ�����������
	public void preOrder(BiTree tree) {
		if (tree != null) {
			visit(tree);
			preOrder(tree.leftTree);
			preOrder(tree.rightTree);
		}
	}
	
	// �ݹ��������������
	public void inOrder(BiTree tree) {
		if (tree != null) {
			inOrder(tree.leftTree);
			visit(tree);
			inOrder(tree.rightTree);
		}
	}
	
	// �ݹ�������������
	public void postOrder(BiTree tree) {
		if (tree != null) {
			postOrder(tree.leftTree);
			postOrder(tree.rightTree);
			visit(tree);
		}
	}
	
	// �ǵݹ�ʵ��ǰ�����
	public void iterativePreOrder(BiTree tree) {
		Stack<BiTree> stack = new Stack<BiTree>();
		if (tree != null) {
			stack.push(tree);
			while (!stack.isEmpty()) {
				tree = stack.pop();
				visit(tree);
				if (tree.rightTree != null)
					stack.push(tree.rightTree);
				if (tree.leftTree != null)
					stack.push(tree.leftTree);
			}
		}
	}
	
	// �ǵݹ�ʵ���������
	public void iterativeInOrder(BiTree tree) {
		
		Stack<BiTree> stack = new Stack<BiTree>();
		while (tree != null) {
			while (tree != null) {
				if (tree.rightTree != null)
					stack.push(tree.rightTree);// ��ǰ�ڵ�������ջ
				stack.push(tree);// ��ǰ�ڵ���ջ
				tree = tree.leftTree;
			}
			tree = stack.pop();
			while (!stack.empty() && tree.rightTree == null) {
				visit(tree);
				tree = stack.pop();
			}
			visit(tree);
			if (!stack.empty())
				tree = stack.pop();
			else
				tree = null;
		}
		
		
	}
	
	// �ǵݹ�ʵ�ֺ������
	public void iterativePostOrder(BiTree tree) {
		
		if(tree == null){
    		System.out.println("��");
    	}
    	
    	Stack<BiTree> stack = new Stack<BiTree>();
    	stack.push(tree);
    	BiTree pre = null;
    	
    	while(!stack.isEmpty())
    	{
    		BiTree cur = stack.peek();
    		if(pre == null)
    		{
    			if(cur.leftTree!=null){
    				stack.push(cur.leftTree);
    			} else if(cur.rightTree != null){
    				stack.push(cur.rightTree);
    			} else {
    				pre = stack.pop();
    				visit(pre);
    			}
    		} 
    		else 
    		{
    			if(cur.leftTree == pre && cur.rightTree != null)
    			{
    				stack.push(cur.rightTree);
    				pre = null;
    			}
    			else 
    			{
    				pre = stack.pop();
    				visit(pre);
    			}
    		}
    	}
    
		
		/*BiTree tempTree = tree;
		Stack<BiTree> stack = new Stack<BiTree>();
		while (tree != null) {
			// ��������ջ
			while(tree.leftTree != null)
			{
				stack.push(tree);
				tree = tree.leftTree;
			}
			
				
			// ��ǰ�ڵ������ӻ������Ѿ����
			while (tree != null
					&& (tree.rightTree == null || tree.rightTree == tempTree)) {
				visit(tree.data);
				tempTree = tree;// ��¼��һ��������ڵ�
				if (stack.empty())
					return;
				tree = stack.pop();
			}
			// ��������
			stack.push(tree);
			tree = tree.rightTree;
		}*/
	}
	// ��α���������
	public void LayerOrder(BiTree tree) {
		elements[0] = tree;
		front = 0;
		rear = 1;
		while (front < rear) {
			try {
				if (elements[front].data != null) {
					System.out.print(elements[front].data + " ");
					if (elements[front].leftTree != null)
						elements[rear++] = elements[front].leftTree;
					if (elements[front].rightTree != null)
						elements[rear++] = elements[front].rightTree;
					front++;
				}
			} catch (Exception e) {
				break;
			}
		}
	}
	// ��������ĸ߶�
	public static int height(BiTree tree) {
		if (tree == null)
			return 0;
		else {
			int leftTreeHeight = height(tree.leftTree);
			int rightTreeHeight = height(tree.rightTree);
			return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1
					: rightTreeHeight + 1;
		}
	}
	// ��data����Ӧ���Ĳ������������������,�������-1;���������ظö��������������Ĳ��,�涨���ڵ�Ϊ��һ��
	public int level(Object data) {
		int leftLevel, rightLevel;
		if (this == null)
			return -1;
		if (data == this.data)
			return 1;
		leftLevel = leftTree == null ? -1 : leftTree.level(data);
		rightLevel = rightTree == null ? -1 : rightTree.level(data);
		if (leftLevel < 0 && rightLevel < 0)
			return -1;
		return leftLevel > rightLevel ? leftLevel + 1 : rightLevel + 1;
	}
	// ��������Ľ������
	public static int nodes(BiTree tree) {
		if (tree == null)
			return 0;
		else {
			int left = nodes(tree.leftTree);
			int right = nodes(tree.rightTree);
			return left + right + 1;
		}
	}
	// �������Ҷ�ӽڵ������
	public static int leaf(BiTree tree) {
		if (tree == null)
			return 0;
		else {
			int left = leaf(tree.leftTree);
			int right = leaf(tree.rightTree);
			if (tree.leftTree == null && tree.rightTree == null)
				return left + right + 1;
			else
				return left + right;
		}
	}
	// ����������ڵ����
	public static int fatherNodes(BiTree tree) {
		if (tree == null || (tree.leftTree == null && tree.rightTree == null))
			return 0;
		else {
			int left = fatherNodes(tree.leftTree);
			int right = fatherNodes(tree.rightTree);
			return left + right + 1;
		}
	}
	// ��ֻ��һ�����ӽ��ĸ��ڵ����
	public static int oneChildFather(BiTree tree) {
		int left, right;
		if (tree == null || (tree.rightTree == null && tree.leftTree == null))
			return 0;
		else {
			left = oneChildFather(tree.leftTree);
			right = oneChildFather(tree.rightTree);
			if ((tree.leftTree != null && tree.rightTree == null)
					|| (tree.leftTree == null && tree.rightTree != null))
				return left + right + 1;
			else
				return left + right;/* ��1����ΪҪ���ϸ��ڵ� */
		}
	}
	// �������ֻӵ�����ӵĸ��ڵ�����
	public static int leftChildFather(BiTree tree) {
		if (tree == null)
			return 0;
		else {
			int left = leftChildFather(tree.leftTree);
			int right = leftChildFather(tree.rightTree);
			if ((tree.leftTree != null && tree.rightTree == null))
				return left + right + 1;
			else
				return left + right;
		}
	}
	// �������ֻӵ���Һ��ӵĽ������
	public static int rightChildFather(BiTree tree) {
		if (tree == null || tree.rightTree == null)
			return 0;
		else {
			int left = rightChildFather(tree.leftTree);
			int right = rightChildFather(tree.rightTree);
			if (tree.leftTree == null && tree.rightTree != null)
				return left + right + 1;
			else
				return left + right;
		}
	}
	// �����������ڵ�ĸ��ڵ�ĸ���
	public static int doubleChildFather(BiTree tree) {
		int left, right;
		if (tree == null)
			return 0;
		else {
			left = doubleChildFather(tree.leftTree);
			right = doubleChildFather(tree.rightTree);
			if (tree.leftTree != null && tree.rightTree != null)
				return (left + right + 1);/* ��1����ΪҪ���ϸ��ڵ� */
			else
				return (left + right);
		}
	}
	// ���ʸ��ڵ�
	public void visit(BiTree tree) {
		
		System.out.print(tree.data + " ");
	}
	// �����е�ÿ���ڵ�ĺ��ӶԻ�λ��
	public void exChange() {
		if (this == null)
			return;
		if (leftTree != null)
			leftTree.exChange();
		if (rightTree != null)
			rightTree.exChange();
		BiTree temp = leftTree;
		leftTree = rightTree;
		rightTree = temp;
	}
	//�ݹ������н��ĺ�
	public  static int getSumByRecursion(BiTree tree){
		if(tree==null){
			return 0;
		}
		else{
			int left=getSumByRecursion(tree.leftTree);
			int right=getSumByRecursion(tree.rightTree);
			return Integer.parseInt(tree.data.toString())+left+right;
		}
		
	}
	//�ǵݹ�������������н��ĺ�
	public static int getSumByNoRecursion(BiTree tree){
		Stack<BiTree> stack = new Stack<BiTree>();
		int sum=0;
		if(tree!=null){
			stack.push(tree);
			while(!stack.isEmpty()){
				tree=stack.pop();
				sum+=Integer.parseInt(tree.data.toString());
				if(tree.leftTree!=null)
				    stack.push(tree.leftTree);
				if(tree.rightTree!=null)
					stack.push(tree.rightTree);
			}
			
		}
		return sum;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiTree tree = createTree();
		
		
		
//		System.out.println("�ݹ�ǰ��������������: ");
//		//tree.preOrder(tree);
//		System.out.println();
//		System.out.println("�ǵݹ�ǰ��������������: ");
//		tree.iterativePreOrder(tree);
//		System.out.println();
//		System.out.println("�ݹ���������������Ľ��Ϊ:");
//		tree.inOrder(tree);
//		System.out.println();
//		System.out.println("�ǵݹ���������������Ľ��Ϊ:");
//		tree.iterativeInOrder(tree);
//		System.out.println();
		System.out.println("�ݹ��������������Ľ��Ϊ:");
		tree.postOrder(tree);
		System.out.println();
		System.out.println("�ǵݹ��������������Ľ��Ϊ:");
		tree.iterativePostOrder(tree);
		System.out.println();
		System.out.println("��α������������: ");
		tree.LayerOrder(tree);
		System.out.println();
		System.out.println("�ݹ�������������н��ĺ�Ϊ:"+getSumByRecursion(tree));
		System.out.println("�ǵݹ�������������н��ĺ�Ϊ:"+getSumByNoRecursion(tree));
		
		System.out.println("��������,ÿ���ڵ����ڵĲ���Ϊ:");
		for (int p = 1; p <= 14; p++)
			System.out.println(p + "���ڵĲ�Ϊ:" + tree.level(p));
		System.out.println("�������ĸ߶�Ϊ:" + height(tree));
		System.out.println("�������нڵ�����Ϊ:" + nodes(tree));
		System.out.println("��������Ҷ�ӽڵ�����Ϊ:" + leaf(tree));
		System.out.println("�������и��ڵ�����Ϊ:" + fatherNodes(tree));
		System.out.println("��������ֻӵ��һ�����ӵĸ��ڵ���:" + oneChildFather(tree));
		System.out.println("��������ֻӵ�����ӵĸ��ڵ�����:" + leftChildFather(tree));
		System.out.println("��������ֻӵ���Һ��ӵĸ��ڵ�����:" + rightChildFather(tree));
		System.out.println("��������ͬʱӵ���������ӵĸ��ڵ����Ϊ:" + doubleChildFather(tree));
		System.out.println("--------------------------------------");
		tree.exChange();
		System.out.println("����ÿ���ڵ�����Һ��ӽڵ��......");
		System.out.println("�ݹ�ǰ��������������: ");
		tree.preOrder(tree);
		System.out.println();
		System.out.println("�ǵݹ�ǰ��������������: ");
		tree.iterativePreOrder(tree);
		System.out.println();
		System.out.println("�ݹ���������������Ľ��Ϊ:");
		tree.inOrder(tree);
		System.out.println();
		System.out.println("�ǵݹ���������������Ľ��Ϊ:");
		tree.iterativeInOrder(tree);
		System.out.println();
		System.out.println("�ݹ��������������Ľ��Ϊ:");
		tree.postOrder(tree);
		System.out.println();
		System.out.println("�ǵݹ��������������Ľ��Ϊ:");
		tree.iterativePostOrder(tree);
		System.out.println();
		System.out.println("��α������������: ");
		tree.LayerOrder(tree);
		System.out.println();
        
		System.out.println("�ݹ�������������н��ĺ�Ϊ:"+getSumByRecursion(tree));
		System.out.println("�ǵݹ�������������н��ĺ�Ϊ:"+getSumByNoRecursion(tree));
		
		System.out.println("��������,ÿ���ڵ����ڵĲ���Ϊ:");
		for (int p = 1; p <= 14; p++)
			System.out.println(p + "���ڵĲ�Ϊ:" + tree.level(p));
		System.out.println("�������ĸ߶�Ϊ:" + height(tree));
		System.out.println("�������нڵ�����Ϊ:" + nodes(tree));
		System.out.println("��������Ҷ�ӽڵ�����Ϊ:" + leaf(tree));
		System.out.println("�������и��ڵ�����Ϊ:" + fatherNodes(tree));
		System.out.println("��������ֻӵ��һ�����ӵĸ��ڵ���:" + oneChildFather(tree));
		System.out.println("��������ֻӵ�����ӵĸ��ڵ�����:" + leftChildFather(tree));
		System.out.println("��������ֻӵ���Һ��ӵĸ��ڵ�����:" + rightChildFather(tree));
		System.out.println("��������ͬʱӵ���������ӵĸ��ڵ����Ϊ:" + doubleChildFather(tree));
		
		
	}
	private static BiTree createTree() {
		// TODO Auto-generated method stub
		BiTree e = new BiTree(5);
		BiTree g = new BiTree(7);
		BiTree h = new BiTree(8);
		BiTree l = new BiTree(12);
		BiTree m = new BiTree(13);
		BiTree n = new BiTree(14);
		BiTree k = new BiTree(11, n, null);
		BiTree j = new BiTree(10, l, m);
		BiTree i = new BiTree(9, j, k);
		BiTree d = new BiTree(4, null, g);
		BiTree f = new BiTree(6, h, i);
		BiTree b = new BiTree(2, d, e);
		BiTree c = new BiTree(3, f, null);
		BiTree tree = new BiTree(1, b, c);
		
		return tree;
	}
}
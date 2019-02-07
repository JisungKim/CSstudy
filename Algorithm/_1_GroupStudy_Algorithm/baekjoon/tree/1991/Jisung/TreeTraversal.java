import java.util.Scanner;

public class TreeTraversal {
	private static final int TRAVERSE_PREORDER 		= 0;
	private static final int TRAVERSE_INORDER 		= 1;
	private static final int TRAVERSE_POSTORDER 	= 2;

	public static void traverse(Node tree, int type)
	{
		if(tree == null)
			return;

		switch(type)
		{
		case TRAVERSE_PREORDER:
			System.out.print(tree.getData());
			traverse(tree.getLeft(), type);
			traverse(tree.getRight(), type);
			break;
		case TRAVERSE_INORDER:
			traverse(tree.getLeft(), type);
			System.out.print(tree.getData());
			traverse(tree.getRight(), type);
			break;
		case TRAVERSE_POSTORDER:
			traverse(tree.getLeft(), type);
			traverse(tree.getRight(), type);
			System.out.print(tree.getData());
			break;
		}
	}

	public static Node findNode(Node tree, char data)
	{
		Node cursor = tree;
	
		if(cursor == null)
			return null;

		if(cursor.getData() == data) {
			return tree;
		} else {
			cursor = findNode(tree.getLeft(), data);
			if(cursor == null)
				cursor = findNode(tree.getRight(), data);
		}

		return cursor;
	}

	public static void buildTree(Node tree, String[] parse) {
		Node cursor = tree;

		cursor = findNode(tree, parse[0].charAt(0));

		if(cursor == null)
			return;

		if(!parse[1].equals(".")) {
			cursor.setLeft(new Node(parse[1].charAt(0)));
		}
		if(!parse[2].equals(".")) {
			cursor.setRight(new Node(parse[2].charAt(0)));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numNodes = scan.nextInt();
		String strParse;
		String[] strParseResult;
		Node tree = new Node('A');
		int i = 0;

		scan.nextLine();

		while(i++<numNodes)
		{
			strParse = scan.nextLine();
			strParseResult = strParse.split(" ");
			buildTree(tree, strParseResult);
		}

		traverse(tree, TRAVERSE_PREORDER);
		System.out.print("\n");
		traverse(tree, TRAVERSE_INORDER);
		System.out.print("\n");
		traverse(tree, TRAVERSE_POSTORDER);
	}
}

class Node {
	private final int IS_EMPTY = 0;
	private char data = IS_EMPTY;
	private Node left = null;
	private Node right = null;

	public Node(char data)
	{
		this.data = data;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}

	public void setRight(Node right)
	{
		this.right = right;
	}

	public Node getLeft()
	{
		return left;
	}

	public Node getRight()
	{
		return right;
	}

	public boolean isEmpty() {
		if(data == IS_EMPTY) {
			return true;
		} else {
			return false;
		}
	}

	public char getData() {
		if(!isEmpty())
			return data;
		return IS_EMPTY;
	}

	public void setData(char data) {
		this.data = data;
	}
}

import java.util.Scanner;

public class myStackArray {

	private static final int ARRAY_SIZE 	= 10000;
	private static final int ARRAY_BOTTOM 	= -1;
	private static int[] Stack = new int[ARRAY_SIZE];
	private static int top = -1;

	public static void push(int val)
	{
		Stack[++top] = val;
	}

	public static int pop()
	{
		if(empty())
			return Stack[top--];
		else
			return ARRAY_BOTTOM;
	}

	public static int top()
	{
		if(empty())
			return Stack[top];
		else
			return ARRAY_BOTTOM;
	}

	public static int size()
	{
		return top+1;
	}

	public static boolean empty()
	{
		if(top>-1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCommand = scan.nextInt();
		String strCommand;
		String strCommandSplit[];
		String strOrder;
		int param;

		for(int i=0;i<=numCommand;i++) {
			strCommand = "";
			strOrder = "";
			param = -1;

			strCommand = scan.nextLine();
			strCommandSplit = strCommand.split(" ");
			strOrder = strCommandSplit[0];
			
			if(strOrder.equals("push")) {
				param = Integer.parseInt(strCommandSplit[1]);
				push(param);
			} else if(strOrder.equals("pop")) {
				System.out.println(pop());
			} else if(strOrder.equals("top")) {
				System.out.println(top());
			} else if(strOrder.equals("empty")) {
				if(empty())
					System.out.println("0");
				else
					System.out.println("1");
			} else if(strOrder.equals("size")) {
				System.out.println(size());
			}

		}
	}
}

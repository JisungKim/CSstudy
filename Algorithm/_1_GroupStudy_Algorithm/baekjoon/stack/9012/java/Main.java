import java.util.Scanner;

public class Main {

	private static final int ARRAY_SIZE 	= 50;
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
		int parLength = 0;
		scan.nextLine();
		String strCommand;
		int ret=0;

		for(int i=0;i<numCommand;i++) {
			strCommand = "";
			parLength = 0;
			strCommand = scan.nextLine();

			while(parLength < strCommand.length())
			{
				if(strCommand.charAt(parLength) == '(')
				{
					push('(');
				} else if(strCommand.charAt(parLength) == ')') {
					ret = pop();
					if(ret == ARRAY_BOTTOM)
					{
						break;
					}
				}

				parLength++;
			}

			if(size()==0 && ret != ARRAY_BOTTOM)
			{
				System.out.println("YES");
			} else {
				System.out.println("NO");
				top = -1;
			}
		}
	}
}

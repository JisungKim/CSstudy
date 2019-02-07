import java.util.Scanner;

public class myStackArrayCompact {
	private static int[] Stack;
	private static int top 					= -1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCommand = scan.nextInt();
		String strCommand;
		Stack = new int[numCommand];

		for(int i=0;i<numCommand;i++) {
			strCommand = scan.next();

			if(strCommand.equals("push")) {
				Stack[++top] = Integer.parseInt(scan.next());
			} else if(strCommand.equals("pop")) {
				if(top>-1)
					System.out.println(Stack[top--]);
				else
					System.out.println("-1");
			} else if(strCommand.equals("top")) {
				if(top>-1)
					System.out.println(Stack[top]);
				else
					System.out.println("-1");
			} else if(strCommand.equals("empty")) {
				if(top>-1)
					System.out.println("0");
				else
					System.out.println("1");
			} else if(strCommand.equals("size")) {
				System.out.println(top+1);
			}
		
		}
	}
}

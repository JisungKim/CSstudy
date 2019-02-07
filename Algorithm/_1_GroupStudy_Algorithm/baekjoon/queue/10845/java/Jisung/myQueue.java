import java.util.Scanner;

public class myQueue {

	private final int ARRAY_SIZE 	= 10000;
	private final int ARRAY_EMPTY 	= -1;
	private int[] Stack 			= new int[ARRAY_SIZE];
	private int HEAD 				= 0;
	private int TAIL 				= 0;

	private void push(int val) {
		Stack[HEAD++] = val;
	}

	private int pop() {
		if(!empty())
			return Stack[TAIL++];
		else
			return ARRAY_EMPTY;
	}

	private int size() {
		return HEAD - TAIL;
	}

	private boolean empty() {
		if(size() > 0)
			return false;
		else
			return true;
	}

	private int front() {
		if(!empty())
			return Stack[TAIL];
		else
			return ARRAY_EMPTY;
	}

	private int back() {
		if(!empty())
			return Stack[HEAD-1];
		else
			return ARRAY_EMPTY;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCommand = scan.nextInt();
		String strCommand;
		String strCommandSplit[];
		String strOrder;
		myQueue myQ = new myQueue();
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
				myQ.push(param);
			} else if(strOrder.equals("pop")) {
				System.out.println(myQ.pop());
			} else if(strOrder.equals("size")) {
				System.out.println(myQ.size());
			} else if(strOrder.equals("empty")) {
				if(myQ.empty())
					System.out.println("1");
				else
					System.out.println("0");
			} else if(strOrder.equals("front")) {
				System.out.println(myQ.front());
			} else if(strOrder.equals("back")) {
				System.out.println(myQ.back());
			}

		}
	}
}

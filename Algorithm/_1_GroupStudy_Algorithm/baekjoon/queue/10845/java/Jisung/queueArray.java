import java.util.Scanner;

public class queueArray extends queue {

	private final int ARRAY_SIZE 	= 10000;
	private final int ARRAY_EMPTY 	= -1;
	private int[] Stack 			= new int[ARRAY_SIZE];
	private int HEAD 				= 0;
	private int TAIL 				= 0;

	public void push(int val) {
		Stack[HEAD++] = val;
		print();
	}

	public int pop() {
		if(!empty())
			return Stack[TAIL++];
		else
			return ARRAY_EMPTY;
	}

	public int size() {
		return HEAD - TAIL;
	}

	public boolean empty() {
		if(size() > 0)
			return false;
		else
			return true;
	}

	public int front() {
		if(!empty())
			return Stack[HEAD-1];
		else
			return ARRAY_EMPTY;
	}

	public int back() {
		if(!empty())
			return Stack[TAIL];
		else
			return ARRAY_EMPTY;
	}
}

import java.util.Scanner;

public class javaPractice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCommand = scan.nextInt();
		String strCommand;
		String strCommandSplit[];
		String strOrder;
		queueArray myQ = new queueArray();
		int param;
		myQ.print();
		queue test = new queue();
		test.print();
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

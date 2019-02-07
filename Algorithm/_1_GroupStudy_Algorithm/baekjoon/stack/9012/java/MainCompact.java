import java.util.Scanner;

public class MainCompact {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCommand = scan.nextInt();
		int stack = 0;
		int parLength=0;
		scan.nextLine();
		String strCommand;

		for(int i=0;i<numCommand;i++) {
			strCommand = "";
			parLength = 0;
			strCommand = scan.nextLine();

			while(parLength < strCommand.length())
			{
				if(strCommand.charAt(parLength) == '(')
				{
					stack++;
				} else if(strCommand.charAt(parLength) == ')') {
					if(--stack < 0)
					{
						break;
					}
				}

				parLength++;
			}

			if(stack == 0)
			{
				System.out.println("YES");
			} else {
				System.out.println("NO");
				stack = 0;
			}
		}
	}
}

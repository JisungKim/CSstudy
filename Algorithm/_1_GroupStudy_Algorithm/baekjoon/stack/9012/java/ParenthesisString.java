import java.util.Scanner;
import java.util.Stack;

class ParenthesisString{

    public static void main(String[] args) {
        ParenthesisString pString = new ParenthesisString();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] result = new String[n];
        int i = 0;
        while(i < n) {
            String input = sc.nextLine();
            //vps 검증
            result[i] = pString.vps(input);
            i++;
        }
        //정답 출력
        i = 0;
        while(i < n) {
            System.out.println(result[i]);
            i++;
        }
    }

    public String vps(String input) {
        Stack<String> stack = new Stack<>();
        String[] arrStr = input.split("");
        int i = 0;
        while(true) {
            if (i < arrStr.length) {
                if (arrStr[i].equals("(")) {
                    stack.push(arrStr[i]);
                } else if (arrStr[i].equals(")")) {
                    if(stack.isEmpty())    
                        return "NO";     
                    stack.pop();       
                }
             } else {
                if(stack.isEmpty())
                    return "YES";
                else
                    return "NO";  
            }
            i++;           
        }
    }

}
 
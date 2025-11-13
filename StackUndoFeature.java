import java.util.*;
public class StackUndoFeature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        while (true) {
            String cmd = sc.next();
            if (cmd.equals("add")) stack.push(sc.next());
            else if (cmd.equals("undo") && !stack.isEmpty()) stack.pop();
            else if (cmd.equals("show")) System.out.println(stack);
            else if (cmd.equals("exit")) break;
        }
    }
}

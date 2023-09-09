import java.util.Objects;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PseudoCode-Interpreter");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("See our documentation to know how the interpreter works");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Use one of our commands and let's code!!");
        System.out.println("---------------------------------------------------------------------");

        Map<String, String> constants = new HashMap<>();

        while (true) {
            System.out.print("Type the Command:");
            String command = scanner.next();

            if (Objects.equals(command, "write")) {
                System.out.print("Print:");
                String print = scanner.next();
                System.out.println(print);
            } else if (Objects.equals(command, "const")) {
                System.out.print("Name:");
                String constName = scanner.next();
                System.out.print("Value:");
                String constValue = scanner.next();

                constants.put(constName, constValue);
                System.out.println("Constant created: " + constName + " = " + constValue);
            } else if (constants.containsKey(command)) {
                String constValue = constants.get(command);
                System.out.println("Value of " + command + " is " + constValue);
            } else if (Objects.equals(command, "add")) {
                System.out.print("Const(1):");
                String const1 = scanner.next();
                System.out.print("Const(2):");
                String const2 = scanner.next();


                if (constants.containsKey(const1) && constants.containsKey(const2)) {
                    int result = Integer.parseInt(constants.get(const1)) + Integer.parseInt(constants.get(const2));
                    System.out.println("Result: " + result);
                    System.out.print("Const Result Name:");

                    String constName = scanner.next();

                    constants.put(constName, String.valueOf(result));
                } else {
                    System.out.println("Invalid constants.");
                }
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}


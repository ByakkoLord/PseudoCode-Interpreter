import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PseudoCode-Interpreter");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("See our documentation to know how the interpreter works");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Use one of our commands and let's code!!");
        System.out.println("---------------------------------------------------------------------");

        Map<String, String> constants = new HashMap<>();
        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter("./src/pseudocode.txt", true);
            bufferedWriter = new BufferedWriter(fileWriter);

            while (true) {
                System.out.print("Type the Command:");
                String command = scanner.next();

                bufferedWriter.write(command);
                bufferedWriter.newLine();

                if (Objects.equals(command, "write")) {
                    System.out.print("Print:");
                    String print = scanner.next();
                    System.out.println(print);

                    bufferedWriter.write(print);
                    bufferedWriter.newLine();

                } else if (Objects.equals(command, "const")) {
                    System.out.print("Name:");
                    String constName = scanner.next();
                    System.out.print("Value:");
                    String constValue = scanner.next();

                    constants.put(constName, constValue);
                    System.out.println("Constant created: " + constName + " = " + constValue);

                    bufferedWriter.write(constName);
                    bufferedWriter.newLine();
                    bufferedWriter.write(constValue);
                    bufferedWriter.newLine();
                } else if (constants.containsKey(command)) {
                    String constValue = constants.get(command);
                    System.out.println("Value of " + command + " is " + constValue);

                    bufferedWriter.write(constValue);
                    bufferedWriter.newLine();
                }else if (Objects.equals(command, "sub")) {
                    System.out.print("Const(1):");
                    String const1 = scanner.next();
                    System.out.print("Const(2):");
                    String const2 = scanner.next();

                    bufferedWriter.write(const1);
                    bufferedWriter.newLine();
                    bufferedWriter.write(const2);
                    bufferedWriter.newLine();
                    if (constants.containsKey(const1) && constants.containsKey(const2)) {
                        int result = Integer.parseInt(constants.get(const1)) - Integer.parseInt(constants.get(const2));
                        System.out.println("Result: " + result);
                        System.out.print("Const Result Name:");

                        String constName = scanner.next();


                        constants.put(constName, String.valueOf(result));

                        bufferedWriter.write(constName);
                        bufferedWriter.newLine();
                        bufferedWriter.write(result);
                        bufferedWriter.newLine();
                    }} else if (Objects.equals(command, "add")) {
                    System.out.print("Const(1):");
                    String const7 = scanner.next();
                    System.out.print("Const(2):");
                    String const8 = scanner.next();

                    bufferedWriter.write(const7);
                    bufferedWriter.newLine();
                    bufferedWriter.write(const8);
                    bufferedWriter.newLine();
                    if (constants.containsKey(const7) && constants.containsKey(const8)) {
                        int result = Integer.parseInt(constants.get(const7)) + Integer.parseInt(constants.get(const8));
                        System.out.println("Result: " + result);
                        System.out.print("Const Result Name:");

                        String constName = scanner.next();

                        constants.put(constName, String.valueOf(result));
                        bufferedWriter.write(constName);
                        bufferedWriter.newLine();
                        bufferedWriter.write(result);
                        bufferedWriter.newLine();
                    } else {
                        System.out.println("Invalid constants.");
                    }
                }else if (Objects.equals(command, "div")) {
                    System.out.print("Const(1):");
                    String const3 = scanner.next();
                    System.out.print("Const(2):");
                    String const4 = scanner.next();

                    bufferedWriter.write(const3);
                    bufferedWriter.newLine();
                    bufferedWriter.write(const4);
                    bufferedWriter.newLine();

                    if (constants.containsKey(const3) && constants.containsKey(const4)) {
                        int result = Integer.parseInt(constants.get(const3)) / Integer.parseInt(constants.get(const4));
                        System.out.println("Result: " + result);
                        System.out.print("Const Result Name:");

                        String constName = scanner.next();

                        constants.put(constName, String.valueOf(result));

                        bufferedWriter.write(constName);
                        bufferedWriter.newLine();
                        bufferedWriter.write(result);
                        bufferedWriter.newLine();

                    }}

                else if (Objects.equals(command, "multi")) {
                    System.out.print("Const(1):");
                    String const5 = scanner.next();
                    System.out.print("Const(2):");
                    String const6 = scanner.next();

                    bufferedWriter.write(const5);
                    bufferedWriter.newLine();
                    bufferedWriter.write(const6);
                    bufferedWriter.newLine();

                    if (constants.containsKey(const5) && constants.containsKey(const6)) {
                        int result = Integer.parseInt(constants.get(const5)) * Integer.parseInt(constants.get(const6));
                        System.out.println("Result: " + result);
                        System.out.print("Const Result Name:");

                        String constName = scanner.next();

                        constants.put(constName, String.valueOf(result));

                        bufferedWriter.write(constName);
                        bufferedWriter.newLine();
                        bufferedWriter.write(result);
                        bufferedWriter.newLine();

                    }

                } else if (Objects.equals(command, "if")) {
                    System.out.println("What constants you are use?:");
                    System.out.print("const(1)");
                    String const1 = scanner.next();

                    System.out.print("const(2)");
                    String const2 = scanner.next();


                    System.out.println("What kind of validation you want:");
                    System.out.println("True (T)");
                    System.out.println("False (F)");
                    System.out.println("Equality (E)");
                    System.out.println("Different (D)");
                    System.out.println("Bigger than (B)");
                    System.out.println("Lower than (L)");
                    String ifChoice = scanner.next();

                    String ifChoiceLower = ifChoice.toLowerCase();

                    bufferedWriter.write(const1);
                    bufferedWriter.newLine();
                    bufferedWriter.write(const2);
                    bufferedWriter.newLine();
                    bufferedWriter.write(ifChoiceLower);
                    bufferedWriter.newLine();




                    switch (ifChoiceLower){
                        case "e":
                            if(constants.containsKey(const1) == constants.containsKey(const2)){
                                System.out.println("The constants are equal!");
                            }


                    }

                } else {
                    System.out.println("Unknown command.");
                    System.out.println("Closing the Program...");
                    break;

                }
            }} catch (Exception e) {
                e.printStackTrace();
            } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
    }
}


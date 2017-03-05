package ex06;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        boolean fin = false;
        try (Scanner sc = new Scanner(System.in);) { // Try-With-Resources

            do {
                System.out.println("Enter one of the following:");
                System.out.println("\t1 - Inside a try block and checked");
                System.out.println("\t2 - Inside a try block and unchecked");
                System.out.println("\t3 - Outside a try block and checked");
                System.out.println("\t4 - Outside a try block and unchecked");
                System.out.println("\t5 - exit");
                try {
                    switch (sc.nextInt()) {
                        case 1:
                            methodA("Inside a try block and checked");
                            break;
                        case 2:
                            methodB("Inside a try block and unchecked");
                            break;
                        case 3:
                            methodC("Outside a try block and checked");
                            break;
                        case 4:
                            methodD("Outside a try block and unchecked");
                            break;
                        case 5:
                            System.out.println("Bye!");
                            fin = true;
                            break;
                        default:
                            System.out.println("Oops - not one of the options");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } while (!fin);

        } catch (Exception ex) {
            System.out.println("Scanner error " + ex);
        }

    }

    static void methodA(String s) throws Checked {
        try {
            throw new Checked(s);
        } catch (Checked ex) {
            System.out.println(ex);
        }
    }

    static void methodB(String s) {
        try {
            throw new UnChecked(s);
        } catch (UnChecked ex) {
            System.out.println(ex);
        }
    }

    static void methodC(String s) throws Checked {
        throw new Checked(s);
    }

    static void methodD(String s) {
        throw new UnChecked(s);
    }

}

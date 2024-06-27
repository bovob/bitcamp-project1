package bitcamp.project1.App1.util;

import java.util.Scanner;

public class Prompt {

    static Scanner keyboardScanner = new Scanner(System.in);

    public static String input(String format, Object... args) {
        System.out.printf(format + " ", args);
        return keyboardScanner.nextLine();
    }

    public static int inputInt(String format, Object... args) {
        return Integer.parseInt(input(format, args));
    }

    public static void close() {
        keyboardScanner.close();
    }

}





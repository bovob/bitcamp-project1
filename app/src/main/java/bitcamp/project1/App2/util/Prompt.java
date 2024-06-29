package bitcamp.project1.App2.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  static Date date = null;

  static Scanner keyboardScanner = new Scanner(System.in);

  public static String input(String format, Object... args) {
    System.out.printf(format + " ", args);
    return keyboardScanner.nextLine().trim();
  }

  public static int inputInt(String format, Object... args) {
    return Integer.parseInt(input(format, args));
  }

  public static Date inputDate(String format, Object... args) {
    while (true) {
      try {
        String input = input(format, args);
        if (input.matches("\\d{4}-\\d{2}")) {
          return Date.valueOf(input + "-01");
        } else {
          return Date.valueOf(input);
        }
      } catch (IllegalArgumentException e) {
        System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM 혹은 yyyy-MM-dd 형식으로 입력해주세요.");
      }
    }

  }

  public static void close() {
    keyboardScanner.close();
  }
}

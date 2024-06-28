package bitcamp.project1.App2.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

  public static java.util.Date inputDate(String format, Object... args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    while (true) {
      try {
        String input = input(format, args); // 입력받은 yyyy-MM에 "-01"을 추가하여 yyyy-MM-dd 형식으로 만듭니다.
        java.util.Date date = sdf.parse(input + "-01");
        return date;
      } catch (ParseException e) {
        System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM 형식으로 입력해주세요.");
      }
    }
  }

  // 기존 작성 해두신거
  //public static Date inputDate(String format, Object... args) {
  //  //    return Date date = Date.parse(dateStr, formatter)
  //  //    String dateStr = input(format, args);
  //  while (true) {
  //    try {
  //      return Date.valueOf(input(format, args));
  //    } catch (IllegalArgumentException e) {
  //      System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM-dd 형식으로 입력해주세요.");
  //    }
  //  }
  //}

  public static void close() {
    keyboardScanner.close();
  }
}

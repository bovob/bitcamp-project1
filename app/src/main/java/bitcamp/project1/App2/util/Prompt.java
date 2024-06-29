package bitcamp.project1.App2.util;

//import java.sql.Date;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

//  받은거
//  public static java.util.Date inputDate(String format, Object... args) {
//    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM");
//    while (true) {
//      try {
//        String input = input(format, args); // 입력받은 yyyy-MM에 "-01"을 추가하여 yyyy-MM-dd 형식으로 만듭니다.
//        return formatDate.parse(input + "-01");
//      } catch (ParseException e) {
//        System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM 형식으로 입력해주세요.");
//      }
//    }
//  }

  public static java.util.Date inputDate(String format, Object... args) {
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    formatDate.setLenient(false); // 날짜 형식을 엄격하게 검사

    while (true) {
      try {
        String input = input(format, args);
        return formatDate.parse(input);
      } catch (ParseException e) {
        System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM-dd 형식으로 입력해주세요.");
      }
    }
  }

  // inputDate 메서드 수정 - yyyy-mm으로만 받을 조회용도
  public static java.util.Date inputDateMonth(String format, Object... args) {
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM");
    formatDate.setLenient(false); // 날짜 형식을 엄격하게 검사

    while (true) {
      try {
        String input = input(format, args);
        Date date = formatDate.parse(input);
        // yyyy-MM 형식으로 입력받은 후, 해당 월의 1일로 설정
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
      } catch (ParseException e) {
        System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM 형식으로 입력해주세요.");
      }
    }
  }

  public static void close() {
    keyboardScanner.close();
  }
}

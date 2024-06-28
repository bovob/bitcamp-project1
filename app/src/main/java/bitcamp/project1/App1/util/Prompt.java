package bitcamp.project1.App1.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static Date inputDate(String format, Object... args){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while(true){
            try{
                String dateString = input(format, args);
                return dateFormat.parse(dateString);
            }catch (ParseException e){
                System.out.println("날짜 형식이 올바르지 않습니다 (yyyy-mm-dd)");
            }
        }
    }

    public static void close() {
        keyboardScanner.close();
    }

}





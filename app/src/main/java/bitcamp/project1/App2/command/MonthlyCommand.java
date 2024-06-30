package bitcamp.project1.App2.command;

import bitcamp.project1.App2.vo.Income;
import bitcamp.project1.App2.util.Prompt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MonthlyCommand {

    // 결과저장
    ArrayList monthlyList = new ArrayList();

    public void executeMonthlyCommand() {
        Date date = Prompt.inputDate("년월을 입력하세요 (yyyy-MM): ");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        System.out.printf("\n%d년 %d월\n\n", year, month + 1);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int monthlyTotal = 0;

        for (int day = 1; day <= maxDay; day += 7) {
            printWeek(cal, day, maxDay);
        }

        System.out.printf("\n월 합계: %d\n", monthlyTotal);
    }

    private void printWeek(Calendar cal, int startDay, int maxDay) {
        // 날짜 출력
        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
            System.out.printf("%-14s", (startDay + i)+"일");
        }
        System.out.println();

        // 수입 출력
        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, startDay + i);
            Date currentDate = cal.getTime();
            int dailyTotal = getDailyTotal(currentDate);
            System.out.printf("입금:%8d원|", dailyTotal);
        }
        System.out.println();

//        출금 출력 넣어야 함
//        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
//            cal.set(Calendar.DAY_OF_MONTH, startDay + i);
//            Date currentDate = cal.getTime();
//            int dailyTotal = getDailyTotal(currentDate);
//            System.out.printf("입금:%9d원|", dailyTotal);
//        }
//        System.out.println();

        // 총합 출력
        int weeklyTotal = 0;
        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, startDay + i);
            Date currentDate = cal.getTime();
            int dailyTotal = getDailyTotal(currentDate);
            weeklyTotal += dailyTotal;
            System.out.printf("합계:%8d원|", weeklyTotal);
        }
        System.out.println("\n");
    }

    private int getDailyTotal(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);
        int total = 0;

        for (Object obj : monthlyList.toArray()) {
            Income income = (Income) obj;
            if (sdf.format(income.getDate()).equals(dateString)) {
                total += income.getAmount();
            }
        }

        return total;
    }
}
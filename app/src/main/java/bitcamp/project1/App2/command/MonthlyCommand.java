package bitcamp.project1.App2.command;

import bitcamp.project1.App2.vo.Income;
import bitcamp.project1.App2.util.Prompt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class MonthlyCommand {
    
    // 수입 목록 가져오기
    private final IncomeCommand incomeCommand;
    
    // 출금 작성 이후 추가해야함
    public MonthlyCommand(IncomeCommand incomeCommand){
        this.incomeCommand = incomeCommand;
    }

    public void executeMonthlyCommand() {
        Date date = Prompt.inputDate("년월을 입력하세요 (yyyy-MM): ");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        System.out.printf("\n%d년 %d월\n\n", year, month + 1);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int day = 1; day <= maxDay; day += 7) {
            printWeek(cal, day, maxDay);
        }

        // 월 합계 출력
        System.out.printf("* 총 합계 : %d \n\n", getMonthlyResult(date));

    }

    // 주 단위 출력
    private void printWeek(Calendar cal, int startDay, int maxDay) {
        // 날짜 출력
        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
            System.out.printf("%-14s", (startDay + i) + "일");
        }
        System.out.println();

        // 수입 출력
        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, startDay + i);
            Date currentDate = cal.getTime();
            int dailyIncomeTotal = getDailyIncome(currentDate);
            System.out.printf("입금:%8d원|", dailyIncomeTotal);
        }
        System.out.println();

        // 출금 출력
        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, startDay + i);
            Date currentDate = cal.getTime();
            int dailyOutcomeTotal = getDailyOutcome(currentDate);
            System.out.printf("출금:%8d원|", dailyOutcomeTotal);
        }
        System.out.println();
        
        // 합계 출력
        for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, startDay + i);
            Date currentDate = cal.getTime();
            int dailyTotal = 0;
            // 일 수입 받아오기
            int dailyIncomeTotal = getDailyIncome(currentDate);
            
            // 일 출금 받아오기 넣어야함
            int dailyOutcomeTotal = getDailyOutcome(currentDate);
            dailyTotal = dailyIncomeTotal - dailyOutcomeTotal;
            System.out.printf("합계:%8d원|", dailyTotal);
        }
        System.out.println("\n");

    }

    // 입금 출력
    private int getDailyIncome(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);
        int total = 0;

        LinkedList<Income> incomeList = incomeCommand.getIncomeList();

        for (Object obj : incomeList.toArray()) {
            Income income = (Income) obj;
            if (sdf.format(income.getDate()).equals(dateString)) {
                total += income.getAmount();
            }
        }
        return total;
    }

    // 출금 출력
    private int getDailyOutcome(Date date) {
        return 100;
    }

    // 월 합계 출력
    private int getMonthlyResult(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int total = 0;

        for (int day = 1; day <= maxDay; day++) {
            cal.set(Calendar.DAY_OF_MONTH, day);
            Date currentDate = cal.getTime();
            total += getDailyIncome(currentDate) - getDailyOutcome(currentDate);
        }

        return total;
    }

}
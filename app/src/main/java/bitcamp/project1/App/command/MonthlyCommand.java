package bitcamp.project1.App.command;

import bitcamp.project1.App.util.OpenaiAPI;
import bitcamp.project1.App.util.Prompt;
import bitcamp.project1.App.vo.Css;
import bitcamp.project1.App.vo.Income;
import bitcamp.project1.App.vo.Outcome;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class MonthlyCommand {
  private final IncomeCommand incomeCommand;
  private final OutcomeCommand outcomeCommand;
  private final OutcomeCommand fixedOutcomeCommand;
  Css css = new Css();

  public MonthlyCommand(IncomeCommand incomeCommand, OutcomeCommand outcomeCommand,
      OutcomeCommand fixedOutcomeCommand) {
    this.incomeCommand = incomeCommand;
    this.outcomeCommand = outcomeCommand;
    this.fixedOutcomeCommand = fixedOutcomeCommand;
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

    System.out.printf("* 총 합계 : %d \n\n", getMonthlyResult(date));
    OpenaiAPI openaiAPI = new OpenaiAPI();
    openaiAPI.sendRequest(getDailyIncome(date), getDailyOutcome(date));
    openaiAPI.printAssistantReply();

  }

  private void printWeek(Calendar cal, int startDay, int maxDay) {
    for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
      System.out.printf("%-14s", (startDay + i) + "일");
    }
    System.out.println();

    for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
      cal.set(Calendar.DAY_OF_MONTH, startDay + i);
      Date currentDate = cal.getTime();
      int dailyIncomeTotal = getDailyIncome(currentDate);
      System.out.printf("입금:%8d원|", dailyIncomeTotal);
    }
    System.out.println();

    for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
      cal.set(Calendar.DAY_OF_MONTH, startDay + i);
      Date currentDate = cal.getTime();
      int dailyOutcomeTotal = getDailyOutcome(currentDate);
      System.out.printf("출금:" + css.redAnsi + "%8d" + css.resetAnsi + "원|", dailyOutcomeTotal);
    }
    System.out.println();

    for (int i = 0; i < 7 && (startDay + i) <= maxDay; i++) {
      cal.set(Calendar.DAY_OF_MONTH, startDay + i);
      Date currentDate = cal.getTime();
      int dailyTotal = 0;
      int dailyIncomeTotal = getDailyIncome(currentDate);

      int dailyOutcomeTotal = getDailyOutcome(currentDate);
      dailyTotal = dailyIncomeTotal - dailyOutcomeTotal;
      System.out.printf("합계:%8d원|", dailyTotal);
    }
    System.out.println("\n");

  }

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

  private int getDailyOutcome(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = sdf.format(date);
    int total = 0;
    LinkedList<Outcome> outcomeList = outcomeCommand.getOutcomeList();
    LinkedList<Outcome> fixedOutcomeList = fixedOutcomeCommand.getOutcomeList();

    for (Object obj : outcomeList.toArray()) {
      Outcome outcome = (Outcome) obj;
      if (sdf.format(outcome.getDate()).equals(dateString)) {
        total += outcome.getAmount();
      }
    }
    for (Object obj : fixedOutcomeList.toArray()) {
      Outcome outcome = (Outcome) obj;
      if (sdf.format(outcome.getDate()).equals(dateString)) {
        total += outcome.getAmount();
      }
    }
    return total;
  }

  private int getMonthlyResult(Date date) {
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

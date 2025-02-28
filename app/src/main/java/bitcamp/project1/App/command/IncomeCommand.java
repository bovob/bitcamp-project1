package bitcamp.project1.App.command;

import bitcamp.project1.App.util.Prompt;
import bitcamp.project1.App.vo.Income;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

public class IncomeCommand {

  LinkedList<Income> incomeList = new LinkedList<>();

  // 수입 메뉴목록
  public void executeIncomeCommand(String command) {
    System.out.printf("[%s]\n", command);
    switch (command) {
      case "등록":
        this.addIncome();
        break;
      case "목록":
        this.listIncome();
        break;
      case "변경":
        this.updateIncome();
        break;
      case "삭제":
        this.deleteIncome();
        break;
    }
  }

  // 수입 등록
  private void addIncome() {
    Income income = new Income();
    income.setAmount(Prompt.inputInt("금액? "));
    income.setDate(Prompt.inputDate("날짜? "));
    income.setMemo(Prompt.input("메모?"));
    income.setNo(Income.getNextSeqNo());
    incomeList.add(income);
    System.out.println("등록했습니다.");
  }

  // 수입 목록
  private void listIncome() {
    String command = Prompt.input("전체를 검색?(Y/N)");

    Object[] incomes;
    if (command.equalsIgnoreCase("Y")) {
      incomes = incomeList.toArray();
      printIncomes(incomes);
    } else if (command.equalsIgnoreCase("N")) {
      Date dateInput = Prompt.inputDate("날짜? (yyyy-MM)");
      incomes = getIncomesByMonth(dateInput);
      printIncomes(incomes);
    } else {
      System.out.println("잘못된 입력입니다.");
      return;
    }

    String sortOption = Prompt.input("정렬 옵션 (1: 날짜순, 2: 금액순)");
    if (sortOption.equals("1") || sortOption.equals("2")) {
      sortAndPrintIncomes(incomes, sortOption);
    } else {
      System.out.println("잘못된 정렬 옵션입니다.");
    }

    System.out.println("목록 조회를 마칩니다.");
  }

  // 전체 출력
  private void printIncomes(Object[] incomes) {
    System.out.println("수입번호 날짜 이름 금액");
    int sum = 0;
    for (Object obj : incomes) {
      Income income = (Income) obj;
      System.out.printf("%d %s %s %d\n", income.getNo(), income.getDate(), income.getMemo(),
          income.getAmount());
      sum += income.getAmount();
    }
    System.out.printf("총 합계: %d\n", sum);
  }

  // 월 출력
  private Object[] getIncomesByMonth(Date targetDate) {
    SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
    String targetYearMonth = yearMonthFormat.format(targetDate);
    java.util.List<Income> filteredIncomes = new java.util.ArrayList<>();

    for (Object obj : incomeList.toArray()) {
      Income income = (Income) obj;
      Date incomeDate = income.getDate();
      String incomeYearMonth = yearMonthFormat.format(incomeDate);
      if (incomeYearMonth.equals(targetYearMonth)) {
        filteredIncomes.add(income);
      }
    }
    return filteredIncomes.toArray();
  }

  // 정렬 출력
  private void sortAndPrintIncomes(Object[] incomes, String sortOption) {
    if (sortOption.equals("1")) { // 날짜순
      Arrays.sort(incomes, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
          Income income1 = (Income) o1;
          Income income2 = (Income) o2;
          return income1.getDate().compareTo(income2.getDate());
        }
      });
    } else if (sortOption.equals("2")) { // 금액순 (내림차순)
      Arrays.sort(incomes, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
          Income income1 = (Income) o1;
          Income income2 = (Income) o2;
          return Integer.compare(income2.getAmount(), income1.getAmount());
        }
      });

    }

    System.out.println("\n정렬된 목록:");
    printIncomes(incomes);
  }

  // 수입 변경
  private void updateIncome() {
    int incomeNo = Prompt.inputInt("수정하실 항목을 선택해주세요 : ");
    Income income = incomeList.get(incomeList.indexOf(new Income(incomeNo)));
    if (income == null) {
      System.out.println("존재하지 않는 항목입니다.");
      return;
    }
    income.setDate(Prompt.inputDate("날짜 (%tY-%<tm-%<td)", income.getDate()));
    income.setAmount(Prompt.inputInt("금액(%d)?", income.getAmount()));
    income.setMemo(Prompt.input("메모 (%s)? ", income.getMemo()));
    System.out.println("변경되었습니다.");
  }

  // 수입 삭제
  private void deleteIncome() {
    int incomeNo = Prompt.inputInt("삭제하실 항목을 선택해주세요 : ");
    Income deletedIncome = incomeList.get(incomeList.indexOf(new Income(incomeNo)));

    if (deletedIncome != null) {
      incomeList.remove(deletedIncome);
      System.out.printf("'%s'을 삭제 했습니다.\n", deletedIncome.getMemo());
    } else {
      System.out.println("없는 수입번호 입니다.");
    }

  }


  public LinkedList<Income> getIncomeList() {
    return this.incomeList;
  }
}

package bitcamp.project1.App2.command;

import bitcamp.project1.App2.util.OutcomeComparator;
import bitcamp.project1.App2.util.Prompt;
import bitcamp.project1.App2.vo.Outcome;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;

public class OutcomeCommand {

  LinkedList<Outcome> outcomeList = new LinkedList<>();

  public void executeOutcomeCommand(String command) {
    System.out.printf("[%s]\n", command);
    switch (command) {
      case "등록":
        this.addOutcome();
        break;
      case "목록":
        this.viewOutcome();
        break;
      case "변경":
        this.updateOutcome();
        break;
      case "삭제":
        this.deleteOutcome();
        break;
    }
  }

  private void viewOutcome() {
    String command = Prompt.input("전체를 검색하시겠습니까?(Y/N)");
    if (command.equalsIgnoreCase("Y")) {
      OutcomeComparator.sortOutcomes(outcomeList, Prompt.inputInt("정렬 방식을 선택하세요 1: 금액순 2: 날짜순"));
      listOutcome();
    } else if (command.equalsIgnoreCase("N")) {
      Date dateInput = Prompt.inputDate("날짜? (yyyy-MM)");
      listOutcomesByMonth(dateInput);
    } else {
      System.out.println("잘못된 입력입니다.");
      return;
    }
    int outcomNo = Prompt.inputInt("상세 조회할 항목을 선택해주세요: ");
    int index = outcomeList.indexOf(new Outcome(outcomNo));
    if (index != -1) {
      Outcome outcome = outcomeList.get(index);
      System.out.printf("날짜 : %tY-%<tm-%<td\n", outcome.getDate());
      System.out.printf("금액 : %d\n", outcome.getAmount());
      System.out.printf("메모 : %s\n", outcome.getMemo());
    } else {
      System.out.println("존재하지 않는 항목입니다.");
    }
  }

  private void updateOutcome() {
    OutcomeComparator.sortOutcomes(outcomeList, 0);
    listOutcome();
    int outcomNo = Prompt.inputInt("수정하실 항목을 선택해주세요 : ");
    int index = outcomeList.indexOf(new Outcome(outcomNo));
    if (index != -1) {
      Outcome outcome = outcomeList.get(index);
      outcome.setDate((Prompt.inputDate("날짜 (%tY-%<tm-%<td): \n", outcome.getDate())));
      outcome.setAmount((Prompt.inputInt("금액 (%d): \n", outcome.getAmount())));
      outcome.setMemo((Prompt.input("메모 (%s): \n", outcome.getMemo())));
      System.out.println("변경되었습니다.");
    } else {
      System.out.println("존재하지 않는 항목입니다.");
    }

  }

  private void deleteOutcome() {
    OutcomeComparator.sortOutcomes(outcomeList, 0);
    listOutcome();
    int outcomeNo = Prompt.inputInt("삭제하실 항목을 선택해주세요 : ");
    int index = outcomeList.indexOf(new Outcome(outcomeNo));
    if (index != -1) {
      Outcome deletedOutcome = outcomeList.get(index);
      outcomeList.remove(index);
      System.out.printf("%tY-%<tm-%<td %d원 삭제했습니다.\n", deletedOutcome.getDate(),
          deletedOutcome.getAmount());
    } else {
      System.out.println("존재하지 않는 항목입니다.");
    }
  }

  private void addOutcome() {
    Outcome outcome = new Outcome();
    outcome.setNo(Outcome.getSeqNo());
    outcome.setAmount(Prompt.inputInt("금액 : "));
    outcome.setDate(Prompt.inputDate("날짜 : "));
    outcome.setMemo(Prompt.input("메모 :"));
    outcomeList.add(outcome);
    System.out.println("등록했습니다.");
  }

  private void listOutcome() {
    System.out.println("번호 날짜 금액");
    for (Object obj : outcomeList.toArray()) {
      Outcome outcome = (Outcome) obj;
      System.out.printf("%d %tY-%<tm-%<td %d원\n", outcome.getNo(), outcome.getDate(),
          outcome.getAmount());
    }
  }

  private void listOutcomesByMonth(Date dateInput) {
    System.out.println("번호 날짜 금액");
    for (Outcome outcome : outcomeList) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(outcome.getDate());
      Calendar inputCal = Calendar.getInstance();
      inputCal.setTime(dateInput);
      if (cal.get(Calendar.YEAR) == inputCal.get(Calendar.YEAR) && cal.get(
          Calendar.MONTH) == inputCal.get(Calendar.MONTH)) {
        System.out.printf("%d %tY-%<tm-%<td %d원\n", outcome.getNo(), outcome.getDate(),
            outcome.getAmount());
      }
    }
  }

  public LinkedList<Outcome> getOutcomeList() {
    return outcomeList;
  }
}

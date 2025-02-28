package bitcamp.project1.App.command;

import bitcamp.project1.App.util.Prompt;
import bitcamp.project1.App.vo.Css;
import bitcamp.project1.App.vo.Goal;
import bitcamp.project1.App.vo.Outcome;

import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class GoalCommand {

  Css css = new Css();
  LinkedList<Goal> goalList = new LinkedList<>();
  private OutcomeCommand outcomeCommand;
  private OutcomeCommand fixedOutcomeCommand;

  public GoalCommand(OutcomeCommand outcomeCommand, OutcomeCommand fixedOutcomeCommand) {
    this.outcomeCommand = outcomeCommand;
    this.fixedOutcomeCommand = fixedOutcomeCommand;
  }

  public void executeGoalcomeCommand(String command) {
    System.out.printf("[%s]\n", command);
    switch (command) {
      case "등록":
        this.addGoal();
        break;
      case "목록":
        this.listGoal();
        break;
      case "변경":
        this.updateGoal();
        break;
      case "삭제":
        this.deleteGoal();
        break;
    }

  }

  private void addGoal() {
    Goal goal = new Goal();
    goal.setMemo(Prompt.input("목표 : "));
    goal.setDate(Prompt.inputDate("목표 월 입력(yyyy-mm) : "));
    goal.setAmount(Prompt.inputInt("예산금액 : "));
    goal.setNo(Goal.getNextSeqNo());
    goalList.add(goal);
  }

  private void listGoal() {
    if (goalList.isEmpty()) {
      System.out.println("등록된 목표가 없습니다.");
      return;
    }

    System.out.println("목표번호 날짜    목표명   예산   현재지출    남은금액 | 성공여부");
    for (Goal obj : goalList) {
      Goal goal = obj;              //%d 바꿔야함
      System.out.printf("%8d %tY-%<tm %s  %6d %8d %8d   | " + css.blueAnsi + "%b\n" + css.resetAnsi,
          goal.getNo(), // 번호
          goal.getDate(), // 날짜
          goal.getMemo(), //목표명
          goal.getAmount(), //예산
          calExpense(goal.getNo()), calRemain(goal.getNo()), // 남은금액
          isSuccess(calRemain(goal.getNo())) // 성공여부
      );

    }
  }

  // 목표 변경
  private void updateGoal() {
    int goalNo = Prompt.inputInt("변경하실 항목을 선택해주세요 : ");
    Goal goal = findGoalByNo(goalNo);
    if (goal == null) {
      System.out.println("없는 번호입니다.");
      return;
    }
    goal.setDate(Prompt.inputDate("날짜(%s) : ", goal.getDate()));
    goal.setMemo(Prompt.input("목표(%s) : ", goal.getMemo()));
    goal.setAmount(Prompt.inputInt("예산금액(%d) : ", goal.getAmount()));
  }

  // 목표 삭제
  private void deleteGoal() {
    int goalNo = Prompt.inputInt("목표번호?");
    Goal deletedGoal = findGoalByNo(goalNo);

    if (deletedGoal != null) {
      goalList.remove(deletedGoal);
      System.out.printf("'%s'을 삭제 했습니다.\n", deletedGoal.getMemo());
    } else {
      System.out.println("존재하지 않는 항목 입니다.");
    }
  }

  // 금액 계산
  public int calRemain(int goalNo) {
    Goal goal = findGoalByNo(goalNo);
    if (goal == null) {
      return -1;
    }
    return goal.getAmount() - calExpense(goalNo);
  }

  public int calExpense(int goalNo) {
    int currentExpense = 0;
    Goal goal = findGoalByNo(goalNo);
    if (goal == null) {
      return 0;
    }
    LinkedList<Outcome> outcomeList = outcomeCommand.getOutcomeList();
    LinkedList<Outcome> fixedOutcomeList = fixedOutcomeCommand.getOutcomeList();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String goalYearMonth = sdf.format(goal.getDate());
    for (Object obj : outcomeList.toArray()) {
      Outcome outcome = (Outcome) obj;
      if (sdf.format(outcome.getDate()).equals(goalYearMonth)) {
        currentExpense += outcome.getAmount();
      }
    }
    for (Object obj : fixedOutcomeList.toArray()) {
      Outcome outcome = (Outcome) obj;
      if (sdf.format(outcome.getDate()).equals(goalYearMonth)) {
        currentExpense += outcome.getAmount();
      }
    }
    return currentExpense;
  }

  //    public int calRemain(int goalNo){
  //        // 결과값, 계산값
  //        int result, cal;
  //
  //        // ! 지출금액 테스트용도로 넣은 변수
  //        int outcome = 100;
  //
  //        Goal goal = goalList.get(goalList.indexOf(new Goal(goalNo)));
  //        cal = goal.getAmount();
  //
  //        result = cal - outcome;
  //
  //        return result;
  //    }

  // 성공 여부 확인

  public boolean isSuccess(int remainAmount) {
    return remainAmount >= 0;
  }

  public String goalSuccess(boolean b) {
    return b ? " 성공" : " 실패";
  }

  //    public boolean isSuccess(int goalNo){
  //        // 결과값, 계산값
  //        int result, cal;
  //
  //        // ! 지출금액 테스트용도로 넣은 변수
  //        int outcome = 100;
  //        Goal goal = goalList.get(goalList.indexOf(new Goal(goalNo)));
  //        cal = goal.getAmount();
  //        result = cal - outcome;
  //        return result >= 0;
  //    }

  // 인덱스 번호 확인용
  private Goal findGoalByNo(int goalNo) {
    for (Goal goal : goalList) {
      if (goal.getNo() == goalNo) {
        return goal;
      }
    }
    return null;
  }
}

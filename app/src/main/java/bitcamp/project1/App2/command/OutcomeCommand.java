package bitcamp.project1.App2.command;

import bitcamp.project1.App2.util.Prompt;
import bitcamp.project1.App2.vo.Outcome;

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
        this.listOutcome();
        break;
      case "변경":
        System.out.println("준비중");
        //        this.updateOutcome();
        break;
      case "삭제":
        System.out.println("준비중");
        //        this.deleteOutcome();
        break;
    }
  }

  //  private void viewOutcome() {
  //    int boardNo = Prompt.inputInt("게시글 번호?");
  //    Outcome board = (Outcome) boardList.get(boardList.indexOf(new Outcome(boardNo)));
  //    if (board == null) {
  //      System.out.println("없는 게시글 입니다.");
  //      return;
  //    }
  //    board.setView();
  //    System.out.printf("제목: %s\n", board.getTitle());
  //    System.out.printf("내용: %s\n", board.getContent());
  //    System.out.printf("작성일: %tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.getCreateDate());
  //    System.out.printf("조회수: %d\n", board.getViewCount());
  //  }
  //
  private void updateOutcome() {
    int outcomNo = Prompt.inputInt("게시글 번호?");
    Outcome outcome = outcomeList.get(outcomeList.indexOf(new Outcome(outcomNo)));
    if (outcome == null) {
      System.out.println("없는 게시글 입니다.");
      return;
    }
    outcome.setView();
    outcome.setTitle((Prompt.input("프로젝트명(%s): \n", outcome.getTitle())));
    outcome.setContent((Prompt.input("설명(%s): \n", outcome.getContent())));
    System.out.println("변경됨");
  }

  //  private void deleteOutcome() {
  //    int boardNo = Prompt.inputInt("프로젝트 번호?");
  //    Outcome deletedBoard = (Outcome) boardList.get(boardList.indexOf(new Outcome(boardNo)));
  //    if (deletedBoard != null) {
  //      boardList.remove(boardList.indexOf(deletedBoard));
  //      System.out.printf("%s 삭제됨\n", deletedBoard.getTitle());
  //    } else {
  //      System.out.println("없는 게시글입니다.");
  //    }
  //  }

  private void addOutcome() {
    Outcome outcome = new Outcome();
    outcome.setNo(Outcome.getSeqNo());
    outcome.setAmount(Prompt.inputInt("쓴 돈: "));
    outcome.setDate(Prompt.inputDate("날짜 (yyyy-MM-dd): "));
    outcome.setMemo(Prompt.input("메모:"));
    outcomeList.add(outcome);
    System.out.println("등록했습니다.");
  }

  private void listOutcome() {
    System.out.println("번호 날짜 금액");
    for (Object obj : outcomeList.toArray()) {
      Outcome outcome = (Outcome) obj;
      System.out.printf("%d %tB/%td일 -%d원\n", outcome.getNo(), outcome.getDate(), outcome.getDate(),
          outcome.getAmount());
    }
  }



}

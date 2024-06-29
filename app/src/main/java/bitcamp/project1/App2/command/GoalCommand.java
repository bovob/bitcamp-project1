package bitcamp.project1.App2.command;

import bitcamp.project1.App2.util.Prompt;
import bitcamp.project1.App2.vo.Goal;
import bitcamp.project1.App2.vo.Income;
import java.util.LinkedList;

public class GoalCommand {

    LinkedList<Goal> goalList = new LinkedList<>();

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
    
    // 목표 등록
    private void addGoal() {
        Goal goal = new Goal();
        goal.setDate(Prompt.inputDateMonth("날짜? (yyyy-mm)"));
        goal.setMemo(Prompt.input("목표 명?"));
        goal.setAmount(Prompt.inputInt("예산금액?"));
        goal.setNo(Goal.getNextSeqNo());
        goalList.add(goal);
    }

    // 목표 리스트
    // ! 지출 들어가야됨
    private void listGoal() {
        if (goalList.isEmpty()) {
            System.out.println("등록된 목표가 없습니다.");
            return;
        }

        System.out.println("목표번호 날짜 목표명 예산 현재지출 남은금액 | 성공여부");
        for (Goal obj : goalList) {
            Goal goal = obj;              //%d 바꿔야함
            System.out.printf("%d %s %s %d %s %d | %b\n",
                goal.getNo(), // 번호
                goal.getDate(), // 날짜
                goal.getMemo(), //목표명
                goal.getAmount(), //예산
                "금월 지출 전체 값 넣을자리",
                calRemain(goal.getNo()), // 남은금액
                isSuccess(calRemain(goal.getNo())) // 성공여부
            );

        }
    }

    // 목표 변경
    private void updateGoal() {
        int goalNo = Prompt.inputInt("목표 번호? ");
        Goal goal = findGoalByNo(goalNo);
        if (goal == null) {
            System.out.println("없는 번호입니다.");
            return;
        }
        goal.setDate(Prompt.inputDateMonth("날짜(%s)? ", goal.getDate()));
        goal.setMemo(Prompt.input("목표명(%s)? ", goal.getMemo()));
        goal.setAmount(Prompt.inputInt("예산(%d)? ", goal.getAmount()));
    }
    
    // 목표 삭제
    private void deleteGoal() {
        int goalNo = Prompt.inputInt("목표번호?");
        Goal deletedGoal = findGoalByNo(goalNo);

        if (deletedGoal != null) {
            goalList.remove(deletedGoal);
            System.out.printf("'%s'을 삭제 했습니다.\n", deletedGoal.getMemo());
        } else {
            System.out.println("없는 목표번호 입니다.");
        }
    }

    // 금액 계산
    public int calRemain(int goalNo) {
        Goal goal = findGoalByNo(goalNo);
        if (goal == null) {
            return 0; // 또는 예외를 던질 수 있습니다.
        }
        int outcome = 100; // 실제 지출 계산 로직으로 대체해야 합니다.
        return goal.getAmount() - outcome;
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

    public boolean isSuccess(int goalNo) {
        return calRemain(goalNo) >= 0;
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

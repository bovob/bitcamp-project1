package bitcamp.project1.App1.command;

import  bitcamp.project1.App1.vo.Budget;
import  bitcamp.project1.App1.util.Prompt;

public class BudgetCommand {

    public static void executeBudgetCommand(String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                addBudget();
                break;
            //case "조회":
            //    viewBudget();
            //    break;
            //case "목록":
            //    listBudget();
            //    break;
            //case "변경":
            //    updateBudget();
            //    break;
            //case "삭제":
            //    deleteBudget();
            //    break;
        }
    }

    private static void addBudget() {
        Budget budget = new Budget();
        budget.setName(Prompt.input("이름?"));
        budget.setMoney(Prompt.inputInt("이메일?"));
        budget.setSumMoney(Prompt.inputInt("암호?"));
        budget.setNo(Budget.getNextSeqNo());
        //BudgetList.add(budget);
    }

    //private static void listBudget() {
    //    System.out.println("번호 이름 이메일");
    //    for (Budget budget : BudgetList.toArray()) {
    //        System.out.printf("%d %s %s\n", budget.getNo(), budget.getName(), budget.getEmail());
    //    }
    //}
    //
    //private static void viewBudget() {
    //    int budgetNo = Prompt.inputInt("회원번호?");
    //    Budget budget = BudgetList.findByNo(budgetNo);
    //    if (budget == null) {
    //        System.out.println("없는 회원입니다.");
    //        return;
    //    }
    //
    //    System.out.printf("이름: %s\n", budget.getName());
    //    System.out.printf("이메일: %s\n", budget.getEmail());
    //    System.out.printf("연락처: %s\n", budget.getTel());
    //}
    //
    //private static void updateBudget() {
    //    int budgetNo = Prompt.inputInt("회원번호?");
    //    Budget budget = BudgetList.findByNo(budgetNo);
    //    if (budget == null) {
    //        System.out.println("없는 회원입니다.");
    //        return;
    //    }
    //
    //    budget.setName(Prompt.input("이름(%s)?", budget.getName()));
    //    budget.setEmail(Prompt.input("이메일(%s)?", budget.getEmail()));
    //    budget.setPassword(Prompt.input("암호?"));
    //    budget.setTel(Prompt.input("연락처(%s)?", budget.getTel()));
    //    System.out.println("변경 했습니다.");
    //}
    //
    //private static void deleteBudget() {
    //    int budgetNo = Prompt.inputInt("회원번호?");
    //    Budget deletedBudget = BudgetList.delete(budgetNo);
    //    if (deletedBudget != null) {
    //        System.out.printf("'%s' 회원을 삭제 했습니다.\n", deletedBudget.getName());
    //    } else {
    //        System.out.println("없는 회원입니다.");
    //    }
    //}

}

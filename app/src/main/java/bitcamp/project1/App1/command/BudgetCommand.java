package bitcamp.project1.App1.command;

import bitcamp.project1.App1.util.LinkedList;
import bitcamp.project1.App1.util.Prompt;
import bitcamp.project1.App1.vo.Budget;

public class BudgetCommand {

    LinkedList budgetList = new LinkedList();

    public void executeBudgetCommand(String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                this.addBudget();
                break;
            case "조회":
                this.viewBudget();
                break;
            case "목록":
                this.listBudget();
                break;
            case "변경":
                this.updateBudget();
                break;
            case "삭제":
                this.deleteBudget();
                break;
        }
    }

    private void addBudget() {
        Budget budget = new Budget();
        budget.setName(Prompt.input("예산이름?"));
        budget.setMoney(Prompt.inputInt("금액?"));
        budget.setNo(Budget.getNextSeqNo());
        budgetList.add(budget);
        System.out.printf("총 합계? %d\n",budgetList.sumValue());
    }

    private void viewBudget() {
        int budgetNo = Prompt.inputInt("예산번호?");
        Budget budget = (Budget) budgetList.get(budgetList.indexOf(new Budget(budgetNo)));
        if (budget == null) {
            System.out.println("없는 예산번호입니다.");
            return;
        }
        System.out.printf("예산번호: %d\n", budgetNo);
        System.out.printf("예산명: %s\n", budget.getName());
        System.out.printf("금액: %s\n", budget.getMoney());
        System.out.printf("총 금액: %d\n", budgetList.sumValue());
    }

    private void listBudget() {
        System.out.println("예산번호 이름 금액 합계");
        for (Object obj : budgetList.toArray()) {
            Budget budget = (Budget) obj;
            System.out.printf("%d %s %d %d\n", budget.getNo(), budget.getName(), budget.getMoney(),budgetList.sumValue());
        }
    }

    private void updateBudget() {
        int budgetNo = Prompt.inputInt("예산번호?");
        Budget budget = (Budget) budgetList.get(budgetList.indexOf(new Budget(budgetNo)));
        if (budget == null) {
            System.out.println("없는 예산입니다.");
            return;
        }

        budget.setName(Prompt.input("예산이름(현재 : %s)?", budget.getName()));
        budget.setMoney(Prompt.inputInt("예산(현재 : %d)?", budget.getMoney()));
        System.out.printf("총 합계? %d\n",budgetList.sumValue());
        System.out.println("변경 했습니다.");
    }

    private void deleteBudget() {
        int budgetNo = Prompt.inputInt("예산번호?");
        Budget deletedBudget = (Budget) budgetList.get(budgetList.indexOf(new Budget(budgetNo)));

        if (deletedBudget != null) {
            budgetList.remove(budgetList.indexOf(deletedBudget));
            System.out.printf("'%s'을 삭제 했습니다.\n", deletedBudget.getName());
        } else {
            System.out.println("없는 예산(자산)입니다.");
        }

    }
}

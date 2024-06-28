package bitcamp.project1.App1.command;

import bitcamp.project1.App1.util.LinkedList;
import bitcamp.project1.App1.util.Prompt;
import bitcamp.project1.App1.vo.Income;

public class IncomeCommand {

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
        Income income = new Income();
        income.setName(Prompt.input("수입 명?"));
        income.setMoney(Prompt.inputInt("금액?"));
        income.setNo(Income.getNextSeqNo());
        budgetList.add(income);
        System.out.printf("총 합계? %d\n",budgetList.sumValue());
    }

    private void viewBudget() {
        int budgetNo = Prompt.inputInt("예산번호?");
        Income income = (Income) budgetList.get(budgetList.indexOf(new Income(budgetNo)));
        if (income == null) {
            System.out.println("없는 수입번호입니다.");
            return;
        }
        System.out.printf("수입번호: %d\n", budgetNo);
        System.out.printf("수입명: %s\n", income.getName());
        System.out.printf("금액: %s\n", income.getMoney());
        System.out.printf("총 금액: %d\n", budgetList.sumValue());
    }

    private void listBudget() {
        System.out.println("수입번호 이름 금액 합계");
        for (Object obj : budgetList.toArray()) {
            Income income = (Income) obj;
            System.out.printf("%d %s %d %d\n", income.getNo(), income.getName(), income.getMoney(),budgetList.sumValue());
        }
    }

    private void updateBudget() {
        int budgetNo = Prompt.inputInt("수입번호?");
        Income income = (Income) budgetList.get(budgetList.indexOf(new Income(budgetNo)));
        if (income == null) {
            System.out.println("없는 번호입니다.");
            return;
        }

        income.setName(Prompt.input("수입명(현재 : %s)?", income.getName()));
        income.setMoney(Prompt.inputInt("가격(현재 : %d)?", income.getMoney()));
        System.out.printf("총 합계? %d\n",budgetList.sumValue());
        System.out.println("변경 했습니다.");
    }

    private void deleteBudget() {
        int budgetNo = Prompt.inputInt("수입번호?");
        Income deletedIncome = (Income) budgetList.get(budgetList.indexOf(new Income(budgetNo)));

        if (deletedIncome != null) {
            budgetList.remove(budgetList.indexOf(deletedIncome));
            System.out.printf("'%s'을 삭제 했습니다.\n", deletedIncome.getName());
        } else {
            System.out.println("없는 수입번호 입니다.");
        }

    }
}

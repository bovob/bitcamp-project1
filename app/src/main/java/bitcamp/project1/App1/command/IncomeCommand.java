package bitcamp.project1.App1.command;

import bitcamp.project1.App1.util.LinkedList;
import bitcamp.project1.App1.util.Prompt;
import bitcamp.project1.App1.vo.Income;

public class IncomeCommand {

    LinkedList incomeList = new LinkedList();

    public void executeBudgetCommand(String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                this.addIncome();
                break;
            case "조회":
                this.viewIncome();
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

    private void addIncome() {
        Income income = new Income();
        income.setDate(Prompt.inputDate("날짜? (yyyy-mm-dd)"));
        income.setName(Prompt.input("수입 명?"));
        income.setMoney(Prompt.inputInt("금액?"));
        income.setNo(Income.getNextSeqNo());
        incomeList.add(income);
        System.out.printf("총 합계? %d\n", incomeList.sumValue());
    }

    private void viewIncome() {
        int incomeNo = Prompt.inputInt("예산번호?");
        Income income = (Income) incomeList.get(incomeList.indexOf(new Income(incomeNo)));
        if (income == null) {
            System.out.println("없는 수입번호입니다.");
            return;
        }
        System.out.printf("날짜: %s\n", income.getDate());
        System.out.printf("수입번호: %d\n", incomeNo);
        System.out.printf("수입명: %s\n", income.getName());
        System.out.printf("금액: %s\n", income.getMoney());
        System.out.printf("총 금액: %d\n", incomeList.sumValue());
    }

    private void listIncome() {
        System.out.println("수입번호 날짜 이름 금액 합계");
        for (Object obj : incomeList.toArray()) {
            Income income = (Income) obj;
            System.out.printf("%d %s %s %d %d\n", income.getNo(), income.getDate(), income.getName(), income.getMoney(),
                incomeList.sumValue());
        }
    }

    private void updateIncome() {
        int incomeNo = Prompt.inputInt("수입번호?");
        Income income = (Income) incomeList.get(incomeList.indexOf(new Income(incomeNo)));
        if (income == null) {
            System.out.println("없는 번호입니다.");
            return;
        }
        income.setDate(Prompt.inputDate("날짜(현재 : %s)", income.getDate()));
        income.setName(Prompt.input("수입명(현재 : %s)?", income.getName()));
        income.setMoney(Prompt.inputInt("가격(현재 : %d)?", income.getMoney()));
        System.out.printf("총 합계? %d\n", incomeList.sumValue());
        System.out.println("변경 했습니다.");
    }

    private void deleteIncome() {
        int incomeNo = Prompt.inputInt("수입번호?");
        Income deletedIncome = (Income) incomeList.get(incomeList.indexOf(new Income(incomeNo)));

        if (deletedIncome != null) {
            incomeList.remove(incomeList.indexOf(deletedIncome));
            System.out.printf("'%s'을 삭제 했습니다.\n", deletedIncome.getName());
        } else {
            System.out.println("없는 수입번호 입니다.");
        }

    }
}

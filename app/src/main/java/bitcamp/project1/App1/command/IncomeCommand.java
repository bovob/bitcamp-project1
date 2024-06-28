package bitcamp.project1.App1.command;

import bitcamp.project1.App1.util.LinkedList;
import bitcamp.project1.App1.util.Prompt;
import bitcamp.project1.App1.vo.Income;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;

public class IncomeCommand {

    LinkedList incomeList = new LinkedList();

    // 수입 메뉴목록
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

    // 수입 등록
    private void addIncome() {
        Income income = new Income();
        income.setDate(Prompt.inputDate("날짜? (yyyy-mm-dd)"));
        income.setName(Prompt.input("수입 명?"));
        income.setMoney(Prompt.inputInt("금액?"));
        income.setNo(Income.getNextSeqNo());
        incomeList.add(income);
    }

    // 수입 조회
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

    // 수입 목록
    private void listIncome() {
        String command;
        command = Prompt.input("전체를 검색?(Y/N)");
        
        if (command.equalsIgnoreCase("Y")) {
            System.out.println("수입번호 날짜 이름 금액");
            for (Object obj : incomeList.toArray()) {
                Income income = (Income) obj;
                System.out.printf("%d %s %s %d\n", income.getNo(), income.getDate(),
                    income.getName(), income.getMoney());
            }
            System.out.printf("총 합계 : %d\n", incomeList.sumValue());
        } else if (command.equalsIgnoreCase("N")) {
            Date dateInput =  Prompt.inputDateList("날짜? (yyyy-mm) ");

            SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
            String targetYearMonth = yearMonthFormat.format(dateInput);

            System.out.println("수입번호 날짜 이름 금액");
            int sum = 0;

            for (Object obj : incomeList.toArray()){
                Income income = (Income) obj;
                if(income.getDate().startsWith(targetYearMonth)){
                    System.out.printf("%d %s %s %d\n", income.getNo(), income.getDate(),
                        income.getName(), income.getMoney());
                    sum += income.getMoney();
                }
            }
            System.out.printf("%s 합계 : %d\n", targetYearMonth, sum);
        }
        System.out.println("목록 조회를 마칩니다.");
    }




    // 수입 변경
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

    // 수입 삭제
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

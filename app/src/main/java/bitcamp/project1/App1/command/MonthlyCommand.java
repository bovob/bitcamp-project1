package bitcamp.project1.App1.command;

import bitcamp.project1.App1.util.LinkedList;
import bitcamp.project1.App1.vo.Income;

public class MonthlyCommand {

    LinkedList incomeList = new LinkedList();

    public void executeMonthlyCommand (String command){
        System.out.printf("[%s]\n", command);
        System.out.println("수입번호 날짜 이름 금액 합계");

        for (Object obj : incomeList.toArray()) {
            Income income = (Income) obj;
            //System.out.printf("%d %s %s %d %d\n", income.getNo(), income.getDate(), income.getName(), income.getMoney(), income.sumValue());
        }

    }

}

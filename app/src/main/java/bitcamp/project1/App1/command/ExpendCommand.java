/**
 * 아직 틀만 복사함
 */

package bitcamp.project1.App1.command;

import bitcamp.project1.App1.util.LinkedList;
import bitcamp.project1.App1.util.Prompt;
import bitcamp.project1.App1.vo.Income;

public class ExpendCommand {

        LinkedList expendList = new LinkedList();

        public void executeExpendCommand(String command) {
            System.out.printf("[%s]\n", command);
            switch (command) {
                case "등록":
                    this.addExpend();
                    break;
                case "조회":
                    this.viewExpend();
                    break;
                case "목록":
                    this.listExpend();
                    break;
                case "변경":
                    this.updateExpend();
                    break;
                case "삭제":
                    this.deleteExpend();
                    break;
            }
        }

        private void addExpend() {
            Income income = new Income();
            income.setDate(Prompt.inputDate("날짜? (yyyy-mm-dd)"));
            income.setName(Prompt.input("지출 명?"));
            income.setMoney(Prompt.inputInt("금액?"));
            income.setNo(Income.getNextSeqNo());
            expendList.add(income);
            System.out.printf("총 합계? %d\n",expendList.sumValue());
        }

        private void viewExpend() {
            int expendNo = Prompt.inputInt("예산번호?");
            Income income = (Income) expendList.get(expendList.indexOf(new Income(expendNo)));
            if (income == null) {
                System.out.println("없는 지출번호입니다.");
                return;
            }
            //System.out.println("날짜 : %", income.getDate());
            System.out.printf("지출번호: %d\n", expendNo);
            System.out.printf("지출명: %s\n", income.getName());
            System.out.printf("금액: %s\n", income.getMoney());
            System.out.printf("총 금액: %d\n", expendList.sumValue());
        }

        private void listExpend() {
            System.out.println("지출번호 이름 금액 합계");
            for (Object obj : expendList.toArray()) {
                Income income = (Income) obj;
                System.out.printf("%d %s %d %d\n", income.getNo(), income.getName(), income.getMoney(),expendList.sumValue());
            }
        }

        private void updateExpend() {
            int expendNo = Prompt.inputInt("지출번호?");
            Income income = (Income) expendList.get(expendList.indexOf(new Income(expendNo)));
            if (income == null) {
                System.out.println("없는 번호입니다.");
                return;
            }

            income.setName(Prompt.input("지출명(현재 : %s)?", income.getName()));
            income.setMoney(Prompt.inputInt("가격(현재 : %d)?", income.getMoney()));
            System.out.printf("총 합계? %d\n",expendList.sumValue());
            System.out.println("변경 했습니다.");
        }

        private void deleteExpend() {
            int expendNo = Prompt.inputInt("지출번호?");
            Income deletedIncome = (Income) expendList.get(expendList.indexOf(new Income(expendNo)));

            if (deletedIncome != null) {
                expendList.remove(expendList.indexOf(deletedIncome));
                System.out.printf("'%s'을 삭제 했습니다.\n", deletedIncome.getName());
            } else {
                System.out.println("없는 지출번호 입니다.");
            }

        }
}
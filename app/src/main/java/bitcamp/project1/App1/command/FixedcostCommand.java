/**
 * 아직 날짜 적용안됨
 */

package bitcamp.project1.App1.command;


import bitcamp.project1.App1.util.LinkedList;
import bitcamp.project1.App1.util.Prompt;
import bitcamp.project1.App1.vo.Fixedcost;

public class FixedcostCommand {

    LinkedList fixedcostList = new LinkedList();

    public void executeFixedcostCommand (String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                this.addFixedcost();
                break;
            case "조회":
                this.viewFixedcost();
                break;
            case "목록":
                this.listFixedcost();
                break;
            case "변경":
                this.updateFixedcost();
                break;
            case "삭제":
                this.deleteFixedcost();
                break;
        }
    }

    private void addFixedcost() {
        Fixedcost fixedcost = new Fixedcost();
        fixedcost.setName(Prompt.input("고정지출명?"));
        fixedcost.setMoney(Prompt.inputInt("금액?"));
        fixedcost.setNo(Fixedcost.getNextSeqNo());
        fixedcostList.add(fixedcost);
        System.out.printf("총 합계? %d\n", fixedcostList.sumValue());

    }

    private void viewFixedcost() {
        int fixedcostNo = Prompt.inputInt("고정지출번호?");
        Fixedcost fixedcost = (Fixedcost) fixedcostList.get(fixedcostList.indexOf(new Fixedcost(fixedcostNo)));
        if (fixedcost == null) {
            System.out.println("없는 번호입니다.");
            return;
        }
        System.out.printf("고정지출번호: %d\n", fixedcostNo);
        System.out.printf("고정지출명: %s\n", fixedcost.getName());
        System.out.printf("금액: %s\n", fixedcost.getMoney());
        System.out.printf("총 금액: %d\n", fixedcostList.sumValue());
    }

    private void listFixedcost() {
        System.out.println("고정지출번호 이름 금액 합계");
        for (Object obj : fixedcostList.toArray()) {
            Fixedcost fixedcost = (Fixedcost) obj;
            System.out.printf("%d %s %d %d\n", fixedcost.getNo(), fixedcost.getName(), fixedcost.getMoney(),fixedcostList.sumValue());
        }
    }

    private void updateFixedcost() {
        int fixedcostNo = Prompt.inputInt("고정지출번호?");
        Fixedcost fixedcost = (Fixedcost) fixedcostList.get(fixedcostList.indexOf(new Fixedcost(fixedcostNo)));
        if (fixedcost == null) {
            System.out.println("없는 예산입니다.");
            return;
        }

        fixedcost.setName(Prompt.input("고정지출명(현재 : %s)?", fixedcost.getName()));
        fixedcost.setMoney(Prompt.inputInt("금액(현재 : %d)?", fixedcost.getMoney()));
        System.out.printf("총 합계? %d\n", fixedcostList.sumValue());
        System.out.println("변경 했습니다.");
    }

    private void deleteFixedcost() {
        int fixedcostNo = Prompt.inputInt("고정지출번호?");
        Fixedcost deletedFixedcost = (Fixedcost) fixedcostList.get(fixedcostList.indexOf(new Fixedcost(fixedcostNo)));

        if (deletedFixedcost != null) {
            fixedcostList.remove(fixedcostList.indexOf(deletedFixedcost));
            System.out.printf("'%s'을 삭제 했습니다.\n", deletedFixedcost.getName());
        } else {
            System.out.println("없는 번호입니다.");
        }

    }
}

package bitcamp.project1.App1.vo;

public class Budget {

    // 인덱스
    private static int seqNo;

    // 번호
    private int no;
    // 예산 이름
    private String Name;
    // 금액
    private int money;
    // 금액 전체
    private int sumMoney;

    public static int getSeqNo() {
        return seqNo;
    }

    public static void setSeqNo(int seqNo) {
        Budget.seqNo = seqNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    // 인덱스 추가
    public static int getNextSeqNo() {
        return ++seqNo;
    }
}

package bitcamp.project1.App1.vo;

import java.util.Objects;

public class Expend {
    // 인덱스
    private static int seqNo;
    // 번호
    private int no;
    // 예산 이름
    private String Name;
    // 금액
    private int money;

    // 기본연산자
    public Expend(){}

    // 예산번호 받을 연산자
    public Expend(int no){
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Expend budget = (Expend) o;
        return no == budget.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    public static int getSeqNo() {
        return seqNo;
    }

    public static void setSeqNo(int seqNo) {
        Expend.seqNo = seqNo;
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

    // 인덱스 추가
    public static int getNextSeqNo() {
        return ++seqNo;
    }
}


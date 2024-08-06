package bitcamp.project1.App.vo;

import java.util.Date;
import java.util.Objects;

public class Goal {
    private static int seqNo; //인덱스
    int no; //번호
    String memo; // 목표명
    Date date; // 날짜
    int amount; // 예산
   
    public Goal(){}

    public Goal(int no){
        this.no = no;
    }

    public static int getSeqNo() {
        return seqNo;
    }

    public static void setSeqNo(int seqNo) {
        Goal.seqNo = seqNo;
    }

    // 인덱스 추가
    public static int getNextSeqNo() {
        return ++seqNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Goal goal = (Goal) o;
        return no == goal.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

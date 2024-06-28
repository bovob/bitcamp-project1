package bitcamp.project1.App2.vo;

import java.sql.Date;

public class Outcome {
  private static int seqNo;
  int no;
  String memo;
  Date date;
  double amount;

  public Outcome() {
  }

  public Outcome(int no, String memo, Date date, double amount) {
    this.no = no;
    this.memo = memo;
    this.date = date;
    this.amount = amount;
  }

  public static int getSeqNo() {
    return ++seqNo;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }
}

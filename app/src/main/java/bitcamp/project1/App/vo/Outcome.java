package bitcamp.project1.App.vo;

import java.sql.Date;
import java.util.Objects;

public class Outcome {
  private static int seqNo;
  int no;
  String memo;
  Date date;
  int amount;

  public Outcome() {
  }

  public Outcome(int no) {
    this.no = no;
  }

  public Outcome(int no, String memo, Date date, int amount) {
    this.no = no;
    this.memo = memo;
    this.date = date;
    this.amount = amount;
  }

  public static int getSeqNo() {
    return ++seqNo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Outcome outcome = (Outcome) o;
    return no == outcome.no;
  }

  @Override
  public int hashCode() {
    return Objects.hash(no);
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
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

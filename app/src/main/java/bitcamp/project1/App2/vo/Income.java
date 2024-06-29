package bitcamp.project1.App2.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Income {

  // 인덱스
  private static int seqNo;
  // 번호
  private int no;
  // 수입 이름
  private String memo;
  // 금액
  private int amount;
  // 날짜
  private Date date;
  // 특정 년/월 조회
  private Date dateList;

  // 기본연산자
  public Income() {
  }

  // 수입번호 받을 연산자
  public Income(int no) {
    this.no = no;
  }

  public static int getSeqNo() {
    return seqNo;
  }

  public static void setSeqNo(int seqNo) {
    Income.seqNo = seqNo;
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
    Income income = (Income) o;
    return no == income.no;
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

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return this.date = date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDateList() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
    return dateFormat.format(this.dateList);
  }

  public void setDateList(Date dateList) {
    this.dateList = dateList;
  }
}

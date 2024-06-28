package bitcamp.project1.App1.vo;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Date;

public class Income {

    // 인덱스
    private static int seqNo;
    // 번호
    private int no;
    // 수입 이름
    private String Name;
    // 금액
    private int money;
    // 날짜
    private Date date;
    // 특정 년/월 조회
    private Date dateList;

    // 기본연산자
    public Income(){}

    // 수입번호 받을 연산자
    public Income(int no){
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
        Income income = (Income) o;
        return no == income.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    public static int getSeqNo() {
        return seqNo;
    }

    public static void setSeqNo(int seqNo) {
        Income.seqNo = seqNo;
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

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.date);
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


    // 인덱스 추가
    public static int getNextSeqNo() {
        return ++seqNo;
    }
}

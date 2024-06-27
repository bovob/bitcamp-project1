package bitcamp.project1.App1.util;

// 데이터 목록을 다루는 메서드 정의
public interface List {

    // 데이터를 더할 때 호출할 메서드
    void add(Object value);

    // 데이터 삭제할 때 호출할 메서드
    Object remove(int index);

    // 특정 값 가져오기
    Object get(int index);

    // 인덱스 값
    int indexOf(Object value);

    // 배열 값
    Object[] toArray();

    // 사이즈
    int size();
}

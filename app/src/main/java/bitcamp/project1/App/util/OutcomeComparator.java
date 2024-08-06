package bitcamp.project1.App.util;

import bitcamp.project1.App.vo.Outcome;

import java.util.Comparator;
import java.util.List;

public class OutcomeComparator {

  public static Comparator<Outcome> DateComparator = new Comparator<Outcome>() {
    @Override
    public int compare(Outcome o1, Outcome o2) {
      return o2.getDate().compareTo(o1.getDate());
    }
  };

  public static Comparator<Outcome> AmountComparator = new Comparator<Outcome>() {
    @Override
    public int compare(Outcome o1, Outcome o2) {
      return Integer.compare(o2.getAmount(), o1.getAmount());
    }
  };

  public static Comparator<Outcome> NoComparator = new Comparator<Outcome>() {
    @Override
    public int compare(Outcome o1, Outcome o2) {
      return Integer.compare(o1.getNo(), o2.getNo());
    }
  };

  public static void sortOutcomes(List<Outcome> list, int sortOption) {
    list.sort(getComparator(sortOption));
  }

  public static Comparator<Outcome> getComparator(int sortOption) {
    switch (sortOption) {
      case 1:
        return AmountComparator;
      case 2:
        return DateComparator;
      default:
        return NoComparator;
    }
  }
}

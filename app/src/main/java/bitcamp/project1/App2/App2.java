/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.project1.App2;

import bitcamp.project1.App2.command.OutcomeCommand;
import bitcamp.project1.App2.util.Prompt;
import bitcamp.project1.App2.vo.Css;

public class App2 {
  private static String appTitle = "[가계부]";
  Css css = new Css();
  String[] mainMenus = new String[] {"수입", "지출", "목표", "고정비", "월 결산", "종료"};
  String[][] subMenus =
      {{"등록", "목록", "변경", "삭제", "이전"}, {"등록", "목록", "변경", "삭제", "이전"}, {"등록", "목록", "변경", "이전"},
          {"등록", "목록", "조회", "변경", "삭제", "이전"}, {}};

  //  IncomeCommand uCommand = new UserCommand();
  OutcomeCommand outcomeCommand = new OutcomeCommand();
  //  BoardCommand noticeCommand = new BoardCommand();
  //  ProjectCommand projectCommand = new ProjectCommand(userCommand.getUserList());

  public static void main(String[] args) {
    new App2().execute();
  }

  public static String getAppTitle() {
    return appTitle;
  }

  void printmenu() {
    css.titlePrint();
    for (int i = 0; i < mainMenus.length; i++) {
      if (mainMenus[i].equals("종료")) {
        System.out.printf("%s%d. %s%s\n", (css.boldAnsi + css.redAnsi), (i + 1), mainMenus[i],
            css.resetAnsi);
      } else {
        System.out.printf("%d. %s\n", (i + 1), mainMenus[i]);
      }
    }
    css.lineSimple();
  }

  void printSubmenu(String menuTitle, String[] menus) {
    css.lineSimple();
    System.out.printf("[%s]", menuTitle);
    System.out.println();
    for (int i = 0; i < menus.length - 1; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i]);
    }
    System.out.printf("9. %s\n", menus[menus.length - 1]);
    css.lineSimple();
  }

  boolean isvalidatemenu(int menuNo, String[] menus) {

    return menuNo >= 1 && menuNo <= menus.length;
  }

  String getMenuTitle(int menuNo, String[] menus) {
    return isvalidatemenu(menuNo, menus) ? menus[menuNo - 1] : null;
  }

  void processMenu(String menuTitle, String[] menus) {
    if (menuTitle.equals("월 결산")) {
      System.out.println("월 결산입니다.");
      return;
    }
    printSubmenu(menuTitle, menus);
    while (true) {
      try {
        String command = Prompt.input(String.format("메인/%s>", menuTitle));
        if (command.equals("menu")) {
          printSubmenu(menuTitle, menus);
          continue;
        }
        int menuNo = Integer.parseInt(command);
        if (menuNo == 9) {
          break;
        }
        String subMenuTitle = getMenuTitle(menuNo, menus);
        if (subMenuTitle == null) {
          System.out.println("유효한 메뉴 번호가 아닙니다.");
        } else {
          switch (menuTitle) {
            case "수입":
              System.out.printf("여기는 앞으로 %s\n", subMenuTitle);
              break;
            case "지출":
              outcomeCommand.executeOutcomeCommand(subMenuTitle);
              break;
            case "목표":
              System.out.printf("여기는 앞으로 %s\n", subMenuTitle);
              break;
            case "고정비":
              System.out.printf("여기는 앞으로 %s\n", subMenuTitle);
              break;
            default:
              System.out.printf("%s 메뉴의 명령을 처리할 수 없습니다.\n", menuTitle);
          }
        }
      } catch (NumberFormatException ex) {
        System.out.println("숫자로 메뉴 번호를 입력하세요.");
      }
    }
  }

  void execute() {
    String command;
    printmenu();
    while (true) {
      try {
        command = Prompt.input("메인>");
        if (command.equals("menu")) {
          printmenu();
        } else {
          int menuNo = Integer.parseInt(command);
          String mainMenuItem = getMenuTitle(menuNo, mainMenus);
          if (mainMenuItem == null) {
            System.out.println("유효한 메뉴 번호가 아닙니다.");
          } else if (mainMenuItem.equals("종료")) {
            break;
          } else {
            this.processMenu(mainMenuItem, subMenus[menuNo - 1]);
          }
        }

      } catch (NumberFormatException ex) {
        System.out.println("숫자로 메뉴 번호를 입력하세요.");
      }
    }

    System.out.println("종료합니다.");
    Prompt.close();

  }


}

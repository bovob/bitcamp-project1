package bitcamp.project1.App1;

import bitcamp.project1.App1.command.ExpendCommand;
import bitcamp.project1.App1.command.IncomeCommand;
import bitcamp.project1.App1.command.FixedcostCommand;
import bitcamp.project1.App1.command.MonthlyCommand;
import bitcamp.project1.App1.util.Prompt;


public class App {

    static String[] mainMenus = new String[] { "수입", "지출", "월 결산", "고정비", "목표","종료" };
    static String[][] subMenus = {
        { "등록", "목록", "조회", "변경", "삭제" },
        { "등록", "목록", "조회", "변경", "삭제" },
        { }, // 월 결산은 리스트만
        { "등록", "목록", "조회", "변경", "삭제" },
        { "등록", "목록", "조회", "변경", "삭제" }
    };

    IncomeCommand incomeCommand = new IncomeCommand();
    FixedcostCommand fixedcostCommand = new FixedcostCommand();
    ExpendCommand expendCommand = new ExpendCommand();
    MonthlyCommand monthlyCommand = new MonthlyCommand();

    public static void main(String[] args) {
        new App().execute();
    }

    void execute() {
        printMenu();

        String command;

        while (true) {
            try {
                command = Prompt.input("메인메뉴>");

                if (command.equals("menu")) {
                    printMenu();

                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo, mainMenus); // 설명하는 변수
                    if (menuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                        break;
                    } else {
                        if (menuNo >= 1 && menuNo <= mainMenus.length) {
                            processMenu(menuTitle, subMenus[menuNo - 1]);
                        } else {
                            System.out.println(menuTitle);
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");
        Prompt.close();

    }

    static void printMenu() {
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String appTitle = "[가계 관리 시스템]";
        String line = "----------------------------------";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < mainMenus.length; i++) {
            if (mainMenus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), mainMenus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), mainMenus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    void processMenu(String menuTitle, String[] menus) {
        printSubMenu(menuTitle, menus);
        while (true) {
            String command = Prompt.input(String.format("메인/%s>", menuTitle));
            if (command.equals("menu")) {
                printSubMenu(menuTitle, menus);
                continue;
            } else if (command.equals("9")) { // 9 입력시 이전메뉴로
                break;
            }

            try {
                int menuNo = Integer.parseInt(command);
                String subMenuTitle = getMenuTitle(menuNo, menus);
                if (subMenuTitle == null) {
                    System.out.println("유효한 메뉴 번호가 아닙니다.");
                } else {
                    switch (menuTitle) {
                        case "수입":
                            System.out.println("수입");
                            incomeCommand.executeIncomeCommand(subMenuTitle);
                            break;
                        case "지출":
                            System.out.println("지출");
                            expendCommand.executeExpendCommand(subMenuTitle);
                            break;
                        case "월 결산":
                            System.out.println("월 결산");
                            monthlyCommand.executeMonthlyCommand(subMenuTitle);
                            break;
                        case "고정비":
                            System.out.println("고정비");
                            fixedcostCommand.executeFixedcostCommand(subMenuTitle);
                            break;
                        case "목표 설정":
                            System.out.println("목표 설정");
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

    static void printSubMenu(String menuTitle, String[] menus) {
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
        System.out.println("9. 이전");
    }



    static boolean isValidateMenu(int menuNo, String[] menus) {
        return menuNo >= 1 && menuNo <= menus.length;
    }

    static String getMenuTitle(int menuNo, String[] menus) {
        return isValidateMenu(menuNo, menus) ? menus[menuNo - 1] : null;
    }


}

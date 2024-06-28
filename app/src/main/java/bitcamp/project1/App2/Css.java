package bitcamp.project1.App2;


public class Css {
  String boldAnsi = "\033[1m";
  String redAnsi = "\033[31m";
  String resetAnsi = "\033[0m";
  String yellowAnsi = "\033[93m";
  String blueAnsi = "\033[94m";
  String blueBackAnsi = "\033[44m";


  public void titlePrint() {
    lineFlowery();
    System.out.print(blueAnsi);
    System.out.print(
        "\n" + "    _        _     _    _  _____  _      _____  _____ ___  ___ _____     _        _    \n" + " /\\| |/\\  /\\| |/\\ | |  | ||  ___|| |    /  __ \\|  _  ||  \\/  ||  ___| /\\| |/\\  /\\| |/\\ \n" + " \\ ` ' /  \\ ` ' / | |  | || |__  | |    | /  \\/| | | || .  . || |__   \\ ` ' /  \\ ` ' / \n" + "|_     _||_     _|| |/\\| ||  __| | |    | |    | | | || |\\/| ||  __| |_     _||_     _|\n" + " / , . \\  / , . \\ \\  /\\  /| |___ | |____| \\__/\\\\ \\_/ /| |  | || |___  / , . \\  / , . \\ \n" + " \\/|_|\\/  \\/|_|\\/  \\/  \\/ \\____/ \\_____/ \\____/ \\___/ \\_|  |_/\\____/  \\/|_|\\/  \\/|_|\\/ \n" + "                                                                                       \n" + "                                                                                       \n");
    System.out.print(resetAnsi);
    lineFlowery();
    isSpace();
    System.out.println(boldAnsi + App2.appTitle + resetAnsi);
  }

  public void lineFlowery() {
    for (int i = 0; i < 45; i++) {
      System.out.print(boldAnsi + blueBackAnsi);
      System.out.print("-");
      System.out.print(yellowAnsi + "*" + resetAnsi);
    }
    isSpace();
  }

  public void lineSimple() {
    isSpace();
    for (int i = 0; i < 45; i++) {
      System.out.print(boldAnsi);
      System.out.print("-");
      System.out.print(yellowAnsi + "*" + resetAnsi);
    }
    isSpace();
  }

  public void isSpace() {
    System.out.println();
  }
}


package bitcamp.project1.App.vo;


import bitcamp.project1.App.App;

public class Css {
  public String boldAnsi = "\033[1m";
  public String redAnsi = "\033[31m";
  public String resetAnsi = "\033[0m";
  public String yellowAnsi = "\033[93m";
  public String blueAnsi = "\033[94m";
  public String blueBackAnsi = "\033[44m";


  public void titlePrintCrap() {
    System.out.print("⠂⢆⠢⠢⡂⠖⡰⢐⠢⡂⢆⠢⠢⠢⠢⡂⢺⠠⠢⠢⠢⠢⠢⠢⠢⡂⠲⡐⢢⢂⠒⠔⠔⡰⠐⢔⠠⠢⡐⠔⡠⠢⠐⠔⡐⠔⡐⢔⠐⠔⢔⠐⢔⠐⡔⢐⠔⡐⢔⠐⡔⠰⡐⠔⠔⠔⠔⠔⢔⠰\n");
    System.out.print("⡑⢅⢑⠅⡪⢨⠂⡕⢌⠢⡑⢌⡑⠡⡃⢜⠸⡐⢡⠃⡕⡑⡡⢃⠕⡨⡑⢌⠢⡡⡉⢪⠈⡆⡑⡡⢊⠢⡘⢌⠐⡡⢑⠡⣈⢊⠔⡡⡉⡪⢐⢅⢑⢌⢐⠅⡌⠢⡑⢌⠢⡑⢌⢊⢊⢊⢊⠜⡠⢑\n");
    System.out.print("⠆⡱⢈⠆⢕⠰⡑⢌⠢⡑⢌⠢⣈⠊⡔⢡⠚⢄⠱⡈⢆⠌⡔⠡⡊⢔⢌⠢⡑⠔⢌⠢⡑⠨⡂⢜⠠⡑⢄⠱⡈⠔⡡⠊⠤⡡⠊⠔⢌⢰⢷⢶⣅⠢⡡⢊⠔⡑⢌⣦⠑⡌⢢⠡⡅⡱⠠⡃⢜⠠\n");
    System.out.print("⢕⠨⡂⢕⠡⡊⢔⠡⡊⢔⠌⡢⢂⠑⢌⠂⡝⢠⠑⢌⠢⡘⢄⠣⡘⢔⠐⠕⢌⢊⠢⡁⢪⠈⡢⠑⢌⠢⠑⡌⡐⢅⢐⠉⡢⡈⡊⢪⠀⣿⣳⢯⠣⡈⡢⠡⡊⣾⢯⢷⠎⡨⢂⠕⡰⢈⠆⡱⠐⡅\n");
    System.out.print("⡐⢅⠪⡐⢅⠪⡐⢅⢊⠆⡸⠠⡑⡡⢃⡜⢸⠠⡑⡡⢊⠔⡡⢊⠔⡡⣉⠊⢆⢑⠅⡪⢐⠅⢪⢈⠢⡑⠡⡌⠢⠢⡁⢕⠐⡄⡑⡬⢊⢁⠉⡇⢢⠨⡐⡥⠞⠛⡧⢋⠔⡨⠢⡨⠂⢆⠑⢌⠢⢊\n");
    System.out.print("⠈⡆⡑⢌⠢⡑⢌⠢⡡⢊⠔⡑⢌⠔⡑⢌⢪⠂⡜⢠⠑⡌⠔⡡⢊⠔⢄⠣⡑⢌⠢⡑⠔⡑⢄⠣⡐⢅⢑⠌⢊⠔⡡⠊⠔⢌⡜⠠⠂⠔⡀⡗⡠⣱⠊⡐⡀⠢⢸⠐⡌⡐⡡⢂⢑⠅⡱⢈⠆⡱\n");
    System.out.print("⢎⠰⡈⢆⠑⡌⠢⡑⢌⠢⡑⢌⠢⡑⢌⠢⡱⢁⠎⡰⢁⠎⡰⢁⠆⡱⢈⠆⡑⢌⠢⡑⢌⠢⡑⢌⢐⠅⠢⡡⠑⠔⣈⠊⢌⡞⢀⠌⢂⠡⢰⠃⣴⠁⡐⠄⢌⠀⡟⢨⠐⡌⡐⢅⠢⡑⢄⢑⠌⢄\n");
    System.out.print("⢆⠑⡌⠢⡑⢌⢊⠔⡡⢊⠔⡡⢊⠔⡡⠊⡕⢡⠊⢔⠡⢊⠔⠡⡊⠔⡡⢊⠔⡡⢂⠎⡐⢅⢌⠢⣁⠪⠢⣈⢊⠢⢂⢑⣸⠀⡂⠔⠡⢀⡏⢤⠃⠄⢌⠐⢄⢡⠇⡢⢑⠌⡐⢅⠢⡘⠄⢅⠪ \n");
    System.out.print("⡣⢘⠄⡣⡈⡢⢁⢎⠐⡅⢊⠔⡡⠊⢔⠡⡫⢐⠅⡱⢈⠆⡑⢅⢊⠢⡨⢂⠌⡢⢁⣊⣔⣁⣢⣑⢄⢑⠡⡂⢅⠪⡠⣁⠇⠠⠂⢌⠂⣼⠐⡞⠈⠢⠠⡁⠂⡞⢐⠌⢢⠘⡄⡑⠔⡨⢂⠑⠔⠄\n");
    System.out.print("⡡⠢⡑⠔⡨⢂⠕⡠⠣⡘⢄⠣⡘⢌⠢⣅⢝⠠⡃⢜⠠⡃⢜⠠⡑⢌⠔⢡⡮⢖⣏⢳⠜⡮⡪⣎⢏⢗⢧⣜⠠⡑⢔⢸⠠⡁⡑⠠⢢⠇⢸⠃⡈⢂⠡⡀⣹⠡⡂⢕⠐⡅⠢⡘⠔⡐⠡⡑⠡⢊\n");
    System.out.print("⢆⠱⡈⡪⢐⠅⡊⢔⠑⡌⢢⠑⡌⢢⠑⡢⢹⢀⠣⡘⢄⠣⡘⢄⠣⢢⡵⣫⠚⡡⢂⡑⠔⢌⢘⢮⡪⡳⡕⡮⣳⣅⢆⡟⠀⠢⢈⠂⣼⢈⡞⠠⡈⠔⠠⢂⣇⠢⡊⡔⡡⡊⣢⢘⣄⡱⣁⢎⣘⢄\n");
    System.out.print("⠲⡑⠎⠢⢃⡑⢩⢈⠅⡩⢁⠍⣉⢉⢉⠌⡃⡑⡑⠚⡂⠳⠘⠦⢣⢟⠜⢄⠕⡨⢢⡸⡪⣎⢏⢖⣝⢜⢮⢺⢢⡝⣆⢕⢈⠂⡡⠀⡇⢡⡇⠢⢐⠈⡂⡼⠀⡢⠂⢔⠐⢄⡢⡄⢄⠄⠔⡠⠄⡂\n");
    System.out.print("⠑⢌⠨⡂⠱⡰⢁⠢⡑⢈⠆⢌⠢⠐⠥⡊⠔⡨⡈⢌⠌⡊⢜⠢⣏⢯⠐⡅⠪⡰⣕⢝⢎⣎⢳⢕⢵⡙⣎⢧⠳⣍⢞⢯⣒⣦⡐⠁⡇⢰⡥⠤⡡⡈⢰⠃⠌⡄⢑⠄⡑⢄⠢⠂⠢⡘⠐⠔⡈⠔\n");
    System.out.print("⢃⠊⡔⡈⡒⢄⠑⠔⡨⢂⠪⡠⡁⡃⠪⡐⠡⠢⡈⠆⢌⠢⠢⣸⡣⣗⢬⣨⡪⡳⣜⢕⠧⡳⡱⡫⣎⢞⢜⡎⡳⣕⢝⡺⣿⣿⡇⠨⡇⢸⣿⣿⡷⠀⡞⠠⡡⢈⠢⡈⠢⢂⠌⡊⠔⠨⡈⠢⡈⠢\n");
    System.out.print("⠡⡊⠔⡨⢐⠡⡉⢒⠄⢕⠐⠔⡨⢈⠆⡑⡡⢑⠌⢌⢂⣑⣢⡼⣎⢮⡪⡖⣝⠼⣌⢗⢝⢮⡹⣪⠮⣕⣝⢜⡵⡱⣝⢪⣿⠿⠃⠨⡆⢸⢿⣿⠃⢸⠁⠢⢂⠡⢂⠌⠢⡁⠢⡨⢈⠢⡈⠢⡈⠢\n");
    System.out.print("⠥⡈⢆⠌⢢⢁⠪⡀⠣⡂⡑⢅⠊⣔⣨⠦⢖⣓⣙⠭⡭⠶⠦⢮⡨⢷⡱⡝⣬⠷⠵⠽⢊⢉⠉⣄⣰⢗⡜⣕⢎⢗⢼⣱⠹⡀⠜⠀⡇⢸⠀⠄⠂⡏⢨⠂⡑⢄⠕⡨⢂⠪⡐⢄⠑⢄⠑⢌⠐⡁\n");
    System.out.print("⢌⠢⠂⠜⠠⡂⡑⢌⠢⡨⢂⠊⣴⣓⡮⠭⣝⣒⡮⠭⢝⣛⢮⡦⡓⣆⢻⠊⢡⠐⡐⠡⠂⢅⠊⡧⡳⣱⠉⢮⡓⣝⢲⠃⠠⢳⡈⠂⡇⠼⡀⡑⢈⠇⡐⠅⢌⠂⠢⢂⠅⡢⢨⢀⢃⠢⠑⡠⠡⡈\n");
    System.out.print("⣦⠁⢅⠑⡡⢨⠐⡅⢒⠐⢅⢼⢓⣚⡬⡭⠼⢒⡺⣭⣩⠔⡕⣜⣝⣜⢎⢗⠠⡑⡈⡊⣸⡏⣯⠹⠜⣁⠊⣷⣽⣮⢋⢈⠢⠂⢧⡈⢹⣀⡧⢈⢸⢈⠔⡁⠢⡑⢡⠑⢌⠰⡠⠡⢂⠡⠊⠠⠂⡐\n");
    System.out.print("⣿⠀⠢⡁⠔⡡⡈⡢⠡⡑⠂⠺⣍⠢⠲⢼⡚⣓⡯⡵⣓⢞⢶⢬⡪⣮⢞⡞⡆⠔⡬⡪⢭⣍⣙⡒⡳⠴⢵⡵⠊⠻⠻⢷⣬⣦⣡⠷⡺⣍⢷⠀⣽⢲⣤⠑⡡⠊⡄⠱⡠⢑⠐⠅⠢⡐⠡⡈⡐⢀\n");
    System.out.print("⠗⡈⠢⡈⠢⡐⢌⠐⢅⠌⡊⠢⣈⠙⣕⣭⢻⢍⢮⢮⡪⣣⢳⢕⡇⢳⣎⣾⢱⡮⠮⠢⡻⢪⣭⠓⡕⡱⢞⣀⢊⠄⢅⠌⣡⢟⢗⢝⢮⢪⢮⡹⣱⡣⣝⢝⡳⡌⡐⡡⠂⢅⠊⢌⠂⠢⠂⠔⡈⢄\n");
    System.out.print("⣄⣕⣠⣈⠢⡈⠢⡑⠔⡨⡈⠆⢔⢁⡾⡱⢁⠆⡢⢳⡱⡕⢧⣻⡘⡢⢷⡼⣿⠪⣹⢆⡙⡦⢢⡽⢊⡵⢕⢛⡦⢈⢂⠘⢷⡽⣮⢷⡵⣷⡻⣽⡽⣝⡿⡜⢮⢧⣼⡀⠕⡠⠃⠔⡁⡑⠡⡈⠄⢂\n");
    System.out.print("⣿⣿⣿⣿⣿⣾⣶⠈⡢⠢⡈⡪⢀⡿⣸⢁⠕⡨⢂⢗⢵⡹⡪⢖⣽⠢⡚⣵⣿⠛⠺⢎⣱⡳⣋⢔⣫⢴⠋⡁⡐⢄⠡⢊⣸⣟⣵⣟⡽⣞⣽⢞⣽⢾⡽⣏⢞⢖⡜⣧⠨⡐⠡⠊⠄⢌⠐⢄⠑⠄\n");
    System.out.print("⣿⣿⣿⣿⣿⣿⡏⢔⠨⡂⠱⡀⢹⡪⡳⢠⠃⡜⢰⢇⢷⡸⡹⣪⢺⣜⢈⢿⣿⢙⡋⣱⡪⣎⡕⢻⡱⡏⠐⢄⠌⢄⠒⣠⡿⣮⢷⡽⣺⢯⡞⢯⢳⢟⣾⢱⢝⡪⣎⢞⠶⡌⡈⡊⡐⡁⡊⠔⣁⠑\n");
    System.out.print("⣿⣯⣿⣷⣿⣿⣏⠰⠠⡑⠡⡊⢸⡕⣯⠐⢅⠊⡮⡳⡱⣕⢝⡬⡳⣜⢇⢹⡿⣠⡟⣫⢞⠁⢯⣟⢬⣇⡼⡦⣔⣂⣶⣟⡽⣞⠧⡫⡸⢅⠳⣡⣣⢝⡵⡱⣣⢳⢜⢵⡙⣇⠨⡐⠌⡐⡈⠢⡠⡁\n");
    System.out.print("⣿⣿⣿⣯⣿⣾⣷⣌⣆⣑⡡⡨⡈⡷⣜⡌⢢⠑⡯⡪⡳⣜⢕⢵⢕⢭⡓⣿⣿⢫⡞⣱⠃⠜⡦⡷⣹⢮⢪⢞⡜⡬⡵⣩⡛⡞⣖⢳⡚⣏⡫⡕⡮⣪⢎⢮⢣⢳⢕⡧⠝⠛⡄⠢⡈⠢⡘⢐⠐⠄\n");
    System.out.print("⣿⣷⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⢀⠹⣎⢞⢦⡫⡺⡱⣕⢵⡹⣌⢗⢵⡙⣖⠼⡲⣙⢮⢌⣞⠞⡟⡏⠲⢏⡶⣙⢎⡞⢼⢜⢵⡱⡝⣪⢎⢞⢎⢾⣰⣧⠯⠓⡩⡁⢆⠩⡊⡹⡈⢌⠢⡐⡁⢊⠔\n");
    System.out.print("⣿⣯⣿⣿⣿⣿⣾⣿⣻⣟⣿⣿⠠⠡⡘⢧⡳⡹⡜⡵⡱⡕⡮⣪⢣⡣⣏⢼⡱⡫⣪⢣⢧⣫⢊⢄⢹⣈⠖⢋⠗⠵⣝⠵⡓⡓⡚⢚⠓⡋⢋⡩⠕⡊⠤⢂⣕⠬⢔⠡⡊⠔⠔⡹⡀⠆⡰⢈⠢⠐\n");
    System.out.print("⡙⠛⠿⣻⣷⣿⣿⣻⣿⢿⣿⣿⠘⡂⠢⢂⠙⠾⣸⡪⣓⢝⢎⢮⢕⡵⡪⣎⢮⡳⠵⣣⢳⡹⡲⣅⠢⡑⢌⠢⣇⡠⢊⠔⡙⣬⢈⡪⠼⠊⡍⠢⣱⠜⡚⠩⡠⢊⠢⡑⡌⢊⠪⡐⢹⡐⢐⠄⡑⠡\n");
    System.out.print("⠈⠁⠒⠠⢈⡉⠙⠻⠿⣿⣻⣿⠌⡨⢊⢐⠡⢂⠄⡉⠙⠚⠳⠵⠧⠺⠓⠪⡡⣢⢦⠞⡑⠷⣹⢜⠻⡦⣑⠅⡩⢐⠅⡪⢐⢌⠱⡈⡢⢃⠪⢸⡅⣬⠨⡂⢕⠨⣢⢋⠌⢜⠄⡱⣡⢗⣷⠠⡑⠡\n");
    System.out.print("⠀⠀⠀⠀⠀⠀⠁⠂⠀⠤⠤⢉⢑⢂⠑⠤⠕⢄⣊⢄⣑⢁⠒⠠⠂⢌⠊⠢⡀⣳⣕⡻⡲⣥⣈⠝⢫⣮⣙⢗⢮⡐⢅⠪⡐⢅⠪⡐⣅⣪⠶⣫⡹⡞⠎⢔⡕⢋⠤⢑⢌⣢⢗⢏⣳⣽⣧⠐⢌⠌\n");
    System.out.print("⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠐⠐⠂⠣⠩⠡⠱⠠⠃⠣⠜⠟⠟⠿⠞⠜⢍⠻⠲⢤⠙⠮⠓⠝⠳⠌⠦⢵⠚⠭⠳⠼⢓⠍⡔⣌⠫⠅⠮⠔⠓⠍⠍⠪⠛⠟⠟⠻⠛⠧⠲⠘\n");
    System.out.print("⡴⣄⡄⡀⠀⠁⠀⠁⠀⠀⠀⠀⠀⠀⠀⡀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⢀⠀⢀⠀⠄⢀⠀⠔⠐⠠⠈⠄⢑⠈⡐⢁⠌⠠⠑⡀⠆⡐⢁\n");
    System.out.print("⠒⠴⠌⣍⢫⠒⠶⠤⡤⣀⣁⠀⠈⠀⠀⠀⠀⠀⠀⠁⠀⠂⠀⡀⠀⡀⠀⠀⢀⠀⢀⠀⠀⠂⠀⠄⠀⠄⠀⠀⠂⢀⠀⠠⠀⠁⢀⠀⡀⠀⠄⠐⠀⡐⠀⠅⡈⠠⠁⠄⠨⢀⠂⡐⠡⠈⠄⠌⠠⢁\n");
    System.out.print("⠀⠀⠀⠀⠀⠁⠉⠊⠂⠪⠌⢍⡋⣚⢒⠳⠔⠬⠤⢤⢤⣠⣀⣀⢀⠀⠀⠄⠀⠀⠀⠀⠠⠀⠀⢀⠀⢀⠀⠁⢀⠀⢀⠀⠀⠂⠀⠀⢀⠀⡀⠐⠀⠀⠂⠠⠀⠂⠐⠈⠀⠂⠀⠐⠀⠁⠂⡈⠐⡠\n");
    System.out.print("⡀⡀⣂⢀⣀⣀⣀⣀⣀⣀⢀⡀⣀⢀⡁⣁⢉⢊⢊⢂⣢⣂⢦⣨⣑⣍⣙⣉⣓⣙⣒⣓⣒⣒⣒⣒⣒⣒⣒⣒⣢⣒⣒⣒⣒⣒⣦⣱⣤⣢⣒⣒⣲⣒⣖⣲⣚⣒⣓⣚⣪⣚⣊⣳⣩⣫⣍⣍⣝⣘\n");
    isSpace();
  }

  public void titlePrint() {
    lineFlowery();
    System.out.print(blueAnsi);
    System.out.print(
        "\n" + "    _        _     _    _  _____  _      _____  _____ ___  ___ _____     _        _    \n" + " /\\| |/\\  /\\| |/\\ | |  | ||  ___|| |    /  __ \\|  _  ||  \\/  ||  ___| /\\| |/\\  /\\| |/\\ \n" + " \\ ` ' /  \\ ` ' / | |  | || |__  | |    | /  \\/| | | || .  . || |__   \\ ` ' /  \\ ` ' / \n" + "|_     _||_     _|| |/\\| ||  __| | |    | |    | | | || |\\/| ||  __| |_     _||_     _|\n" + " / , . \\  / , . \\ \\  /\\  /| |___ | |____| \\__/\\\\ \\_/ /| |  | || |___  / , . \\  / , . \\ \n" + " \\/|_|\\/  \\/|_|\\/  \\/  \\/ \\____/ \\_____/ \\____/ \\___/ \\_|  |_/\\____/  \\/|_|\\/  \\/|_|\\/ \n" + "                                                                                       \n" + "                                                                                       \n");
    System.out.print(resetAnsi);
    lineFlowery();
    isSpace();
    System.out.println(boldAnsi + App.getAppTitle() + resetAnsi);
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


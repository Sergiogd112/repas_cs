import java.util.Scanner;
class Main {
  public static void spacer() {
    String spacer=">>>";
    System.out.print(spacer);
  }
  public static void help() {
    String x="a add a product\n"+
             "r remove a product\n"+
             "h show this menu\n"+
             "s stores the register\n"+
             "p prints the register\n";
    System.out.print(x);
  }
  public static void main(String[] args) {
    System.out.println("starting the manager...");
    //Main.spacer();
    Scanner input = new Scanner(System.in);
    Manager manager =new Manager();
    while(true){
      String s = input.nextLine();
      System.out.println(s);
      switch (s) {
        case "quit":
          break;
        case "add":
          manager.addcli();
          break;
        case "print":
          manager.printt();
          break;
        case "save":
          manager.save();
          break;
        default:
          Main.help();
      }
    }
  }
}

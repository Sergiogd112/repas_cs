import java.util.Scanner;
class Main {
  public static void spacer() {
    String spacer=">>>";
    System.out.print(spacer);
  }
  public static void help() {
    String x="add add a product\n"+
             "rem remove a product\n"+
             "help show this menu\n"+
             "save stores the register\n"+
             "print prints the register\n";
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
        case "load":
          manager.load();
          break;
        default:
          Main.help();
      }
    }
  }
}

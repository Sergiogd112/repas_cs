import java.util.Scanner;

class Main {
  public static void spacer() {
    String spacer = ">>>";
    System.out.print(spacer);
  }

  public static void main(String[] args) {
    String starter = "We recomend to load first and the start with the modifcations if you have already use the software. When finshed tipe save.\n";
    System.out.println("\nstarting the manager...\n");
    // Main.spacer();
    System.out.println("manager started\n");
    Manager.help();
    System.out.println(starter);
    Manager manager = new Manager();
    // Manager.initParsers();
    manager.mainLoop();
  }

}

class Main {
  public static void main(String[] args) {
    String name = "tv";
    String description = "Anim reprehenderit sunt consectetur mollit incididunt nostrud occaecat esse sunt exercitation dolor irure culpa. Sint duis et officia id est voluptate ad est irure elit eiusmod quis laboris. Reprehenderit laborum esse ullamco anim. Eu proident elit adipisicing occaecat dolor duis veniam officia aliquip culpa duis ex fugiat.";
    float cost = 34912;
    float size = 90.11f;
    int stock = 10;
    Screen tv = new Screen(name, size, cost, stock, description);
    System.out.println("help");
    System.out.println(tv.getsize());
  }
}

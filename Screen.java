import java.util.function.Function;

class Screen extends Product {
    private float size;
    public static final String type = "screen";

    public Screen() {
        super.productType = Screen.type;
    }

    public static void initParser() {
        Function f = (text) -> Screen.fromString((String[]) text);
        Product.addParser(Screen.type, f);
    }

    public Screen(String name, float size, float cost, int stock, String description, int n) {
        super.productType = Screen.type;
        this.setName(name);
        this.size = size;
        this.setCost(cost);
        this.setStock(stock);
        this.setDescription(description);
        super.index = n;
        super.counter += 1;
    }

    public float getsize() {
        return this.size;
    }

    public String toString() {
        return super.toString() + Product.field_delimiter + Float.toString(this.size);
    }

    protected static Screen fromString(String[] text) {
        return new Screen(text[1], Float.parseFloat(text[5]), Float.parseFloat(text[4]), Integer.parseInt(text[3]),
                text[2], Product.counter);
    }

    public void printdata() {
        super.printdata();
        System.out.println("Size: " + String.valueOf(this.size));
    }
}
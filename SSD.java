import java.util.function.Function;

class SSD extends Product {
    private float size;
    public static final String type = "ssd";

    public SSD() {
        super.productType = SSD.type;
    }

    public static void initParser() {
        Function f = (text) -> SSD.fromString((String[]) text);
        Product.addParser(SSD.type, f);
    }

    public SSD(String name, float size, float cost, int stock, String description, int n) {
        super.productType = SSD.type;
        this.setName(name);
        this.size = size;
        this.setCost(cost);
        this.setStock(stock);
        this.setDescription(description);
        super.index = n;
        super.counter += 1;
    }

    public String toString() {
        return super.toString() + Product.field_delimiter + Float.toString(this.size);
    }

    protected static SSD fromString(String[] text) {
        return new SSD(text[1], Float.parseFloat(text[5]), Float.parseFloat(text[4]), Integer.parseInt(text[3]),
                text[2], Product.counter);
    }

    public void printdata() {
        super.printdata();
        System.out.println("Size: " + String.valueOf(this.size));
    }
}
import java.util.function.Function;

class Mouse extends Periferal {
    private float pullrate;
    private boolean wireless;
    public static final String type = "mouse";

    public Mouse() {
        super.productType = Mouse.type;
    }

    public static void initParser() {
        Function f = (text) -> Mouse.fromString((String[]) text);
        Product.addParser(Mouse.type, f);
    }

    public Mouse(String name, float pullrate, float cost, int stock, String description, boolean wireless, int n) {
        super.productType = Mouse.type;
        this.setName(name);
        this.setCost(cost);
        this.setStock(stock);
        this.setDescription(description);
        this.pullrate = pullrate;
        this.wireless = wireless;
        super.index = n;
        super.counter += 1;
    }

    public String toString() {
        return super.toString() + Product.field_delimiter + Float.toString(this.pullrate) + Product.field_delimiter
                + Boolean.toString(this.wireless);
    }

    protected static Mouse fromString(String[] text) {
        return new Mouse(text[1], Float.parseFloat(text[5]), Float.parseFloat(text[4]), Integer.parseInt(text[3]),
                text[2], Boolean.parseBoolean(text[6]), Product.counter);
    }

    public void printdata() {
        super.printdata();
        System.out.println("Pullrate: " + String.valueOf(this.pullrate));
        System.out.println("Wireless: " + String.valueOf(this.wireless));
    }
}
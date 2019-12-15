import java.util.function.Function;

class HardDrive extends Product {
    private float size;
    public static final String type = "hdd";

    public HardDrive() {
        super.productType = HardDrive.type;
    }

    public static void initParser() {
        Function f = (text) -> HardDrive.fromString((String[]) text);
        Product.addParser(HardDrive.type, f);
    }

    public HardDrive(String name, float size, float cost, int stock, String description, int n) {
        super.productType = HardDrive.type;
        this.setName(name);
        this.size = size;
        this.setCost(cost);
        this.setStock(stock);
        this.setDescription(description);
        super.index = n;
        super.counter += 1;
    }

    public String tostring() {
        return super.toString() + Product.field_delimiter + Float.toString(this.size);
    }

    public static HardDrive fromString(String[] data) {
        return new HardDrive(data[0], Float.parseFloat(data[4]), Float.parseFloat(data[3]), Integer.parseInt(data[2]),
                data[1], Product.counter);

    }

    public void printdata() {
        super.printdata();
        System.out.println("Size: " + String.valueOf(this.size));
    }
}
import java.util.function.Function;

class Cpu extends Product {
    private float clockspeed;
    private int cores;
    public static final String type = "cpu";

    public Cpu() {
        super.productType = Cpu.type;
    }

    public static void initParser() {
        Function f = (text) -> Cpu.fromString((String[]) text);
        Product.addParser(Cpu.type, f);
    }

    public Cpu(String name, int cores, float cost, int stock, String description, float clockspeed, int n) {
        super.productType = Cpu.type;
        this.cores = cores;
        this.clockspeed = clockspeed;
        this.setName(name);
        this.setCost(cost);
        this.setStock(stock);
        this.setDescription(description);
        super.index = n;
        super.counter += 1;
    }

    public String toString() {
        return super.toString() + Product.field_delimiter + String.valueOf(this.cores) + Product.field_delimiter
                + String.valueOf(this.clockspeed);
    }

    protected static Cpu fromString(String[] text) {
        return new Cpu(text[1], Integer.parseInt(text[5]), Float.parseFloat(text[4]), Integer.parseInt(text[3]),
                text[2], Float.parseFloat(text[6]), Product.counter);
    }

    public void printdata() {
        super.printdata();
        System.out.println("Cores: " + String.valueOf(this.cores));
        System.out.println("Clockspeed: " + String.valueOf(this.clockspeed));
    }
}
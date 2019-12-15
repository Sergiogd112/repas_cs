import java.util.function.Function;

class Periferal extends Product {
    private String subType;
    public static final String type = "periferal";

    public Periferal() {
        super.productType = Periferal.type;
    }

    public static void initParser() {
        Function f = (text) -> Periferal.fromString((String[]) text);
        Product.addParser(Periferal.type, f);
    }

    public String toString() {
        return super.toString();
    }

    public void printdata() {
        super.printdata();
    }
}
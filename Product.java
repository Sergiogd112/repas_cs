import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;
import java.util.Comparator;

class Product {
    private String name;
    public static int counter = 0;
    private String description;
    private int stock;
    private float cost;
    public static final String type = "";
    public String productType;
    public static final String field_delimiter = "\u001f";
    public static final String product_delimiter = "\u001e";
    private static final HashMap<String, Function<String[], Product>> parsers = new HashMap<>();
    protected int index = 0;

    public Product() {
        productType = Product.type;
    }

    public static void initParser() {
        Function<String[], Product> f = (text) -> Product.fromString((String[]) text);
        Product.addParser(Product.type, f);
    }

    public String getType() {
        return this.productType;
    }

    public int getIndex() {
        return this.index;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public float getCost() {
        return this.cost;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String toString() {
        return this.getType() + Product.field_delimiter + this.getName() + Product.field_delimiter
                + this.getDescription() + Product.field_delimiter + String.valueOf(this.getStock())
                + Product.field_delimiter + String.valueOf(this.getCost());
    }

    public static void addParser(String type, Function<String[], Product> value) {
        parsers.put(type, value);
    }

    public static Product fromString(String text, Manager manager) {
        String type = text.split(Product.field_delimiter)[0];
        String[] data = text.split(Product.field_delimiter);
        manager.setCharl(data[1].length(), data[2].length(), data[0].length(), data[3].length(), data[4].length(),
                String.valueOf(Product.counter).length());
        Function<String[], Product> parser = Product.parsers.get(type);
        Product product = null;
        try {
            product = parser.apply(data);
        } catch (Exception iae) {
            System.err.print(iae);
            System.exit(-1);
        }
        return product;
    }

    protected static Product fromString(String[] text) {
        Product p = new Product();
        p.name = text[1];
        p.description = text[2];
        p.stock = Integer.parseInt(text[3]);
        p.cost = Float.parseFloat(text[4]);
        return p;
    }

    public static Comparator<Product> comparator(int parameter) {

        return new Comparator<Product>() {

            @Override
            // Compare values according to columns
            public int compare(Product entry1, Product entry2) {
                // To sort in descending order revert
                // the '>' Operator
                int result;
                switch (parameter) {
                case 0:
                    result = entry1.getType().compareTo(entry2.getType());
                    break;
                case 1:
                    result = entry1.getName().compareTo(entry2.getName());
                    break;
                case 2:
                    result = Integer.compare(entry1.getStock(), entry2.getStock());
                    break;
                case 3:
                    result = Float.compare(entry1.getCost(), entry2.getCost());
                    break;
                default:
                    result = 0;
                }
                return result;
            }
        };
    }

    public void printdata() {
        System.out.print("ID: ");
        System.out.println(this.index);
        System.out.println("Name: " + this.name);
        System.out.println("Description: \n\n" + this.description);
        System.out.println("Stock: " + String.valueOf(this.stock));
        System.out.println("Cost: " + String.valueOf(this.cost));
    }

    public void modify() {
        System.out.println("Modify:[Name,Cost,Stock,Description]");
        Scanner input = new Scanner(System.in);
        String mode = input.nextLine();
        switch (mode) {
        case "Name":
            this.name = input.nextLine();
            break;
        case "Description":
            String description = "";
            String line;
            int n = 0;
            while (n < 1) {
                line = input.nextLine();
                System.out.println(line.length());
                System.out.println(n);
                if (line.length() == 0) {
                    n += 1;
                } else {
                    n = 0;
                    description += line + "\n";
                }
            }
            this.description = description;
            break;
        case "Cost":
            this.cost = Float.parseFloat(input.nextLine());
            break;
        case "Stock":
            this.stock = Integer.parseInt(input.nextLine());
            break;
        default:
            System.out.println("Something went wrong");
        }
    }
}
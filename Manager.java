import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class Manager {

    private Product[] products = new Product[0];
    private int[] charl = { 6, 6, 7, 5, 3 };
    private static String dataFile = "data.txt";

    static {
        Product.initParser();
        Periferal.initParser();
        HardDrive.initParser();
        SSD.initParser();
        Screen.initParser();
        Mouse.initParser();
        Cpu.initParser();
    }

    public static void help() {
        String x = "add        add a product\n" + "remove     remove a product\n" + "help       show this menu\n"
                + "save       stores the register\n" + "print      prints the register\n"
                + "quit       exit the program\n" + "select     shows info of a product\n"
                + "modify     modify an atribute of a product\n\n";
        System.out.print(x);
    }

    public void mainLoop() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(">>>");
            String s = input.nextLine();
            switch (s) {
            case "quit":
                System.exit(0);
                break;
            case "add":
                this.addcli();
                break;
            case "print":
                this.printt();
                break;
            case "save":
                this.save();
                break;
            case "load":
                this.load();
                break;
            case "select":
                this.select();
                break;
            case "modify":
                this.modify();
                break;
            case "remove":
                this.remove();
                break;
            default:
                Manager.help();
            }
        }
    }

    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String[] mysplitter(String text, String sep) {
        int[][] pos = getpos(text, sep);
        String[] splited = new String[pos.length];
        for (int i = 0; i < pos.length; i++) {
            if (i <= 0) {
                splited[i] = text.substring(0, pos[i][0] - 1);
            } else {
                splited[i] = text.substring(pos[i - 1][1] + 1, pos[i][0] - 1);
            }

        }
        return splited;
    }

    public static Product[] removeTheElement(Product[] arr, int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0 || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        Product[] anotherArray = new Product[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public static void main(String[] argv) {

    }

    public static int[][] getpos(String text, String sub) {
        int start = 0;
        int end = 0;
        int[] temp = new int[2];
        String temp_txt = new String(text);
        int cnt = 0;
        while (true) {
            int idx = temp_txt.indexOf(sub);
            if (idx < 0) {
                break;
            }
            cnt++;
            temp_txt = temp_txt.substring(idx + sub.length());
        }
        int[][] result = new int[cnt][2];
        temp_txt = text;
        cnt = 0;
        while (true) {
            int idx = temp_txt.indexOf(sub);
            if (idx < 0) {
                return result;
            }
            result[cnt][0] = idx;
            int end_idx = idx + sub.length();
            cnt++;
            temp_txt = temp_txt.substring(end_idx);
        }
    }

    public static Product[] addX(Product arr[], Product x) {
        // create a new array of size n+1
        Product newarr[] = Arrays.copyOf(arr, arr.length + 1);

        newarr[arr.length] = x;

        return newarr;
    }

    public static void sortbyColumn(Product[] products, int parameter) {
        // Using built-in sort function Arrays.sort
        Arrays.sort(products, Product.comparator(parameter)); // End of function call sort().
    }

    public Product[] sortby(String mode) {
        Product[] list = this.products;
        String[][] tempList = new String[list.length][2];
        Product[] outlist = Arrays.copyOf(this.products, this.products.length);
        switch (mode) {
        case "Cost":
            this.sortbyColumn(outlist, 3);
            break;
        case "Name":
            this.sortbyColumn(outlist, 1);
            break;
        case "Type":
            this.sortbyColumn(outlist, 0);
            break;
        case "Stock":
            this.sortbyColumn(outlist, 2);
            break;
        case "None":
            break;
        default:
            System.out.println("Mode not found");
        }
        return outlist;
    }

    public Product[] sort_by_original(String[][] list) {
        Product[] sorted = new Product[this.products.length];
        for (int i = 0; i < this.products.length; i++) {
            sorted[i] = this.products[Integer.parseInt(list[i][1])];
        }
        return sorted;
    }

    public void addcli() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type?[CPU,Screen,Mouse,HDD,SSD]");
        String type = input.nextLine().toLowerCase();
        if (type.length() > charl[3]) {
            charl[3] = type.length();
        }
        System.out.println("Name:");
        String name = input.nextLine();
        if (name.length() > charl[0]) {
            charl[0] = type.length();
        }
        System.out.println("Description");
        int n = 0;
        String description = "";
        String line;
        while (n < 1) {
            line = input.nextLine();
            if (line.equals("")) {
                n += 1;
            } else {
                n = 0;
                description += line + "\n";
            }
        }

        System.out.println("Stock:");
        int stock = Integer.parseInt(input.nextLine());
        if (String.valueOf(stock).length() > charl[3]) {
            charl[2] = String.valueOf(stock).length();
        }
        System.out.println("Cost:");
        float cost = Float.parseFloat(input.nextLine());
        if (String.valueOf(cost).length() > charl[1]) {
            charl[1] = String.valueOf(cost).length();
        }
        if (charl[4] < String.valueOf(Product.counter).length()) {
            charl[4] = String.valueOf(Product.counter).length();
        }
        Product product = new Product();
        float size;
        switch (type) {
        case "cpu":
            System.out.println("Clockspeed:");
            float clockspeed = Float.parseFloat(input.nextLine());
            System.out.println("Cores:");
            int cores = Integer.parseInt(input.nextLine());
            product = new Cpu(name, cores, cost, stock, description, clockspeed, Product.counter);
            break;
        case "screen":
            System.out.println("Size:");
            size = Float.parseFloat(input.nextLine());
            product = new Screen(name, size, cost, stock, description, Product.counter);
            break;
        case "mouse":
            System.out.println("Pullrate:");
            float pullrate = Float.parseFloat(input.nextLine());
            System.out.println("Wireless:[0,1]");
            boolean wireless = Boolean.parseBoolean(input.nextLine());
            product = new Periferal();
            product = new Mouse(name, pullrate, cost, stock, description, wireless, Product.counter);
            break;

        case "hdd":
            System.out.println("Size:");
            size = Float.parseFloat(input.nextLine());
            product = new HardDrive(name, size, cost, stock, description, Product.counter);
            break;
        case "ssd":
            System.out.println("Size:");
            size = Float.parseFloat(input.nextLine());
            product = new SSD(name, size, cost, stock, description, Product.counter);
            break;
        default:
            System.out.println("Unknown product type");
            break;

        }
        try {
            this.products = Manager.addX(products, product);

        } catch (Exception e) {
            System.out.println("Something failed");
        }

    }

    public void printt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sort by:[Name,Cost,Stock,Type]");
        String s = input.nextLine();
        Product[] ls = sortby(s);
        String lim = "+" + stringMultiply("-", this.charl[4]) + "+" + stringMultiply("-", this.charl[0]) + "+"
                + stringMultiply("-", this.charl[1]) + "+" + stringMultiply("-", this.charl[2]) + "+"
                + stringMultiply("-", this.charl[3]) + "+\n";
        String top = lim + "| ID" + stringMultiply(" ", this.charl[4] - 3) + "| Name"
                + stringMultiply(" ", this.charl[0] - 5) + "| Cost" + stringMultiply(" ", this.charl[1] - 5) + "| Stock"
                + stringMultiply(" ", this.charl[2] - 6) + "| Type" + stringMultiply(" ", this.charl[3] - 5) + "|\n"
                + lim;
        System.out.print(top);
        for (int i = 0; i < ls.length; i++) {
            System.out.print("| " + String.valueOf(ls[i].getIndex())
                    + stringMultiply(" ", this.charl[4] - String.valueOf(ls[i].getIndex()).length() - 1) + "| "
                    + ls[i].getName() + stringMultiply(" ", this.charl[0] - ls[i].getName().length() - 1) + "| "
                    + String.valueOf(ls[i].getCost())
                    + stringMultiply(" ", this.charl[1] - String.valueOf(ls[i].getCost()).length() - 1) + "| "
                    + String.valueOf(ls[i].getStock())
                    + stringMultiply(" ", this.charl[2] - String.valueOf(ls[i].getStock()).length() - 1) + "| "
                    + ls[i].getType() + stringMultiply(" ", this.charl[3] - ls[i].getType().length() - 1) + "|\n"
                    + lim);
        }
    }

    public void save() {
        String fileContent = "";

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].toString());
            fileContent += products[i].toString() + Product.product_delimiter;
        }
        System.out.print("Filecontent: ");
        System.out.println(fileContent);
        try {
            FileWriter fileWriter = new FileWriter("data.txt");
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }

    /**
     * @param charl the charl to set
     */
    public void setCharl(int n, int d, int t, int s, int c, int id) {
        int[] temp = new int[] { n + 1, c + 1, s + 1, t + 1, id + 1 };
        for (int i = 0; i < this.charl.length; i++) {
            if (charl[i] < temp[i]) {
                charl[i] = temp[i];
            }
        }
    }

    public void load() {
        Product.counter = 0;
        this.products = new Product[0];
        String rawdata = "";
        String[] spliteddata = new String[1];
        try {
            File file = new File(Manager.dataFile);
            Scanner sc = new Scanner(file).useDelimiter(Product.product_delimiter);
            // we just need to use \\Z as delimiter

            while (sc.hasNext()) {
                rawdata = sc.next();
                products = Manager.addX(products, Product.fromString(rawdata, this));

            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public int select() {
        System.out.println("ID:");
        Scanner input = new Scanner(System.in);
        int id = Integer.parseInt(input.nextLine());
        products[id].printdata();
        return id;

    }

    public void modify() {
        int id = select();
        products[id].modify();
    }

    public void remove() {
        int id = select();
        Scanner input = new Scanner(System.in);
        System.out.println("are you sure?[y/[n]]");
        String chose = input.nextLine();
        if (chose.equals("y")) {
            this.products = Manager.removeTheElement(this.products, id);
        } else {
            System.out.println("Operation dismissed");
        }
    }
}
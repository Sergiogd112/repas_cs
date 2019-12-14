import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;

class Manager {

    private Product[] products = new Product[0];
    private int[] charl = { 5, 5, 6, 5 };

    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String[] mysplitter(String text, String sep) {
        int[][] pos=getpos(text, sep);
        String[] splited=new String[pos.length];
        for(int i = 0; i < pos.length; i++){
            if (i<=0) {
                splited[i]=text.substring( 0, pos[i][0]-1);
            } else {
                splited[i]=text.substring(pos[i-1][1]+1, pos[i][0]-1);
            }
            
        }
        return splited;
    }
    public static void main(String[] argv) {
        
    }

    public static int[][] getpos(String text, String sub) {
        int start=0;
        int end=0;
        int[] temp = new int[2];
        String temp_txt = new String(text);
        int cnt = 0;
        while(true) {
            int idx = temp_txt.indexOf(sub);
            if (idx < 0) {
                break;
            }
            cnt ++;
            temp_txt = temp_txt.substring(idx + sub.length());
        }
        int[][] result = new int[cnt][2];
        temp_txt = text;
        cnt=0;
        while(true) {
            int idx = temp_txt.indexOf(sub);
            if (idx < 0) {
                return result;
            }
            result[cnt][0] = idx;
            int end_idx = idx + sub.length();
            cnt ++;
            temp_txt = temp_txt.substring(end_idx);
        }
    }

    public static Product[] addX(int n, Product arr[], Product x) {
        int i;

        // create a new array of size n+1
        Product newarr[] = new Product[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static int[][] addX(int n, int arr[][], int x[]) {
        int i;

        // create a new array of size n+1
        int newarr[][] = new int[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static void sortbyColumn(String arr[][], int col) {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<String[]>() {

            @Override
            // Compare values according to columns
            public String compare(final String[] entry1, final String[] entry2) {

                // To sort in descending order revert
                // the '>' Operator

                if (entry1[col].length() > entry2[col].length()) {
                    for (int i = 0; i < entry2[col].length(); i++) {
                        if (entry1[col][i] > entry2[col][i]) {
                            return 1;
                        } else if (entry1[col][i] < entry2[col][i]) {
                            return -1;
                        }
                    }
                    return 1;
                } else {
                    for (int i = 0; i < entry1[col].length(); i++) {
                        if (entry1[col][i] > entry2[col][i]) {
                            return 1;
                        } else if (entry1[col][i] < entry2[col][i]) {
                            return -1;
                        }
                    }
                }
            }
        }); // End of function call sort().
    }

    public Product[] sortby(String mode){
        Product[] list=this.products;
        String[][] tempList= new String[list.length][2];
        Product[] outlist=new Product[list.length];
        switch (mode) {
            case "Cost":

                for(int i=0;i<list.length;i++){
                    tempList[i][0]=String.valueOf(list[i].get_cost());
                    tempList[i][1]=String.valueOf(i);
                }
                sortbyColumn(tempList,0);
                for (int i = 0; i < tempList.length; i++) { 
                     oulist[i]=list[list[i][1]]
                }
                break;
            case "Name":
                String[][] lists2= new String[list.length][];
                for(int i=0;i<list.length;i++){
                    tempList[i][0]=list[i].get_name();
                    tempList[i][1]=String.valueOf(i);
                }
                sortbyColumn(tempList,0);
                for (int i = 0; i < tempList.length; i++) { 
                    oulist[i]=list[list[i][1]]
               } 
               break;
            case "Type":
                for(int i=0;i<list.length;i++){
                    tempList[i][0]=String.valueOf(list[i].get_cost());
                    tempList[i][1]=String.valueOf(i);
                }
                sortbyColumn(tempList,0);
                for (int i = 0; i < tempList.length; i++) { 
                    oulist[i]=list[list[i][1]]
                }
                break; 
            case "Stock":
                for(int i=0;i<list.length;i++){
                    tempList[i][0]=String.valueOf(list[i].get_cost());
                    tempList[i][1]=String.valueOf(i);
                }
                sortbyColumn(tempList,0);
                for (int i = 0; i < tempList.length; i++) { 
                    oulist[i]=list[list[i][1]]
                }
                break; 
            default:
                System.out.println("Mode not found");
        }
        return outlist;
        
    }

    public Product[] sort_by_original(String[][] list) {
        Product[] sorted = new Product[this.products.length];
        for (int i; i < this.products.length; i++) {
            sorted[i] = this.products[Integer.parseInt(list[i][1])];
        }
        return sorted;
    }

    public void addcli() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type?[CPU,Screen,Mouse,HardDrive,SSD]");
        String type = input.nextLine();
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
        Product product = new Product();
        float size;
        switch (type) {
        case "CPU":
            System.out.println("Clockspeed:");
            float clockspeed = Float.parseFloat(input.nextLine());
            System.out.println("Cores:");
            int cores = Integer.parseInt(input.nextLine());
            product = new Cpu(name, cores, cost, stock, description, clockspeed);
            break;
        case "Screen":
            System.out.println("Size:");
            size = Float.parseFloat(input.nextLine());
            product = new Screen(name, size, cost, stock, description);
            break;
        case "Mouse":
            System.out.println("Pullrate:");
            float pullrate = Float.parseFloat(input.nextLine());
            System.out.println("Wireless:[0,1]");
            boolean wireless = Boolean.parseBoolean(input.nextLine());
            product = new Periferal();
            product = new Mouse(name, pullrate, cost, stock, description, wireless);
            break;

        case "HardDrive":
            System.out.println("Size:");
            size = Float.parseFloat(input.nextLine());
            product = new HardDrive(name, size, cost, stock, description);
            break;
        case "SSD":
            System.out.println("Size:");
            size = Float.parseFloat(input.nextLine());
            product = new SSD(name, size, cost, stock, description);
            break;
        default:
            System.out.println("Unknown product type");
            break;

        }
        try {
            this.products = Manager.addX(products.length, products, product);

        } catch (Exception e) {
            System.out.println("Something failed");
        }

    }

    public void printt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sort by:[Name,Cost,Stock,Type]");
        String s = input.nextLine();
        Product[] ls = sortby(s);
        String lim = "+" + stringMultiply("-", this.charl[0]) + "+" + stringMultiply("-", this.charl[1]) + "+"
                + stringMultiply("-", this.charl[2]) + "+" + stringMultiply("-", this.charl[3]) + "+\n";
        String top = lim + "| Name" + stringMultiply(" ", this.charl[0] - 5) + "| Cost"
                + stringMultiply(" ", this.charl[1] - 5) + "| Stock" + stringMultiply(" ", this.charl[2] - 6) + "| Type"
                + stringMultiply(" ", this.charl[3] - 5) + "|\n" + lim;
        System.out.println(top);
        for (int i = 0; i < ls.length; i++) {
            System.out.println("| " + ls[i].getname() + stringMultiply(" ", this.charl[0] - ls[i].getname().length())
                    + "| " + String.valueOf(ls[i].getcost())
                    + stringMultiply(" ", this.charl[1] - String.valueOf(ls[i].getcost()).length()) + "| "
                    + String.valueOf(ls[i].getstock())
                    + stringMultiply(" ", this.charl[2] - String.valueOf(ls[i].getstock()).length()) + "| "
                    + ls[i].gettype() + stringMultiply(" ", this.charl[3] - ls[i].gettype().length()) + "|\n" + lim);
        }
    }

    public void save() {
        String fileContent = "";

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].tostring());
            fileContent += products[i].tostring();
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

    public void load() {
        String rawdata = "";
        String[] spliteddata = new String[1];
        try {
            File file = new File("data.txt");
            Scanner sc = new Scanner(file);

            // we just need to use \\Z as delimiter
            while (sc.hasNextLine()) {
                rawdata += sc.nextLine();
            }
            spliteddata = Manager.mysplitter(rawdata, "[/]");
            System.out.println(spliteddata[0]);
            

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
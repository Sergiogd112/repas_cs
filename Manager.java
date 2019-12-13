import java.util.Scanner;

class Manager {

    private Product[] products = new Product[0];
    private int[] charl={5,5,6,5};

    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
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

    public static void sortbyColumn(String arr[][], int col) {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<String[]>() {

            @Override
            // Compare values according to columns
            public String compare(final String[] entry1, final String[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                
                if (entry1[col].length() > entry2[col].length()){
                    for(int i = 0; i<entry2[col].length();i++){
                        if(entry1[col][i]>entry2[col][i]){
                            return 1;
                        }else if (entry1[col][i]<entry2[col][i]) {
                            return -1;
                        }
                    }
                    return 1;
                }else{
                    for(int i = 0; i<entry1[col].length();i++){
                        if(entry1[col][i]>entry2[col][i]){
                            return 1;
                        }else if (entry1[col][i]<entry2[col][i]) {
                            return -1;
                        }
                    }
                }
            }
        }); // End of function call sort().
    }

    public Product[] sortby(String mode){
        Product[] list=this.products;
        String[][] lists2= new String[list.length][2];
        Product[] outlist=new Product[list.length];
        switch (mode) {
            case "Cost":

                for(int i=0;i<list.length;i++){
                    list2[i]=[String.valueOf(list[i].get_cost()),String.valueOf(i);
                }
                sortbyColumn(list2,0);
                for (int i = 0; i < list2.length; i++) { 
                     oulist[i]=list[list[i][1]]
                } 
            case "Name":
                String[][] lists2= new String[list.length][];
                for(int i=0;i<list.length;i++){
                    list2[i]=[list[i].get_name(),String.valueOf(i);
                }
                sortbyColumn(list2,0);
                for (int i = 0; i < list2.length; i++) { 
                    oulist[i]=list[list[i][1]]
               } 
            case "Type":
                for(int i=0;i<list.length;i++){
                    list2[i]=[String.valueOf(list[i].get_cost()),String.valueOf(i);
                }
                sortbyColumn(list2,0);
                for (int i = 0; i < list2.length; i++) { 
                    oulist[i]=list[list[i][1]]
                } 
            case "Stock":
                for(int i=0;i<list.length;i++){
                    list2[i]=[String.valueOf(list[i].get_cost()),String.valueOf(i);
                }
                sortbyColumn(list2,0);
                for (int i = 0; i < list2.length; i++) { 
                    oulist[i]=list[list[i][1]]
                } 
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
        if(type.length()>charl[3]){
            charl[3]=type.length();
        }
        System.out.println("Name:");
        String name = input.nextLine();
        if(name.length()>charl[0]){
            charl[0]=type.length();
        }
        System.out.println("Description");
        int n = 0;
        String description = "";
        String line;
        while (n < 2) {
            line = input.nextLine();
            description += line + "\n";
            if (line.equals("")) {
                n += 1;
            } else {
                n = 0;
            }
        }

        System.out.println("Stock:");
        int stock = Integer.parseInt(input.nextLine());
        if(String.valueOf(stock).length()>charl[3]){
            charl[2]=String.valueOf(stock).length();
        }
        System.out.println("Cost:");
        float cost = Float.parseFloat(input.nextLine());
        if(String.valueOf(cost).length()>charl[1]){
            charl[1]=String.valueOf(cost).length();
        }
        Product product=new Product();
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
                product=new Periferal();
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
            this.products=Manager.addX(products.length, products, product);

        } catch (Exception e) {
            System.out.println("Something failed");
        }
        
    }

    public void printt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sort by:[Name,Cost,Stock,Type]");
        String s=input.nextLine();
        Product[] ls=sortby(s);
        String lim="+"+stringMultiply("-", this.charl[0])+
                   "+"+stringMultiply("-", this.charl[1])+
                   "+"+stringMultiply("-", this.charl[2])+
                   "+"+stringMultiply("-", this.charl[3])+"+\n";
        String top=lim+
                   "| Name"+stringMultiply(" ", this.charl[0]-5)+
                   "| Cost"+stringMultiply(" ", this.charl[1]-5)+
                   "| Stock"+stringMultiply(" ", this.charl[2]-6)+
                   "| Type"+stringMultiply(" ", this.charl[3]-5)+"|\n"+
                   lim;
        System.out.println(top);
        for(int i=0;i<ls.length;i++){
            System.out.println(
                "| "+ls[i].get_name()+stringMultiply(" ", this.charl[0]-ls[i].get_name().length)+
                "| "+ls[i].get_cost()+stringMultiply(" ", this.charl[1]-ls[i].get_cost().length)+
                "| "+ls[i].get_stock()+stringMultiply(" ", this.charl[2]-ls[i].get_stock().length)+
                "| "+ls[i].get_type()+stringMultiply(" ", this.charl[3]-ls[i].get_type().length)+"|\n"+
                lim
            );
        }
    }
    public void save() {
        String fileContent = "";
        for(int i=0; i<products.length;i++){
            fileContent+=products[i].tostring();
        }
        FileWriter fileWriter = new FileWriter("data.txt");
        fileWriter.write(fileContent);
        fileWriter.close();
    }
}
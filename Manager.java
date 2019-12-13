import java.util.Scanner;

class Manager {
    private Product[] products = new Product[1];
    public static Product[] addX(int n, Product arr[], Product x) 
    { 
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
    public static void sortbyColumn(int arr[][], int col) {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1, final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        }); // End of function call sort().
    }

    public Product[] sortby(String mode){
        list=this.products;
        switch (mode) {
            case "Cost":
                String[][] lists2= new String[list.length][2];
                Product[] outlist=new Product[list.length];
                for(i=0;i<list.length;i++){
                    list2[i]=[String.valueOf(list[i].get_cost()),String.valueOf(i);
                }
                sortbyColumn(list2,0);
                for (int i = 0; i < list2.length; i++) { 
                     oulist[i]=list[list[i][1]]
                } 
            case "Name":
                String[][] lists2= new String[list.length][];
                for(i=0;i<list.length;i++){
                    list2[i]=[list[i].get_name(),String.valueOf(i);
                }
                sortbyColumn(list2,0);
                for (int i = 0; i < list2.length; i++) { 
                    for (int j = 0; j < list2[i].length; j++) 
                        System.out.print(lists2[i][j] + " "); 
                    System.out.println(); 
                } 
            case "Type":
            case "Stock":
            default:
                sort_by_name(list);
        }
        
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
        System.out.println("Name:");
        String name = input.nextLine();
        System.out.println("Description");
        int n = 0;
        String description = "";
        while (n < 2) {
            line = input.nextLine();
            description += line + "\n";
            if (line.equals("\n")) {
                n += 1;
            } else {
                n = 0;
            }
        }

        System.out.println("Stock:");
        int stock = Integer.parseInt(input.nextLine());
        System.out.println("Cost:");
        float cost = Float.parseFloat(input.nextLine());

        switch (type) {
        case "CPU":
            System.out.println("Clockspeed:");
            float clockspeed = Float.parseFloat(input.nextLine());
            System.out.println("Cores:");
            int cores = Integer.parseInt(input.nextLine());
            Cpu product = new Cpu(name, cores, cost, stock, description, clockspeed);
        case "Screen":
            System.out.println("Size:");
            float size = Float.parseFloat(input.nextLine());
            Screen product = new Screen(name, size, cost, stock, description);
        case "Mouse":
            System.out.println("Pullrate:");
            float pullrate = Float.parseFloat(input.nextLine());
            System.out.println("Wireless:[0,1]");
            boolean wireless = Boolean.parseBoolean(input.nextLine());
            Mouse product = new Mouse(name, pullrate, cost, stock, description, wireless);
        case "HardDrive":
            System.out.println("Size:");
            float size = Float.parseFloat(input.nextLine());
            HardDrive product = new HardDrive(name, size, cost, stock, description);
        case "SSD":
            System.out.println("Size:");
            float size = Float.parseFloat(input.nextLine());
            SSD product = new SSD(name, size, cost, stock, description);
        default:
            System.out.println("Unknown product type");

        }
        try {
            this.products=Manager.addX(products.length, products, product);

        }
    }
    public void printt() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sort by:[Name,Cost,Stock,Type]");
        String s=input.nextLine();
        switch (s) {
            case "Name":
                
            case "Cost":
            case "Stock":
            case "Type":

            default:
                System.out.println("Mode not found");;
        }
        for(int i=0;i<products.length;i++){

        }
    }
}
class Manager{
    private Product[] products=new Product[];

    public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
    public Product[] sortby(String mode){
        list=this.products;
        switch (mode) {
            case 'cost':
                String[][] lists2= new String[list.length][];
                for(i=0;i<list.length;i++){
                    list2[i]=[String.valueOf(list[i].get_cost()),String.valueOf(i);
                }
                sortbyColumn(list2,0);
                for (int i = 0; i < list2.length; i++) { 
                    for (int j = 0; j < list2[i].length; j++) 
                        System.out.print(lists2[i][j] + " "); 
                    System.out.println(); 
                } 
            case 'name':
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
            case 'type':
            case 'stock':
            default:
                sort_by_name(list);
        }
        
    }
    public  Product[] sort_by_original(String[][] list) {
        Product[] sorted=new Product[this.products.length];
        for(int i;i<this.products.length;i++){
            sorted[i]=this.products[Integer.parseInt(list[i][1])];
        }
        return sorted;
    }
}
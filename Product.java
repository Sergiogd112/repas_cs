class Product {
    private String name;
    private String description;
    private int stock;
    private float cost;
    private String type;

    public String gettype() {
        return this.type;
    }

    public int getstock() {
        return stock;
    }

    public String getname() {
        return this.name;
    }

    public String getdescription() {
        return this.description;
    }

    public float getcost() {
        return this.cost;
    }

    public void settype(String type) {
        this.type = type;
    }

    public void setstock(int stock) {
        this.stock = stock;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public void setcost(float cost) {
        this.cost = cost;
    }

    public String tostring() {
        return this.gettype() + "{/}" + this.getname() + "{/}" + this.getdescription() + "{/}"
                + String.valueOf(this.getstock()) + "{/}" + String.valueOf(this.getcost()) + "[/]";
    }
    public static Product fromstring(String text) {
        String type = Manager.mysplitter(text, "{/}")[0];
        switch (type) {
            case "screen":
                
                break;
            case "cpu":
                break;
            case  "ssd":
                break;
            case "hdd"
            default:
                break;
        }
    }

}
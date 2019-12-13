class SSD extends Product {
    private float size;

    public SSD(String name, float size, float cost, int stock, String description) {
        this.settype("ssd");
        this.setname(name);
        this.size = size;
        this.setcost(cost);
        this.setstock(stock);
        this.setdescription(description);
    }

    public String tostring() {
        return this.getname() + "{/}" + this.getdescription() + "{/}" + String.valueOf(this.getstock()) + "{/}"
                + String.valueOf(this.getcost()) + "{/}" + Float.toString(this.size) + "[/]";
    }
}
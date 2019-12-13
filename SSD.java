class SSD extends Product{
    private float size;

    public  SSD(String name,float size,float cost,int stock,String description) {
        this.settype("ssd");
        this.setname(name);
        this.size=size;
        this.setcost(cost);
        this.setstock(stock);
        this.setdescription(description);
    }
}
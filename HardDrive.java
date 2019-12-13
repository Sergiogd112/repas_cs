class HardDrive extends Product{
    private float size;

    public  HardDrive(String name,float size,float cost,int stock,String description) {
        this.settype("hdd");
        this.setname(name);
        this.size=size;
        this.setcost(cost);
        this.setstock(stock);
        this.setdescription(description);
    }
}
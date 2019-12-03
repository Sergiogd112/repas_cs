class Screen extends Product {
    private float size;

    public void  Screen(String name,float size,float cost,int stock,String description) {
        this.settype("screen");
        this.setname(name);
        this.size=size;
        this.setcost(cost);
        this.setstock(stock);
        this.setdescription(description);
    }
}
class Cpu extends Product {
    private float clockspeed;
    private int cores;

    public Cpu(String name, int cores, float cost, int stock, String description, float clockspeed) {
        this.cores = cores;
        this.clockspeed = clockspeed;
        this.settype("cpu");
        this.setname(name);
        this.setcost(cost);
        this.setstock(stock);
        this.setdescription(description);
    }

    public String tostring() {
        return this.getname() + "{/}" + this.getdescription() + "{/}" + String.valueOf(this.getstock()) + "{/}"
                + String.valueOf(this.getcost()) + "{/}" + String.valueOf(this.cores) + "{/}"
                + String.valueOf(this.clockspeed) + "[/]";
    }
}
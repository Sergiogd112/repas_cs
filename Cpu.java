class Cpu extends Product{
    String type="cpu";
    private float clockspeed;
    private int cores;

    public Cpu(String name,int cores, float cost,int stock,String description, float clockspeed){
        this.name=name;
        this.cores=cores;
        this.clockspeed=clockspeed;
        this.cost=cost;
        this.stock=stock;
        this.description=description;
    }
}
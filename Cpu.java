Class Cpu Extends Product{
    type="cpu";
    private float clockspeed;
    private int cores;

    public void  Cpu(name,cores,cost,stock,description,clockspeed){
        this.name=name;
        this.cores=cores;
        this.clockspeed=clockspeed;
        this.cost=cost;
        this.stock=stock;
        this.description=description;
    }
}
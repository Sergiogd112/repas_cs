Class Mouse Extends Periferals{
    private String subtype="mouse";
    private float pullrate;
    private boolean wireless;

    public void  Mouse(name,pullrate,cost,stock,description,wireless){
        this.name=name;
        this.pullrate=pullrate;
        this.wireless=wireless;
        this.cost=cost;
        this.stock=stock;
        this.description=description;
    }
}
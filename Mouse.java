Class Mouse Extends Periferals{
    private String subtype="mouse";
    private float pullrate;
    private boolean wireless;

    public void  Mouse(String name,float pullrate,float cost,int stock,String description,boolean wireless){
        this.name=name;
        this.pullrate=pullrate;
        this.wireless=wireless;
        this.cost=cost;
        this.stock=stock;
        this.description=description;
    }
}
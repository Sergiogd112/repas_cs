class Mouse extends Periferal {
    private float pullrate;
    private boolean wireless;

    public Mouse(String name, float pullrate, float cost, int stock, String description, boolean wireless) {
        this.settype("periferal");
        this.setname(name);
        this.setcost(cost);
        this.setstock(stock);
        this.setdescription(description);
        this.setsubtype("mouse");
        this.pullrate = pullrate;
        this.wireless = wireless;
    }

    public String tostring() {
        return this.gettype() + "{/}" + this.getsubtype() + "{/}" + this.getname() + "{/}" + this.getdescription()
                + "{/}" + String.valueOf(this.getstock()) + "{/}" + String.valueOf(this.getcost()) + "{/}"
                + Float.toString(this.pullrate) + "{/}" + Boolean.toString(this.wireless) + "[/]";
    }
}
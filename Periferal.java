class Periferal extends Product{
    private String subtype;
    public  Periferal() {
        this.settype("periferal");
    }
    public void setsubtype(String sub) {
        this.subtype=sub;
    }
    public String getsubtype() {
        return this.subtype;
    }
}
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
    public static Periferal perifarr(String[] arr) {
        Periferal perif =new Periferal();
        switch (arr[1]) {
            case "mouse":
                perif=new Mouse(arr[2], Float.parseFloat(arr[6]), Float.parseFloat(arr[5]), Integer.parseInt(arr[4]), arr[3], Boolean.parseBoolean(arr[7]));
                break;
        
            default:
                break;
        }
        return perif;
    }
}
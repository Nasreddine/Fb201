package Model;

public class Order {
    static int orderSysId = 0;
    int orderId, providerId;
    String barcode;
    String cliWilaya, cliName, cliFname, cliPhoneNum, cliEmail, cliAdress, cliCity;
    int orderQte;
    double orderPrice;
    String orderDescription;

    public Order(int providerId, String cliWilaya, double orderPrice){
        orderSysId++;
        this.orderId = orderSysId;
        this.providerId = providerId;
        this.cliWilaya = cliWilaya;
        this.orderPrice = orderPrice;
    }
    public Order(int orderId, int providerId, String barcode, String cliWilaya, String cliName, String cliFname, String cliPhoneNum, String cliEmail, String cliAdress, String cliCity, int orderQte, double orderPrice, String orderDescription) {
        orderSysId++;
        this.orderId = orderSysId;
        this.providerId = providerId;
        this.barcode = barcode;
        this.cliWilaya = cliWilaya;
        this.cliName = cliName;
        this.cliFname = cliFname;
        this.cliPhoneNum = cliPhoneNum;
        this.cliEmail = cliEmail;
        this.cliAdress = cliAdress;
        this.cliCity = cliCity;
        this.orderQte = orderQte;
        this.orderPrice = orderPrice;
        this.orderDescription = orderDescription;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCliWilaya() {
        return cliWilaya;
    }

    public void setCliWilaya(String cliWilaya) {
        this.cliWilaya = cliWilaya;
    }

    public String getCliName() {
        return cliName;
    }

    public void setCliName(String cliName) {
        this.cliName = cliName;
    }

    public String getCliFname() {
        return cliFname;
    }

    public void setCliFname(String cliFname) {
        this.cliFname = cliFname;
    }

    public String getCliPhoneNum() {
        return cliPhoneNum;
    }

    public void setCliPhoneNum(String cliPhoneNum) {
        this.cliPhoneNum = cliPhoneNum;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliAdress() {
        return cliAdress;
    }

    public void setCliAdress(String cliAdress) {
        this.cliAdress = cliAdress;
    }

    public String getCliCity() {
        return cliCity;
    }

    public void setCliCity(String cliCity) {
        this.cliCity = cliCity;
    }

    public int getOrderQte() {
        return orderQte;
    }

    public void setOrderQte(int orderQte) {
        this.orderQte = orderQte;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}

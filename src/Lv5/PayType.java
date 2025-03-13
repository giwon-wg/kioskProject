package Lv5;

public enum PayType {
    CREDITCASH("CREDIT CASH"), ATMCARD("ATM CARD"), CASH("CASH");

    private final String paytypes;

    PayType(String paytypes){
        this.paytypes = paytypes;
    }

    public String getPaytypes(){
        return paytypes;
    }
}

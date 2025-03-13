package Lv5;

public enum Discount {
    PDS(0.1), MILL(0.05), STU(0.03), NON(0.0);

    private final double discounType;

    Discount(double discounType){
        this.discounType = discounType;
    }

    public double getDiscounType(){
        return discounType;
    }
}

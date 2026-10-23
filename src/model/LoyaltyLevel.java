package model;

public enum LoyaltyLevel {
    BRONZE(0.0),
    SILVER(0.5),
    GOLD(0.10);

    private final double discount;

    LoyaltyLevel(double discount){
        this.discount = discount;
    }
    public double getDiscount(){
        return discount;
    }
}

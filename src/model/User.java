package model;

public class User {
    private final int id;
    private final String name;
    private  double balance;
    private final  LoyaltyLevel loyaltyLevel;


    private User(Builder builder ){
        this.id = builder.id;
        this.name = builder.name;
        this.balance = builder.balance;
        this.loyaltyLevel = builder.loyaltyLevel;
    }
    public static Builder builder(){
        return  new Builder();
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public double getBalance(){return balance;}
    public LoyaltyLevel getLoyaltyLevel(){return loyaltyLevel;}

    public void setBalance(double balance){
        this.balance = balance;
    }
    @Override
    public String toString(){
        return "User{" + "id=" + id + ", name='" + name + '\'' +
                ", balance=" + balance + ", loyaltyLevel=" + loyaltyLevel + '}';
    }
    public static class Builder{
        private int id;
        private String name;
        private double balance = 0.0;
        private  LoyaltyLevel loyaltyLevel = LoyaltyLevel.BRONZE;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder name (String name){
            this.name = name;
            return this;
        }
        public Builder balance(double balance){
            this.balance = balance;
            return this;
        }
        public Builder loyaltyLevel(LoyaltyLevel loyaltyLevel){
            this.loyaltyLevel = loyaltyLevel;
            return this;
        }
        public User build(){
            return new User(this);
        }

    }
}

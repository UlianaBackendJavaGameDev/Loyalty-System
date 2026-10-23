package model;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private final int id;
    private final int userId;
    private final List<Product> products;
    private final double finalAmount;

    private Order(Builder builder){
        this.id = builder.id;
        this.userId = builder.userId;
        this.products = builder.products;
        this.finalAmount = builder.finalAmount;
    }
    public static Builder builder(){
        return new Builder();
    }
    public int getId(){return id;}
    public int getUserId(){return userId;}
    public List<Product> getProducts(){return products;}
    public double getFinalAmount(){return finalAmount;}


    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId +
                ", productsCount=" + products.size() + ", finalAmount=" + finalAmount + '}';
    }
        public static class Builder{
            private int id;
            private int userId;
            private List<Product> products = new ArrayList<>();
            private double finalAmount;

            public Builder id(int id){
                this.id = id;
                return this;
            }
            public Builder userId(int userId){
                this.userId = userId;
                return this;
            }
            public Builder products(List<Product> products){
                this.products = products;
                return this;
            }
            public Builder finalAmount(double finalAmount){
                this.finalAmount = finalAmount;
                return this;
            }
            public Order build(){
                return new Order(this);
            }
        }


    }


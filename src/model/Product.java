package model;

public class Product {
    private final int id;
    private final String title;
    private final double price;
    private final String category;

    private Product(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.price = builder.price;
        this.category = builder.category;
    }
    public static Builder builder(){
        return new Builder();
    }
    public int getId(){return id;}
    public String getTitle(){return title;}
    public double getPrice(){return price;}
    public String getCategory(){return category;}

    @Override
    public String toString(){
        return "Product{" + "id=" + id + ", title='" + title + '\'' +
                ", price=" + price + ", category='" + category + '\'' + '}';
    }
    public  static class Builder{
        private int id;
        private String title;
        private double price;
        private String category;


        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder Price(double price){
            this.price = price;
            return this;
        }
        public Builder category(String category){
            this.category = category;
            return this;
        }
        public Product  build(){
            return new Product(this);
        }

    }


}

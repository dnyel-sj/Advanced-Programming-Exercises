package myRemote;

import java.io.Serializable;

public class Order implements Serializable {
    private String customerName;
    private String foodName;
    private long price;
    private long paymentTrackingCode;

    public Order() {

    }

    public Order(String customerName, String foodName, long price, long paymentTrackingCode) {
        this.customerName = customerName;
        this.foodName = foodName;
        this.price = price;
        this.paymentTrackingCode = paymentTrackingCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getFoodName() {
        return foodName;
    }

    public Order setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Order setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getPaymentTrackingCode() {
        return paymentTrackingCode;
    }

    public Order setPaymentTrackingCode(long paymentTrackingCode) {
        this.paymentTrackingCode = paymentTrackingCode;
        return this;
    }
}
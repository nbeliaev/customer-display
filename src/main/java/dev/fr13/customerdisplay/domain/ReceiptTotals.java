package dev.fr13.customerdisplay.domain;

public class ReceiptTotals {
    private String discount;
    private String amount;

    public ReceiptTotals() {
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ReceiptTotals{" +
                "discount='" + discount + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

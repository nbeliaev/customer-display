package dev.fr13.customerdisplay.domain;

@SuppressWarnings("unused")
public class Message {
    private Cashier cashier;
    private String customer;
    private String head;
    private String body;
    private ReceiptTotals totals;

    public Message() {
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ReceiptTotals getTotals() {
        return totals;
    }

    public void setTotals(ReceiptTotals totals) {
        this.totals = totals;
    }

    @Override
    public String toString() {
        return "Message{" +
                "cashier=" + cashier +
                ", customer='" + customer + '\'' +
                ", head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", totals=" + totals +
                '}';
    }
}

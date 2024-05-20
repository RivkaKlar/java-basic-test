package test.rivky.veig;

import java.time.LocalDate;

public class Transaction {
    private String id;
    private String description;
    private LocalDate date;
    private String price;

    public Transaction(String id, String description, LocalDate date, String price) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

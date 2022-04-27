package mk.ukim.finki.wpproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Integer quantity;

    private String address;

    private String customerMail;

    private String customerName;

    private String customerSurname;

    public Order() {

    }

    public Order(String productName,  Integer quantity, String address,
                 String customerMail, String customerName, String customerSurname) {
        this.productName = productName;
        this.quantity = quantity;
        this.address = address;
        this.customerMail = customerMail;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
    }
}
